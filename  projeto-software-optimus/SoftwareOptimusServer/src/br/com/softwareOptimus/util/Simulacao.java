package br.com.softwareOptimus.util;

import br.com.softwareOptimus.financeiro.Caixa;
import br.com.softwareOptimus.financeiro.RN.CaixaRN;
public class Simulacao {

	public static void main(String[] args) {
		try{
			Caixa caixa = new Caixa();
			caixa.setDescricao("Teste");
			
			CaixaRN rn = new CaixaRN();
			rn.salvar(caixa);
		
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
