package br.com.softwareOptimus.entidades.bens.geral;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.entidades.Estado;

//@FacesConverter(value = "classeConverter")    
@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Estado) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof Estado) {
			Estado entity = (Estado) value;
			if (entity != null && entity instanceof Estado
					&& entity.getIdUf() != null) {
				uiComponent.getAttributes().put(entity.getIdUf().toString(),
						entity);
				return entity.getIdUf().toString();
			}
		}
		return "";
	}
}