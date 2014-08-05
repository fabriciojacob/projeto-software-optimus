package br.com.softwareOptimus.fiscal.bens;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.fiscal.CodigoSituacaoTributaria;

@FacesConverter(forClass = CodigoSituacaoTributaria.class)
public class CodigoSituacaoTributariaConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (CodigoSituacaoTributaria) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof CodigoSituacaoTributaria) {
			CodigoSituacaoTributaria entity = (CodigoSituacaoTributaria) value;
			if (entity != null && entity instanceof CodigoSituacaoTributaria
					&& entity.getId() != null) {
				uiComponent.getAttributes().put(entity.getId().toString(),
						entity);
				return entity.getId().toString();
			}
		}
		return "";
	}
}
