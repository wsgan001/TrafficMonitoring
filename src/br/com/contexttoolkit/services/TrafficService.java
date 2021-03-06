package br.com.contexttoolkit.services;

import br.com.contexttoolkit.webservice.RestWebService;
import context.arch.comm.DataObject;
import context.arch.service.Service;
import context.arch.service.helper.FunctionDescription;
import context.arch.service.helper.FunctionDescriptions;
import context.arch.service.helper.ServiceInput;
import context.arch.widget.Widget;

public class TrafficService extends Service {

	@SuppressWarnings("serial")
	public TrafficService(final Widget widget) {
		super(widget, "TrafficService", 
				new FunctionDescriptions() {
				{ // constructor
				// define function for the service
				add(new FunctionDescription(
						"trafficControl", 
						"quantidade de carros", 
						widget.getNonConstantAttributes()));
				}
		});	
	}
	
	@Override
	public DataObject execute(ServiceInput input) {
		
		String message = input.getInput().getAttributeValue("message");
		
        System.out.println("service----"+message);
        String valores[] = message.split("-");
        
        try {
			RestWebService.sendCarros(Integer.parseInt(valores[0]), Integer.parseInt(valores[1]));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		return null;
	}

}
