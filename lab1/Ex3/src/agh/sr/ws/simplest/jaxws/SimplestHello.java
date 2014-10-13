
package agh.sr.ws.simplest.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "SimplestHello", targetNamespace = "http://simplest.ws.sr.agh/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SimplestHello {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://simplest.ws.sr.agh/", className = "agh.sr.ws.simplest.jaxws.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://simplest.ws.sr.agh/", className = "agh.sr.ws.simplest.jaxws.SayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        float arg2);

}