package br.com.softwareOptimus.fiscal.bens;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.fiscal.Aliquota;

//@FacesConverter(value = "ClassConverter")
@FacesConverter(forClass = Aliquota.class)
public class AliquotaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Aliquota) uIComponent.getAttributes().get(
					value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof Aliquota) {
			Aliquota entity = (Aliquota) value;
			if (entity != null && entity instanceof Aliquota
					&& entity.getIdAliq() != null) {
				uiComponent.getAttributes().put(entity.getIdAliq().toString(),
						entity);
				return entity.getIdAliq().toString();
			}
		}
		return "";
	}
}
