create or replace package pkg_estoque is
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
                                   varSituacao      In Integer);
end pkg_estoque;
