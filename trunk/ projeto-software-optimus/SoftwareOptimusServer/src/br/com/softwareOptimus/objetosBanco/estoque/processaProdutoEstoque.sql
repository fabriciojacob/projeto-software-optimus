create or replace package body estoque
as
procedure processaProdutoEstoque(varCustoMedio    In Number,
                                                   varData          In Date,
                                                   varJustificativa In VarChar2,
                                                   varQuantEntrada  In Number,
                                                   varQuantSaida    In Number,
                                                   varTipoMovEst    In Integer,
                                                   varProduto       In Number,
                                                   varEmpresa       In Number,
                                                   varCustoNota     In Number,
                                                   varTotalNota     In Number,
                                                   varOrigem        In Number,
                                                   varPisCofinsNota In Number,
                                                   varFreteNota     In Number,
                                                   varIpiNota       In Number,
                                                   varIcmsNota      In Number,
                                                   varDespesaNota   In Number,
                                                   varSituacao      In Varchar2) is
  varQuantidade Numeric(16, 2);
  varSaldo      Numeric(16, 2);
  varTotalCusto Numeric(16, 2);
begin
  Begin
    SELECT NVL(saldo, 0)
      INTO varQuantidade
      FROM tbprodutoestoque
     WHERE (to_char(data, 'DDMMYYYY') || Idprodest) IN
           (SELECT MAX(to_char(tbEst.data, 'DDMMYYYY') || tbEst.Idprodest) AS data
              FROM tbProdutoEstoque tbEst
             WHERE tbEst.produto = varProduto
               AND tbEst.empresa = varEmpresa
               AND tbEst.data <= varData);
  Exception
    When No_Data_Found Then
      varQuantidade := 0;
  End;
  if (Upper(varSituacao) = Upper('Insere')) then
    if (varTipoMovEst IN (0, 3, 4)) then
      varSaldo := varQuantidade + varQuantEntrada;
    else
      varSaldo := ABS(varQuantidade - varQuantSaida);
    end if;
    varTotalCusto := varSaldo * varCustoMedio;
    Insert Into tbProdutoEstoque NoLogging
      (idProdEst,
       custoMedio,
       data,
       justificativa,
       quantEntrada,
       quantSaida,
       quantidade,
       saldo,
       tipoMovEst,
       totalCusto,
       produto,
       empresa,
       totalNota,
       custoNota,
       idComercial,
       despesaNota,
       IcmsNota,
       IpiNota,
       pisCofinsNota,
       freteNota)
    Values
      (procEstoque.Nextval,
       varCustoMedio,
       varData,
       varJustificativa,
       varQuantEntrada,
       varQuantSaida,
       varQuantidade,
       --Tratar se for negativo na aplicação
       varSaldo,
       varTipoMovEst,
       varTotalCusto,
       varProduto,
       varEmpresa,
       varTotalNota,
       varCustoNota,
       varOrigem,
       varDespesaNota,
       varIcmsNota,
       varIpiNota,
       varPisCofinsNota,
       varFreteNota);
    For tabProcess In (SELECT Rownum, tb.*
                         FROM (SELECT to_char(tbEst.data, 'DDMMYYYY') ||
                                      tbEst.Idprodest,
                                      tbEst.*
                                 FROM tbProdutoEstoque tbEst
                                WHERE tbEst.produto = varProduto
                                  AND tbEst.empresa = varEmpresa
                                  AND tbEst.data > varData
                                order by to_char(tbEst.data, 'DDMMYYYY') ||
                                         tbEst.Idprodest) tb) Loop
      if (tabProcess.Rownum = 1) then
        /*varQuantidade é o saldo da linha anterior*/
        varQuantidade := varSaldo;
      end if;
      update Tbprodutoestoque
         set quantidade = varQuantidade
       where Idprodest = tabProcess.Idprodest;

      if (tabProcess.Tipomovest IN (0, 3, 4)) then
        varSaldo := varQuantidade + tabProcess.Quantentrada;
      else
        varSaldo := ABS(varQuantidade - tabProcess.Quantsaida);
      end if;
      varQuantidade := varSaldo;
      varTotalCusto := varSaldo * tabProcess.Customedio;

      update tbProdutoEstoque
         set saldo = varSaldo, totalcusto = varTotalCusto
       where Idprodest = tabProcess.Idprodest;
    End Loop;
  end if;
  --if (Upper(varSituacao) = Upper('Atualiza')) then

  --end if;
End;
end estoque;
