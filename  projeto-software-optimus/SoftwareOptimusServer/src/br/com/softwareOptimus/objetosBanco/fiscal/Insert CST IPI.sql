--PARA ORACLE UTILIZAR DESTA FORMA
--INSERT INTO tbCST (id, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('00'),Trim('Entrada com recuperação de crédito'),0,0);

--> ENTRADA
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('00'),Trim('Entrada com recuperação de crédito'),0,0);
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('01'),Trim('Entrada tributada com alíquota zero'),0,0);
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('02'),Trim('Entrada isenta'),0,0);
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('03'),Trim('Entrada não-tributada'),0,0);
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('04'),Trim('Entrada imune'),0,0);
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('05'),Trim('Entrada com suspensão'),0,0);
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('49'),Trim('Outras entradas'),0,0);

--> SAIDA
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('50'),Trim('Saída tributada'),1,0);
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('51'),Trim('Saída tributada com alíquota zero'),1,0);
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('52'),Trim('Saída isenta'),1,0);
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('53'),Trim('Saída não-tributada'),1,0);
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('54'),Trim('Saída imune'),1,0);
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('55'),Trim('Saída com suspensão'),1,0);
INSERT INTO tbCST (idCst, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('99'),Trim('Outras saídas'),1,0);