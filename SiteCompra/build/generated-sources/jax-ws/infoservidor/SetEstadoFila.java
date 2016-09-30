
package infoservidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de setEstadoFila complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="setEstadoFila">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numConsulta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setEstadoFila", propOrder = {
    "numConsulta"
})
public class SetEstadoFila {

    protected String numConsulta;

    /**
     * Obtém o valor da propriedade numConsulta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumConsulta() {
        return numConsulta;
    }

    /**
     * Define o valor da propriedade numConsulta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumConsulta(String value) {
        this.numConsulta = value;
    }

}
