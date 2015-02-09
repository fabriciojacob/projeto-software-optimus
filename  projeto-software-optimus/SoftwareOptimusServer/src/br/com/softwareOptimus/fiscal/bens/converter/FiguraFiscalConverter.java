package br.com.softwareOptimus.fiscal.bens.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.fiscal.FiguraFiscal;

//@FacesConverter(value = "ClassConverter")
@FacesConverter(forClass = FiguraFiscal.class)
public class FiguraFiscalConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uIComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (FiguraFiscal) uIComponent.getAttributes().get(
					value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof FiguraFiscal) {
			FiguraFiscal entity = (FiguraFiscal) value;
			if (entity != null && entity instanceof FiguraFiscal
					&& entity.getIdFigura() != null) {
				uiComponent.getAttributes().put(entity.getIdFigura().toString(),
						entity);
				return entity.getIdFigura().toString();
			}
		}
		return "";
	}
}
