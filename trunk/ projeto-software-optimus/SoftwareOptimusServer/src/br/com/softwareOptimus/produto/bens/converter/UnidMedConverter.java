package br.com.softwareOptimus.produto.bens.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.produto.UnidMed;

//@FacesConverter(value = "ClassConverter")
@FacesConverter(forClass = UnidMed.class)
public class UnidMedConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (UnidMed) uIComponent.getAttributes().get(
					value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof UnidMed) {
			UnidMed entity = (UnidMed) value;
			if (entity != null && entity instanceof UnidMed
					&& entity.getIdUnidMed() != null) {
				uiComponent.getAttributes().put(entity.getIdUnidMed().toString(),
						entity);
				return entity.getIdUnidMed().toString();
			}
		}
		return "";
	}
}
