package br.com.softwareOptimus.util;

import java.util.ArrayList;
import java.util.List;

import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.TipoContaBancaria;
import br.com.softwareOptimus.financeiro.RN.ContaBancariaRN;

public class Simulacao {

	public static void main(String[] args) {
		/*Banco banco = new Banco();
		BancoRN rnBanco = new BancoRN();
		try {
			banco = rnBanco.pesquisaBanco("1");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*ContaBancaria contaCorrente = new ContaBancaria();
		contaCorrente.setAgencia(9289);
		contaCorrente.setConta(981121);
		contaCorrente.setTitular("Fabricio Jacob");
		contaCorrente.setBanco(banco);
		contaCorrente.setTipoContaBancaria(TipoContaBancaria.CORRENTE);*/
		List<ContaBancaria> lista = new ArrayList<>();
		
		ContaBancariaRN rnConta = new ContaBancariaRN();
		try{
			//rnConta.salvar(contaCorrente);
			for(ContaBancaria c: lista){
				rnConta.excluirConta(c);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
