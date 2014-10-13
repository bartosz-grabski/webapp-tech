
package agh.sr.ws.calc.jaxws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "CalculatorImplService", targetNamespace = "http://calc.ws.sr.agh/", wsdlLocation = "file:/Users/bartosz/Projects/webapp-tech/Ex5/CalculatorImplService.wsdl")
public class CalculatorImplService
    extends Service
{

    private final static URL CALCULATORIMPLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(agh.sr.ws.calc.jaxws.CalculatorImplService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = agh.sr.ws.calc.jaxws.CalculatorImplService.class.getResource(".");
            url = new URL(baseUrl, "file:/Users/bartosz/Projects/webapp-tech/Ex5/CalculatorImplService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/Users/bartosz/Projects/webapp-tech/Ex5/CalculatorImplService.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        CALCULATORIMPLSERVICE_WSDL_LOCATION = url;
    }

    public CalculatorImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalculatorImplService() {
        super(CALCULATORIMPLSERVICE_WSDL_LOCATION, new QName("http://calc.ws.sr.agh/", "CalculatorImplService"));
    }

    /**
     * 
     * @return
     *     returns Calculator
     */
    @WebEndpoint(name = "CalculatorImplPort")
    public Calculator getCalculatorImplPort() {
        return super.getPort(new QName("http://calc.ws.sr.agh/", "CalculatorImplPort"), Calculator.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Calculator
     */
    @WebEndpoint(name = "CalculatorImplPort")
    public Calculator getCalculatorImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://calc.ws.sr.agh/", "CalculatorImplPort"), Calculator.class, features);
    }

}