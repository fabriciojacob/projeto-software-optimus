package br.com.softwareOptimus.fiscal.bens;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.fiscal.CodigoFiscalGenerico;

@FacesConverter(forClass = CodigoFiscalGenerico.class)
public class CodigoFiscalGenericoConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext,UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (CodigoFiscalGenerico) uiComponent.getAttributes().get(value);
		}
		return null;
	}
	
	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof CodigoFiscalGenerico) {
			CodigoFiscalGenerico entity = (CodigoFiscalGenerico) value;
			if (entity != null && entity instanceof CodigoFiscalGenerico
					&& entity.getId() != null) {
				uiComponent.getAttributes().put(entity.getId().toString(),
						entity);
				return entity.getId().toString();
			}
		}
		return "";
	}
}
