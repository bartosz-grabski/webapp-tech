package agh.sr.ws.simplest;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;


@WebService
@SOAPBinding(style= Style.RPC, use = Use.LITERAL)
public interface SimplestHello {

	public String sayHello(String sender, int age, float salary);
	
}
