package br.com.softwareOptimus.financeiro.bens;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.financeiro.FormaPgto;

@FacesConverter(forClass = FormaPgto.class)
public class FormaPgtoConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (FormaPgto) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof FormaPgto) {
			FormaPgto entity = (FormaPgto) value;
			if (entity != null && entity instanceof FormaPgto
					&& entity.getIdFormaPg() != null) {
				uiComponent.getAttributes().put(
						entity.getIdFormaPg().toString(), entity);
				return entity.getIdFormaPg().toString();
			}
		}
		return "";
	}
}
