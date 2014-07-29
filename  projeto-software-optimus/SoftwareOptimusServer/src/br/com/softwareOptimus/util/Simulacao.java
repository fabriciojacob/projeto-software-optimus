package br.com.softwareOptimus.util;

import java.util.ArrayList;
import java.util.List;

import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.entidades.RN.EmpresaRN;
import br.com.softwareOptimus.entidades.RN.geral.MunicipioRN;

public class Simulacao {
	
	public static void main(String[] args) {
		List<Logradouro> obj = new ArrayList<>();
		EmpresaRN rn = new EmpresaRN();
		//obj = rn.listaLogr();
		
		for(Logradouro e : obj){
			System.out.println(e.getEndereco());
			System.out.println(e.getMunicipio().getDescricao());
			System.out.println(e.getMunicipio().getUf().getDescricao());
		}
		
	}

}
