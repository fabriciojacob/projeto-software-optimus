package br.com.softwareOptimus.produto.bens.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.produto.Categoria;

//@FacesConverter(value = "ClassConverter")
@FacesConverter(forClass = Categoria.class)
public class CategoriaConverte implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Categoria) uIComponent.getAttributes().get(
					value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof Categoria) {
			Categoria entity = (Categoria) value;
			if (entity != null && entity instanceof Categoria
					&& entity.getIdCategoria() != null) {
				uiComponent.getAttributes().put(entity.getIdCategoria().toString(),
						entity);
				return entity.getIdCategoria().toString();
			}
		}
		return "";
	}
}
