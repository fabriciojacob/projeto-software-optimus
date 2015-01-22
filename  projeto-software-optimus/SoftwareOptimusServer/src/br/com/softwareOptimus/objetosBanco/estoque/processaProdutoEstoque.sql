create or replace package body pkg_estoque as
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
                                   varSituacao      In Integer) is
    varQuantidade     Numeric(16, 2);
    varId             tbprodutoestoque.idprodest%type;
    varSaldo          Numeric(16, 2);
    varDataAtual      tbprodutoestoque.data%type;
    varQEntr          tbprodutoestoque.quantEntrada%type;
    varQSai           tbprodutoestoque.quantsaida%type;
    varCusMedAtualiza tbprodutoestoque.customedio%type;
    varTotalCusto     Numeric(16, 2);
  
  begin
    /*1 - Insere
    2 - Atualiza
    3 - Deleta*/
    if (varSituacao = 1) then
      Begin
        SELECT NVL(saldo, 0)
          INTO varQuantidade
          FROM tbprodutoestoque
         WHERE (to_char(data, 'DDMMYYYY') || Idprodest) IN
               (SELECT MAX(to_char(tbEst.data, 'DDMMYYYY') ||
                           tbEst.Idprodest) AS data
                  FROM tbProdutoEstoque tbEst
                 WHERE tbEst.produto = varProduto
                   AND tbEst.empresa = varEmpresa
                   AND tbEst.data <= varData);
      Exception
        When No_Data_Found Then
          varQuantidade := 0;
      End;
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
      commit;
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
        commit;
      End Loop;
    end if;
    if (varSituacao = 2) then
      Begin
        select p.idprodest
          into varId
          from tbProdutoEstoque p
         where p.produto = varProduto
           and p.empresa = varEmpresa
           and p.idComercial = varOrigem;
      Exception
        When No_Data_Found then
          varId := 0;
      end;
      update tbProdutoEstoque tb
         set tb.custonota     = varCustoNota,
             tb.despesanota   = varDespesaNota,
             tb.fretenota     = varFreteNota,
             tb.icmsnota      = varIcmsNota,
             tb.ipinota       = varIpiNota,
             tb.justificativa = varJustificativa,
             tb.piscofinsnota = varPisCofinsNota,
             tb.totalnota     = varTotalNota
       where tb.idprodest = varId;
      commit;
      Begin
        select p.quantentrada
          into varQEntr
          from tbProdutoEstoque p
         where idprodest = varId;
      Exception
        When No_Data_Found then
          varQEntr := 0;
      end;
      Begin
        select p.quantsaida
          into varQSai
          from tbProdutoEstoque p
         where idprodest = varId;
      Exception
        When No_Data_Found then
          varQSai := 0;
      end;
      if ((varQuantSaida > 0 and varQSai <> varQuantSaida) or
         (varQuantEntrada > 0 and varQEntr <> varQuantEntrada)) then
        varSaldo          := 0;
        varTotalCusto     := 0;
        varCusMedAtualiza := varCustoMedio;
        Begin
          select p.quantidade
            into varQuantidade
            from tbProdutoEstoque p
           where p.idprodest = varId;
        Exception
          When No_Data_Found then
            varQuantidade := 0;
        end;
        if (varTipoMovEst IN (0, 3)) then
          varSaldo := varQuantidade + varQuantEntrada;
        else
          varSaldo := ABS(varQuantidade - varQuantSaida);
        end if;
        varTotalCusto := varSaldo * varCustoMedio;
        update tbProdutoEstoque tbProEst
           set tbProEst.Saldo      = varSaldo,
               tbProEst.Totalcusto = varTotalCusto,
               tbProEst.Customedio = varCustoMedio
         where tbProEst.Idprodest = varId;
        commit;
        Begin
          select p.data
            into varDataAtual
            from tbProdutoEstoque p
           where p.idprodest = varId;
        Exception
          When No_Data_Found then
            varDataAtual := Trunc(sysdate);
        end;
        For tabProcess In (SELECT Rownum, tb.*
                             FROM (SELECT to_char(tbEst.data, 'DDMMYYYY') ||
                                          tbEst.Idprodest,
                                          tbEst.*
                                     FROM tbProdutoEstoque tbEst
                                    WHERE tbEst.produto = varProduto
                                      AND tbEst.empresa = varEmpresa
                                      AND tbEst.data > varDataAtual
                                    order by to_char(tbEst.data, 'DDMMYYYY') ||
                                             tbEst.Idprodest) tb) Loop
          if (tabProcess.Tipomovest = 0) then
            varCusMedAtualiza := tabProcess.Customedio;
          end if;
          if (tabProcess.Rownum = 1) then
            varQuantidade := varSaldo;
          end if;
          if (tabProcess.Tipomovest IN (0, 3, 4)) then
            varSaldo := varQuantidade + tabProcess.Quantentrada;
          else
            varSaldo := ABS(varQuantidade - tabProcess.Quantsaida);
          end if;
          varTotalCusto := varSaldo * varCusMedAtualiza;
          update tbProdutoEstoque tb
             set tb.saldo      = varSaldo,
                 tb.quantidade = varQuantidade,
                 tb.totalcusto = varTotalCusto,
                 tb.customedio = varCusMedAtualiza
           where tb.idprodest = varId;
          varQuantidade := varSaldo;
        End Loop;
      end if;
    end if;
    if (varSituacao = 3) then
    
      declare
        cursor estDeleta is
          select to_char(tbEst.data, 'DDMMYYYY') || tbEst.Idprodest as id,
                 tbEst.*
            FROM tbProdutoEstoque tbEst
           WHERE tbEst.idComercial = varOrigem
           order by to_char(tbEst.data, 'DDMMYYYY') || tbEst.Idprodest;
      begin
        for estoque in estDeleta loop
          null;
        end loop;
      end;
    end if;
  End;
end pkg_estoque;
