
package infoservidor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the infoservidor package. 
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

    private final static QName _SetEstadoFilaResponse_QNAME = new QName("http://InfoServidor/", "setEstadoFilaResponse");
    private final static QName _SetNumCompra_QNAME = new QName("http://InfoServidor/", "setNumCompra");
    private final static QName _SetNumCompraResponse_QNAME = new QName("http://InfoServidor/", "setNumCompraResponse");
    private final static QName _SetEstadoFila_QNAME = new QName("http://InfoServidor/", "setEstadoFila");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: infoservidor
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetEstadoFila }
     * 
     */
    public SetEstadoFila createSetEstadoFila() {
        return new SetEstadoFila();
    }

    /**
     * Create an instance of {@link SetNumCompraResponse }
     * 
     */
    public SetNumCompraResponse createSetNumCompraResponse() {
        return new SetNumCompraResponse();
    }

    /**
     * Create an instance of {@link SetEstadoFilaResponse }
     * 
     */
    public SetEstadoFilaResponse createSetEstadoFilaResponse() {
        return new SetEstadoFilaResponse();
    }

    /**
     * Create an instance of {@link SetNumCompra }
     * 
     */
    public SetNumCompra createSetNumCompra() {
        return new SetNumCompra();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetEstadoFilaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://InfoServidor/", name = "setEstadoFilaResponse")
    public JAXBElement<SetEstadoFilaResponse> createSetEstadoFilaResponse(SetEstadoFilaResponse value) {
        return new JAXBElement<SetEstadoFilaResponse>(_SetEstadoFilaResponse_QNAME, SetEstadoFilaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNumCompra }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://InfoServidor/", name = "setNumCompra")
    public JAXBElement<SetNumCompra> createSetNumCompra(SetNumCompra value) {
        return new JAXBElement<SetNumCompra>(_SetNumCompra_QNAME, SetNumCompra.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNumCompraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://InfoServidor/", name = "setNumCompraResponse")
    public JAXBElement<SetNumCompraResponse> createSetNumCompraResponse(SetNumCompraResponse value) {
        return new JAXBElement<SetNumCompraResponse>(_SetNumCompraResponse_QNAME, SetNumCompraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetEstadoFila }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://InfoServidor/", name = "setEstadoFila")
    public JAXBElement<SetEstadoFila> createSetEstadoFila(SetEstadoFila value) {
        return new JAXBElement<SetEstadoFila>(_SetEstadoFila_QNAME, SetEstadoFila.class, null, value);
    }

}
