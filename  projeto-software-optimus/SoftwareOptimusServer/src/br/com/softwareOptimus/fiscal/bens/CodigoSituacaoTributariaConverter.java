package br.com.softwareOptimus.fiscal.bens;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.softwareOptimus.fiscal.CodigoSituacaoTributaria;

//@FacesConverter(value = "ClassConverter")
@FacesConverter(forClass = CodigoSituacaoTributaria.class)
public class CodigoSituacaoTributariaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (CodigoSituacaoTributaria) uIComponent.getAttributes().get(
					value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof CodigoSituacaoTributaria) {
			CodigoSituacaoTributaria entity = (CodigoSituacaoTributaria) value;
			if (entity != null && entity instanceof CodigoSituacaoTributaria
					&& entity.getIdCst() != null) {
				uiComponent.getAttributes().put(entity.getIdCst().toString(),
						entity);
				return entity.getIdCst().toString();
			}
		}
		return "";
	}
}
