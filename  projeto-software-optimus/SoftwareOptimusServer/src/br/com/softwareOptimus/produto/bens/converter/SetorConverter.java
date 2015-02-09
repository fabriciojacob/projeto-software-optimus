package br.com.softwareOptimus.produto.bens.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.produto.Setor;

//@FacesConverter(value = "ClassConverter")
@FacesConverter(forClass = Setor.class)
public class SetorConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Setor) uIComponent.getAttributes().get(
					value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof Setor) {
			Setor entity = (Setor) value;
			if (entity != null && entity instanceof Setor
					&& entity.getIdSetor() != null) {
				uiComponent.getAttributes().put(entity.getIdSetor().toString(),
						entity);
				return entity.getIdSetor().toString();
			}
		}
		return "";
	}
}
