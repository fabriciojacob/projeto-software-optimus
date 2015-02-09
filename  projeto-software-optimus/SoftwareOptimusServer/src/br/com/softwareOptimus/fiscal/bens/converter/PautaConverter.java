package br.com.softwareOptimus.fiscal.bens.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.fiscal.Pauta;

//@FacesConverter(value = "ClassConverter")
@FacesConverter(forClass = Pauta.class)
public class PautaConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Pauta) uIComponent.getAttributes().get(
					value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof Pauta) {
			Pauta entity = (Pauta) value;
			if (entity != null && entity instanceof Pauta
					&& entity.getIdPauta() != null) {
				uiComponent.getAttributes().put(entity.getIdPauta().toString(),
						entity);
				return entity.getIdPauta().toString();
			}
		}
		return "";
	}
}
