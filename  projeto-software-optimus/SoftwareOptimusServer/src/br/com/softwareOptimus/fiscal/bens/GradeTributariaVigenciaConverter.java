package br.com.softwareOptimus.fiscal.bens;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.fiscal.GradeTributariaVigencia;

//@FacesConverter(value = "ClassConverter")
@FacesConverter(forClass = GradeTributariaVigencia.class)
public class GradeTributariaVigenciaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (GradeTributariaVigencia) uIComponent.getAttributes().get(
					value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof GradeTributariaVigencia) {
			GradeTributariaVigencia entity = (GradeTributariaVigencia) value;
			if (entity != null && entity instanceof GradeTributariaVigencia
					&& entity.getId() != null) {
				uiComponent.getAttributes().put(entity.getId().toString(),
						entity);
				return entity.getId().toString();
			}
		}
		return "";
	}
}
