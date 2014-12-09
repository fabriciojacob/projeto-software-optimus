create or replace package body pkg_financeiro is

  procedure addparcelas(id in integer) is
    cursor c_titulo is(
      select t.* from tbTitulo t where t.idTitulo = id);
    v_parcela_condPgto tbcondpgto.parcela%type;
  begin
    for titulo in c_titulo loop
      begin
        select cond.parcela
          into v_parcela_condPgto
          from Tbcondpgto cond
         where cond.idcondpgto = titulo.condpgto_idcondpgto;
      exception
        when no_data_found then
          v_parcela_condPgto := 0;
      end;
      for parcela in 1 .. v_parcela_condPgto loop
        begin
          insert into tbTitulo
            (Idtitulo,
             Datalancamento,
             Descricao,
             Rubrica,
             Saldo,
             Status,
             Tipobaixa,
             Valor,
             Vencimento,
             Caixa_Idmovcaixa,
             Condpgto_Idcondpgto,
             Empresa_Idpessoa,
             Formapgto_Idformapg,
             Pessoa_Idpessoa)
          values
            (TITULO_SEQ.nextval,
             titulo.Datalancamento,
             titulo.descricao,
             titulo.rubrica,
             titulo.saldo,
             titulo.status,
             titulo.tipobaixa,
             round(titulo.valor / v_parcela_condPgto, 4),
             titulo.vencimento,
             titulo.Caixa_Idmovcaixa,
             titulo.Condpgto_Idcondpgto,
             titulo.Empresa_Idpessoa,
             titulo.Formapgto_Idformapg,
             titulo.Pessoa_Idpessoa);
          commit;
        exception
          when others then
            begin
              insert into log_financeiro
                (descricao, origem)
              values
                ('Problemas na inserção das parcelas do titulo',
                 titulo.idTitulo);
              commit;
            end;
            rollback;
        end;
      end loop;
    
    end loop;
  end;
end pkg_financeiro;
