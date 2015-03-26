create or replace package pkg_financeiro is

  procedure addParcelas(id in integer, operacao in integer);

end pkg_financeiro;
