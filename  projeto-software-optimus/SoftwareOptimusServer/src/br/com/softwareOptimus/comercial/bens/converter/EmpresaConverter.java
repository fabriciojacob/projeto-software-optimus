package br.com.softwareOptimus.comercial.bens.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.softwareOptimus.entidades.Pessoa;

@FacesConverter(forClass = Pessoa.class)
public class EmpresaConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Pessoa) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		if (value instanceof Pessoa) {
			Pessoa entity = (Pessoa) value;
			if (entity != null && entity instanceof Pessoa
					&& entity.getIdPessoa() != null) {
				uiComponent.getAttributes().put(
						entity.getIdPessoa().toString(), entity);
				return entity.getIdPessoa().toString();
			}
		}
		return "";
	}
}