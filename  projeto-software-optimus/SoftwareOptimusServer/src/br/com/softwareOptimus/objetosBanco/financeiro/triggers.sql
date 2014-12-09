create or replace trigger seqLog
before insert or update on log_financeiro
references for each row
declare
vid log_financeiro.idlog%type;
begin
  select seqLog.nextVal into vid from dual;
  :new.idLog := vId;

end;
