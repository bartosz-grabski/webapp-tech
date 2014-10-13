package agh.sr.ws.calc;

import javax.xml.ws.Endpoint;


public class Server {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8889/CalculatorService", new CalculatorImpl());
	}
}
