
package agh.sr.ws.calc.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the agh.sr.ws.calc.jaxws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddOperation_QNAME = new QName("http://calc.ws.sr.agh/", "AddOperation");
    private final static QName _DivideOperationResponse_QNAME = new QName("http://calc.ws.sr.agh/", "DivideOperationResponse");
    private final static QName _DivideOperation_QNAME = new QName("http://calc.ws.sr.agh/", "DivideOperation");
    private final static QName _AddOperationResponse_QNAME = new QName("http://calc.ws.sr.agh/", "AddOperationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: agh.sr.ws.calc.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddOperationResponse }
     * 
     */
    public AddOperationResponse createAddOperationResponse() {
        return new AddOperationResponse();
    }

    /**
     * Create an instance of {@link DivideOperationResponse }
     * 
     */
    public DivideOperationResponse createDivideOperationResponse() {
        return new DivideOperationResponse();
    }

    /**
     * Create an instance of {@link DivideOperation }
     * 
     */
    public DivideOperation createDivideOperation() {
        return new DivideOperation();
    }

    /**
     * Create an instance of {@link AddOperation }
     * 
     */
    public AddOperation createAddOperation() {
        return new AddOperation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calc.ws.sr.agh/", name = "AddOperation")
    public JAXBElement<AddOperation> createAddOperation(AddOperation value) {
        return new JAXBElement<AddOperation>(_AddOperation_QNAME, AddOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DivideOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calc.ws.sr.agh/", name = "DivideOperationResponse")
    public JAXBElement<DivideOperationResponse> createDivideOperationResponse(DivideOperationResponse value) {
        return new JAXBElement<DivideOperationResponse>(_DivideOperationResponse_QNAME, DivideOperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DivideOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calc.ws.sr.agh/", name = "DivideOperation")
    public JAXBElement<DivideOperation> createDivideOperation(DivideOperation value) {
        return new JAXBElement<DivideOperation>(_DivideOperation_QNAME, DivideOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calc.ws.sr.agh/", name = "AddOperationResponse")
    public JAXBElement<AddOperationResponse> createAddOperationResponse(AddOperationResponse value) {
        return new JAXBElement<AddOperationResponse>(_AddOperationResponse_QNAME, AddOperationResponse.class, null, value);
    }

}
