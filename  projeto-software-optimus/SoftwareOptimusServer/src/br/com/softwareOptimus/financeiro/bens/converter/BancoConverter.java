package br.com.softwareOptimus.financeiro.bens.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.financeiro.Banco;
 
@FacesConverter(forClass = Banco.class)
public class BancoConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Banco) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof Banco) {
			Banco entity = (Banco) value;
			if (entity != null && entity instanceof Banco
					&& entity.getIdBanco() != null) {
				uiComponent.getAttributes().put(
						entity.getIdBanco().toString(), entity);
				return entity.getIdBanco().toString();
			}
		}
		return "";
	}
}