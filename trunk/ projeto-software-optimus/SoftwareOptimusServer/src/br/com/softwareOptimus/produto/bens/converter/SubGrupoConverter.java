package br.com.softwareOptimus.produto.bens.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.produto.SubGrupo;

//@FacesConverter(value = "ClassConverter")
@FacesConverter(forClass = SubGrupo.class)
public class SubGrupoConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (SubGrupo) uIComponent.getAttributes().get(
					value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof SubGrupo) {
			SubGrupo entity = (SubGrupo) value;
			if (entity != null && entity instanceof SubGrupo
					&& entity.getIdSubGrupo() != null) {
				uiComponent.getAttributes().put(entity.getIdSubGrupo().toString(),
						entity);
				return entity.getIdSubGrupo().toString();
			}
		}
		return "";
	}

}
