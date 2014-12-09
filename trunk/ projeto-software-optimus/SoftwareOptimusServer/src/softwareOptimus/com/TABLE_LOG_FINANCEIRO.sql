
create table log_financeiro (
idLog integer,
descricao varchar2(100), 
origem    integer not null,
constraint pk_logFinanceiro primary key (idLog),
constraint fk_logOrigem foreign key (origem) references tbTitulo (idTitulo));