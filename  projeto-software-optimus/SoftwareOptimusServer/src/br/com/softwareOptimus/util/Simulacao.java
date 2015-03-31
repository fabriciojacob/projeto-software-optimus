package br.com.softwareOptimus.util;

import java.util.ArrayList;
import java.util.List;

import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.Extrato;
import br.com.softwareOptimus.financeiro.Titulo;
import br.com.softwareOptimus.financeiro.RN.ContaBancariaRN;
import br.com.softwareOptimus.financeiro.RN.ExtratoRN;
import br.com.softwareOptimus.financeiro.RN.TituloRN;

public class Simulacao {

	public static void main(String[] args) {
		Extrato extrato = new Extrato();
		Titulo titulo = new Titulo();
		TituloRN tituloRN = new TituloRN();
		ExtratoRN extratoRN = new ExtratoRN();
		List<Titulo> titulos = new ArrayList<>();
		ContaBancaria conta = new ContaBancaria();
		ContaBancariaRN contaRN = new ContaBancariaRN();
		try {
			conta = contaRN.pesquisaID((long) 41);
			//int check = tituloRN.checkBaixaTitulo((long) 106);
			titulo = tituloRN.retornaTituloBaixado((long) 99);
			extratoRN.estorno(titulo, conta, null);
			/*if (check == 0) {
				titulo = tituloRN.retornaTitulo((long) 106);

				titulo.setValor(25.00);
				titulos.add(titulo);
				extratoRN.inclusao(titulos, conta, null);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
