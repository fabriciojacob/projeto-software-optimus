--para oracle utilizar desta forma
--INSERT INTO tbCST (id, cst, descricao, io, tipocst) VALUES((SELECT COUNT(*) + 1 FROM tbCST),Trim('000'),Trim('Nacional - Tributada integralmente'),null,2);

INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('000'),Trim('Nacional - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('010'),Trim('Nacional - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('020'),Trim('Nacional - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('030'),Trim('Nacional - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('040'),Trim('Nacional - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('041'),Trim('Nacional - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('050'),Trim('Nacional - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('051'),Trim('Nacional - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('060'),Trim('Nacional - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('070'),Trim('Nacional - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('090'),Trim('Nacional - Outras'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('100'),Trim('Estrangeira - Importação direta - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('110'),Trim('Estrangeira - Importação direta - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('120'),Trim('Estrangeira - Importação direta - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('130'),Trim('Estrangeira - Importação direta - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('140'),Trim('Estrangeira - Importação direta - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('141'),Trim('Estrangeira - Importação direta - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('150'),Trim('Estrangeira - Importação direta - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('151'),Trim('Estrangeira - Importação direta - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('160'),Trim('Estrangeira - Importação direta - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('170'),Trim('Estrangeira - Importação direta - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('190'),Trim('Estrangeira - Importação direta - Outras'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('200'),Trim('Estrangeira - Adquirida no mercado interno - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('210'),Trim('Estrangeira - Adquirida no mercado interno - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('220'),Trim('Estrangeira - Adquirida no mercado interno - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('230'),Trim('Estrangeira - Adquirida no mercado interno - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('240'),Trim('Estrangeira - Adquirida no mercado interno - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('241'),Trim('Estrangeira - Adquirida no mercado interno - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('250'),Trim('Estrangeira - Adquirida no mercado interno - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('251'),Trim('Estrangeira - Adquirida no mercado interno - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('260'),Trim('Estrangeira - Adquirida no mercado interno - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('270'),Trim('Estrangeira - Adquirida no mercado interno - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('290'),Trim('Estrangeira - Adquirida no mercado interno - Outras'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('101'),Trim('Simples Nacional - Tributada pelo Simples Nacional com permissão de crédito'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('102'),Trim('Simples Nacional - Tributada pelo Simples Nacional sem permissão de crédito'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('103'),Trim('Simples Nacional - Isenção do ICMS no Simples Nacional para faixa de receita bruta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('201'),Trim('Simples Nacional - Tributada pelo Simples Nacional com permissão de crédito e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('202'),Trim('Simples Nacional - Tributada pelo Simples Nacional sem permissão de crédito e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('203'),Trim('Simples Nacional - Isenção do ICMS no Simples Nacional para faixa de receita bruta e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('300'),Trim('Simples Nacional - Imune'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('400'),Trim('Simples Nacional - Não tributada pelo Simples Nacional'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('500'),Trim('Simples Nacional - ICMS cobrado anteriormente por substituição tributária (substituído) ou por antecipação'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('900'),Trim('Simples Nacional - Outros'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('000'),Trim('Nacional, exceto as indicadas nos códigos 3 a 5 da Tabela A - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('010'),Trim('Nacional, exceto as indicadas nos códigos 3 a 5 da Tabela A - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('020'),Trim('Nacional, exceto as indicadas nos códigos 3 a 5 da Tabela A - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('030'),Trim('Nacional, exceto as indicadas nos códigos 3 a 5 da Tabela A - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('040'),Trim('Nacional, exceto as indicadas nos códigos 3 a 5 da Tabela A - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('041'),Trim('Nacional, exceto as indicadas nos códigos 3 a 5 da Tabela A - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('050'),Trim('Nacional, exceto as indicadas nos códigos 3 a 5 da Tabela A - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('051'),Trim('Nacional, exceto as indicadas nos códigos 3 a 5 da Tabela A - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('060'),Trim('Nacional, exceto as indicadas nos códigos 3 a 5 da Tabela A - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('070'),Trim('Nacional, exceto as indicadas nos códigos 3 a 5 da Tabela A - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('090'),Trim('Nacional, exceto as indicadas nos códigos 3 a 5 da Tabela A - Outras'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('000'),Trim('Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8 da Tabela A - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('010'),Trim('Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8 da Tabela A - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('020'),Trim('Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8 da Tabela A - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('030'),Trim('Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8 da Tabela A - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('040'),Trim('Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8 da Tabela A - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('041'),Trim('Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8 da Tabela A - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('050'),Trim('Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8 da Tabela A - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('051'),Trim('Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8 da Tabela A - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('060'),Trim('Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8 da Tabela A - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('070'),Trim('Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8 da Tabela A - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('090'),Trim('Nacional, exceto as indicadas nos códigos 3, 4, 5 e 8 da Tabela A - Outras'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('100'),Trim('Estrangeira - Importação direta, exceto a indicada no código 6 da Tabela A - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('110'),Trim('Estrangeira - Importação direta, exceto a indicada no código 6 da Tabela A - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('120'),Trim('Estrangeira - Importação direta, exceto a indicada no código 6 da Tabela A - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('130'),Trim('Estrangeira - Importação direta, exceto a indicada no código 6 da Tabela A - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('140'),Trim('Estrangeira - Importação direta, exceto a indicada no código 6 da Tabela A - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('141'),Trim('Estrangeira - Importação direta, exceto a indicada no código 6 da Tabela A - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('150'),Trim('Estrangeira - Importação direta, exceto a indicada no código 6 da Tabela A - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('151'),Trim('Estrangeira - Importação direta, exceto a indicada no código 6 da Tabela A - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('160'),Trim('Estrangeira - Importação direta, exceto a indicada no código 6 da Tabela A - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('170'),Trim('Estrangeira - Importação direta, exceto a indicada no código 6 da Tabela A - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('190'),Trim('Estrangeira - Importação direta, exceto a indicada no código 6 da Tabela A - Outras'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('200'),Trim('Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7 da Tabela A - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('210'),Trim('Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7 da Tabela A - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('220'),Trim('Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7 da Tabela A - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('230'),Trim('Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7 da Tabela A - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('240'),Trim('Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7 da Tabela A - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('241'),Trim('Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7 da Tabela A - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('250'),Trim('Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7 da Tabela A - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('251'),Trim('Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7 da Tabela A - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('260'),Trim('Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7 da Tabela A - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('270'),Trim('Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7 da Tabela A - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('290'),Trim('Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7 da Tabela A - Outras'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('300'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a  40% (quarenta por cento) - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('310'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a  40% (quarenta por cento) - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('320'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a  40% (quarenta por cento) - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('330'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a  40% (quarenta por cento) - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('340'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a  40% (quarenta por cento) - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('341'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a  40% (quarenta por cento) - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('350'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a  40% (quarenta por cento) - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('351'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a  40% (quarenta por cento) - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('360'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a  40% (quarenta por cento) - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('370'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a  40% (quarenta por cento) - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('390'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a  40% (quarenta por cento) - Outras'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('300'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento) e inferior ou igual a 70% (setenta por cento) - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('310'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento) e inferior ou igual a 70% (setenta por cento) - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('320'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento) e inferior ou igual a 70% (setenta por cento) - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('330'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento) e inferior ou igual a 70% (setenta por cento) - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('340'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento) e inferior ou igual a 70% (setenta por cento) - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('341'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento) e inferior ou igual a 70% (setenta por cento) - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('350'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento) e inferior ou igual a 70% (setenta por cento) - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('351'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento) e inferior ou igual a 70% (setenta por cento) - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('360'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento) e inferior ou igual a 70% (setenta por cento) - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('370'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento) e inferior ou igual a 70% (setenta por cento) - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('390'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento) e inferior ou igual a 70% (setenta por cento) - Outras'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('400'),Trim('Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11.484/07 - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('410'),Trim('Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11.484/08 - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('420'),Trim('Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11.484/09 - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('430'),Trim('Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11.484/10 - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('440'),Trim('Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11.484/11 - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('441'),Trim('Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11.484/12 - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('450'),Trim('Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11.484/13 - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('451'),Trim('Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11.484/14 - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('460'),Trim('Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11.484/15 - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('470'),Trim('Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11.484/16 - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('490'),Trim('Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11.484/17 - Outras'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('500'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40% (quarenta por cento) - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('510'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40% (quarenta por cento) - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('520'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40% (quarenta por cento) - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('530'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40% (quarenta por cento) - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('540'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40% (quarenta por cento) - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('541'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40% (quarenta por cento) - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('550'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40% (quarenta por cento) - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('551'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40% (quarenta por cento) - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('560'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40% (quarenta por cento) - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('570'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40% (quarenta por cento) - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('590'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40% (quarenta por cento) - Outras'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('600'),Trim('Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('610'),Trim('Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('620'),Trim('Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('630'),Trim('Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('640'),Trim('Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('641'),Trim('Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('650'),Trim('Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('651'),Trim('Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('660'),Trim('Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('670'),Trim('Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('690'),Trim('Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX - Outras'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('700'),Trim('Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('710'),Trim('Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('720'),Trim('Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('730'),Trim('Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('740'),Trim('Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('741'),Trim('Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('750'),Trim('Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('751'),Trim('Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('760'),Trim('Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('770'),Trim('Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('790'),Trim('Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX - Outras'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('800'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70% (setenta por cento) - Tributada integralmente'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('810'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70% (setenta por cento) - Tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('820'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70% (setenta por cento) - Com redução de base de cálculo'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('830'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70% (setenta por cento) - Isenta ou não tributada e com cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('840'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70% (setenta por cento) - Isenta'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('841'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70% (setenta por cento) - Não tributada'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('850'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70% (setenta por cento) - Suspensão'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('851'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70% (setenta por cento) - Diferimento'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('860'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70% (setenta por cento) - ICMS cobrado anteriormente por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('870'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70% (setenta por cento) - Com redução de base de cálculo e cobrança do ICMS por substituição tributária'),null,2);
INSERT INTO tbCST (cst, descricao, io, tipocst) VALUES(Trim('890'),Trim('Nacional, mercadoria ou bem com Conteúdo de Importação superior a 70% (setenta por cento) - Outras'),null,2);