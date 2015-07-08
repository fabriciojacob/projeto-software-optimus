package br.com.softwareOptimus.util;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesUtil implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private void add(String message, Severity severity) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(message);
		msg.setSeverity(severity);
		
		context.addMessage(null, new FacesMessage(severity,"Info",message) );
	}
	
    public void checkSession(ExternalContext externalContext, String... keys){
    	Map<String, Object> valuesSession = externalContext.getSessionMap();
    	for(String key : keys){
    		boolean found = false;
	    	for(Entry<String, Object> dataSession : valuesSession.entrySet()){
	    		if(dataSession.getKey().equals(key)){
	    			valuesSession.remove(key);
	    			found = true;
	    		}
	    		if(found){
	    			break;
	    		}
	    	}
    	}
    }
    
    public Object getValueSessionJSF(String key){
    	Object data = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
    	if(data != null){
    		return data;
    	}
    	return null;
    }
	
	public void info(String message) {
		add(message, FacesMessage.SEVERITY_INFO);
	}
	
	public void error(String message) {
		add(message, FacesMessage.SEVERITY_ERROR);
	}
	
	public void warm(String message){
		add(message, FacesMessage.SEVERITY_WARN);		
	}
	
	public void errorFatal(String message){
		add(message, FacesMessage.SEVERITY_FATAL);
	}
}
