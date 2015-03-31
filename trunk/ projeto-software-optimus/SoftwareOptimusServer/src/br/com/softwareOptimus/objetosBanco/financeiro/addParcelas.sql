create or replace package body pkg_financeiro is

  procedure addparcelas(id in integer, operacao in integer) is
    -- operacao 0 inclusão
    -- operacao 1 cancelamento do titulo
    cursor c_titulo is(
      select t.* from tbTitulo t where t.idTitulo = id);
    v_parcela_condPgto tbcondpgto.parcela%type;
    v_intervalo_dias   Tbcondpgto.Intervalodias%type;
    v_acumula_dias tbcondPgto.Intervalodias%type;
  begin
    for titulo in c_titulo loop
      if (operacao = 0) then
        begin
          select cond.parcela, cond.intervalodias
            into v_parcela_condPgto, v_intervalo_dias
            from Tbcondpgto cond
           where cond.idcondpgto = titulo.condpgto_idcondpgto;
        exception
          when no_data_found then
            v_parcela_condPgto := 0;
        end;
        v_acumula_dias := 0;
        for parcela in 1 .. v_parcela_condPgto loop
          begin
            v_acumula_dias := v_acumula_dias + v_intervalo_dias;
            insert into tbTitulo
              (Idtitulo,
               Datalancamento,
               Descricao,
               Rubrica,
               Status,
               Tipobaixa,
               tipoTitulo,
               Valor,
               Vencimento,
               Caixa_Idmovcaixa,
               Condpgto_Idcondpgto,
               Empresa_Idpessoa,
               Formapgto_Idformapg,
               Pessoa_Idpessoa,
               valorTitulo)
            values
              (TITULO_SEQ.nextval,
               titulo.Datalancamento,
               titulo.descricao,
               titulo.rubrica,
               titulo.status,
               titulo.tipobaixa,
               titulo.tipoTitulo,
               titulo.valor,
               titulo.Datalancamento + v_acumula_dias,
               titulo.Caixa_Idmovcaixa,
               titulo.Condpgto_Idcondpgto,
               titulo.Empresa_Idpessoa,
               titulo.Formapgto_Idformapg,
               titulo.Pessoa_Idpessoa,
               round(titulo.valortitulo / v_parcela_condPgto, 4));
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
        begin
          delete from tbTitulo t where t.idTitulo = id;
          commit;
        exception
          when others then
            begin
              rollback;
              insert into log_financeiro
                (descricao, origem)
              values
                ('Problemas na exclusão do titulo original', id);
              commit;
            end;
        end;
      else
        delete from tbTitulo t where t.idtitulo = id;
      end if;
    end loop;
  end;
end pkg_financeiro;
