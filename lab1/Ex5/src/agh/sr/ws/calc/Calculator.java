package agh.sr.ws.calc;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface Calculator {
	int AddOperation(int a, int b, int c);
	double DivideOperation(double dividend, double divisor);
}
