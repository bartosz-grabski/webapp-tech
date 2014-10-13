package agh.sr.ws.calc;

import javax.jws.WebService;

@WebService(endpointInterface = "agh.sr.ws.calc.Calculator")
public class CalculatorImpl implements Calculator {

	@Override
	public int AddOperation(int a, int b, int c) {
		return a + b + c;
	}

	@Override
	public double DivideOperation(double dividend, double divisor) {
		// TODO Auto-generated method stub
		return 0;
	}

}
