package br.com.softwareOptimus.produto.bens;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.produto.Grupo;

//@FacesConverter(value = "ClassConverter")
@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Grupo) uIComponent.getAttributes().get(
					value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof Grupo) {
			Grupo entity = (Grupo) value;
			if (entity != null && entity instanceof Grupo
					&& entity.getIdGrupo() != null) {
				uiComponent.getAttributes().put(entity.getIdGrupo().toString(),
						entity);
				return entity.getIdGrupo().toString();
			}
		}
		return "";
	}
}
