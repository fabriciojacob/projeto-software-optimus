package br.com.softwareOptimus.fiscal.bens;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.fiscal.PautaMVA;

//@FacesConverter(value = "ClassConverter")
@FacesConverter(forClass = PautaMVA.class)
public class PautaMVAConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (PautaMVA) uIComponent.getAttributes().get(
					value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof PautaMVA) {
			PautaMVA entity = (PautaMVA) value;
			if (entity != null && entity instanceof PautaMVA
					&& entity.getIdPautaMVA() != null) {
				uiComponent.getAttributes().put(entity.getIdPautaMVA().toString(),
						entity);
				return entity.getIdPautaMVA().toString();
			}
		}
		return "";
	}
}
