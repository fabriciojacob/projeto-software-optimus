package br.com.softwareOptimus.financeiro.bens.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.financeiro.Caixa;

@FacesConverter(forClass = Caixa.class)
public class CaixaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Caixa) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof Caixa) {
			Caixa entity = (Caixa) value;
			if (entity != null && entity instanceof Caixa
					&& entity.getIdCaixa() != null) {
				uiComponent.getAttributes().put(
						entity.getIdCaixa().toString(), entity);
				return entity.getIdCaixa().toString();
			}
		}
		return "";
	}

}
