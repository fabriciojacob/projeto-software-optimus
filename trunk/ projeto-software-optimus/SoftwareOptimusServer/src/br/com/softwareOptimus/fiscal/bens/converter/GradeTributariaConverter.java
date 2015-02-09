package br.com.softwareOptimus.fiscal.bens.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.fiscal.GradeTributaria;

//@FacesConverter(value = "ClassConverter")
@FacesConverter(forClass = GradeTributaria.class)
public class GradeTributariaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (GradeTributaria) uIComponent.getAttributes().get(
					value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof GradeTributaria) {
			GradeTributaria entity = (GradeTributaria) value;
			if (entity != null && entity instanceof GradeTributaria
					&& entity.getIdGradeTrib() != null) {
				uiComponent.getAttributes().put(entity.getIdGradeTrib().toString(),
						entity);
				return entity.getIdGradeTrib().toString();
			}
		}
		return "";
	}
}
