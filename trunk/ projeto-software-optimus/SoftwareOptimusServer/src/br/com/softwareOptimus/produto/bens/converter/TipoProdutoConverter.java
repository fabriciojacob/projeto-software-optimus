package br.com.softwareOptimus.produto.bens.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.fiscal.TipoProduto;

//@FacesConverter(value = "ClassConverter")
@FacesConverter(forClass = TipoProduto.class)
public class TipoProdutoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (TipoProduto) uIComponent.getAttributes().get(
					value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof TipoProduto) {
			TipoProduto entity = (TipoProduto) value;
			if (entity != null && entity instanceof TipoProduto
					&& entity.getIdTipoProd() != null) {
				uiComponent.getAttributes().put(entity.getIdTipoProd().toString(),
						entity);
				return entity.getIdTipoProd().toString();
			}
		}
		return "";
	}
}
