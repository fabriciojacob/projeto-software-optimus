--PARA ORACLE UTILIZAR DESTA FORMA
--INSERT INTO tbCST (id, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('01'),Trim('Operação Tributável - Base de Cálculo = Valor da Operação Alíquota Normal (Cumulativo/Não Cumulativo)'),1,1);

--> SAIDA
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('01'),Trim('Operação Tributável - Base de Cálculo = Valor da Operação Alíquota Normal (Cumulativo/Não Cumulativo)'),1,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('02'),Trim('Operação Tributável - Base de Calculo = Valor da Operação (Alíquota Diferenciada)'),1,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('03'),Trim('Operação Tributável - Base de Calculo = Quantidade Vendida x Alíquota por Unidade de Produto'),1,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('04'),Trim('Operação Tributável - Tributação Monofásica - (Alíquota Zero)'),1,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('01'),Trim('Operação Tributável com Alíquota Básica'),1,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('02'),Trim('Operação Tributável com Alíquota Diferenciada'),1,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('03'),Trim('Operação Tributável com Alíquota por Unidade de Medida de Produto'),1,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('04'),Trim('Operação Tributável Monofásica - Revenda a Alíquota Zero'),1,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('05'),Trim('Operação Tributável por Substituição Tributária'),1,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('06'),Trim('Operação Tributável a Alíquota zero'),1,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('07'),Trim('Operação Isenta da Contribuição'),1,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('08'),Trim('Operação sem Incidência da Contribuição'),1,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('09'),Trim('Operação com Suspensão da Contribuição'),1,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('49'),Trim('Outras Operações de Saída'),1,1);

--> ENTRADA
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('50'),Trim('Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('51'),Trim('Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('52'),Trim('Operação com Direito a Crédito - Vinculada Exclusivamente a Receita de Exportação'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('53'),Trim('Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('54'),Trim('Operação com Direito a Crédito - Vinculada a Receitas Tributadas no Mercado Interno e de Exportação'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('55'),Trim('Operação com Direito a Crédito - Vinculada a Receitas Não Tributadas no Mercado Interno e de Exportação'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('56'),Trim('Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno e de Exportação'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('60'),Trim('Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Tributada no Mercado Interno'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('61'),Trim('Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('62'),Trim('Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita de Exportação'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('63'),Trim('Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('64'),Trim('Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas no Mercado Interno e de Exportação'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('65'),Trim('Crédito Presumido - Operação de Aquisição Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('66'),Trim('Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno e de Exportação'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('67'),Trim('Crédito Presumido - Outras Operações'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('70'),Trim('Operação de Aquisição sem Direito a Crédito'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('71'),Trim('Operação de Aquisição com Isenção'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('72'),Trim('Operação de Aquisição com Suspensão'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('73'),Trim('Operação de Aquisição a Alíquota Zero'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('74'),Trim('Operação de Aquisição sem Incidência da Contribuição'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('75'),Trim('Operação de Aquisição por Substituição Tributária'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('98'),Trim('Outras Operações de Entrada'),0,1);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('99'),Trim('Outras Operações'),0,1);
