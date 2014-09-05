package br.com.softwareOptimus.util;

import br.com.softwareOptimus.financeiro.Caixa;
import br.com.softwareOptimus.financeiro.RN.CaixaRN;

public class Simulacao {

	public static void main(String[] args) {
		Caixa caixa = new Caixa();
		caixa.setDescricao("Comida");
		
		CaixaRN caixaRN = new CaixaRN();
		try{
			caixaRN.salvar(caixa);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
