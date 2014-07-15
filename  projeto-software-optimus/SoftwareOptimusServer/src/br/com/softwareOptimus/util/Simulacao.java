package br.com.softwareOptimus.util;

import java.util.ArrayList;
import java.util.List;

import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.Municipio;
import br.com.softwareOptimus.entidades.RN.geral.EstadoRN;
import br.com.softwareOptimus.entidades.RN.geral.MunicipioRN;

public class Simulacao {
	
	public static void main(String[] args) {
		List<Estado> estados = new ArrayList<>();
		EstadoRN rnUf = new EstadoRN();
		estados = rnUf.listaEstado();
		
		List<Municipio> municipios = new ArrayList<>();
		MunicipioRN rnMun = new MunicipioRN();
		
		for(Estado e : estados){
			System.out.println(e.getDescricao());
			municipios = rnMun.listaMunicipios(e);
			for(Municipio m : municipios){
				System.out.println(m.getDescricao());
			}
		}
		
	}

}
