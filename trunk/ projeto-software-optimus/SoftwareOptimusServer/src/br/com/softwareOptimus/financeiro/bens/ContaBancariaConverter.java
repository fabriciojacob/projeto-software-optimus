package br.com.softwareOptimus.financeiro.bens;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.softwareOptimus.financeiro.ContaBancaria;

@FacesConverter(forClass = ContaBancaria.class)
public class ContaBancariaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (ContaBancaria) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof ContaBancaria) {
			ContaBancaria entity = (ContaBancaria) value;
			if (entity != null && entity instanceof ContaBancaria
					&& entity.getIdContaBancaria() != null) {
				uiComponent.getAttributes().put(
						entity.getIdContaBancaria().toString(), entity);
				return entity.getIdContaBancaria().toString();
			}
		}
		return "";
	}

}
