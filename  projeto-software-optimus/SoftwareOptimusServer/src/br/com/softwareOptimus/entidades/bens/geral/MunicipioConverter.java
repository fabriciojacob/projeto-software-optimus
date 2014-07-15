package br.com.softwareOptimus.entidades.bens.geral;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.softwareOptimus.entidades.Municipio;

//@FacesConverter(value = "classeConverter")    
@FacesConverter(forClass = Municipio.class)
public class MunicipioConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Municipio) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Municipio) {
        	Municipio entity= (Municipio) value;
            if (entity != null && entity instanceof Municipio && entity.getIdMunicipio() != null) {
                uiComponent.getAttributes().put( entity.getIdMunicipio().toString(), entity);
                return entity.getIdMunicipio().toString();
            }
        }
        return "";
    }
}