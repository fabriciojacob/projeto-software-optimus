package br.com.softwareOptimus.financeiro.bens;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.financeiro.CondPgto;

@FacesConverter(forClass = CondPgto.class)
public class CondPgtoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (CondPgto) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof CondPgto) {
			CondPgto entity = (CondPgto) value;
			if (entity != null && entity instanceof CondPgto
					&& entity.getIdCondPgto() != null) {
				uiComponent.getAttributes().put(
						entity.getIdCondPgto().toString(), entity);
				return entity.getIdCondPgto().toString();
			}
		}
		return "";
	}

}
