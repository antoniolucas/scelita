package model;

import com.avaje.ebean.annotation.EnumMapping;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import mark.utils.bean.DateFormatter;
import mark.utils.bean.MoneyFormatter;
import mark.utils.el.annotation.Resolvable;
import mark.utils.el.handler.MethodHandler;

/**
 *
 * @author Lucas
 */
@Entity
public class Negotiation implements Serializable {

     @EnumMapping(integerType=true,nameValuePairs="COMPRA=1, PAGAMENTO=34, DEVOLUCAO = 111")
    public enum Type { COMPRA, PAGAMENTO, DEVOLUCAO}

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable=false)
    @Resolvable(accessMethod = MethodHandler.class, colName = "Tipo")
    private Type type;

    @Id
    private Long id;

    @Resolvable(accessMethod = MethodHandler.class, formatter = MoneyFormatter.class, colName = "Valor")
    private Float negotiationValue;

    @Resolvable(accessMethod = MethodHandler.class, formatter = DateFormatter.class, colName = "Data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date negotiationDate;

    @ManyToMany
    @JoinTable(
        name="products_negotiation",
        inverseJoinColumns=@JoinColumn(name="product_id", referencedColumnName="id"),
        joinColumns=@JoinColumn(name="negotiation_id", referencedColumnName="id")
    )
    private List<Product> products;

    @ManyToOne(optional=false)
    private Client client;

    public Negotiation() {
        products = new ArrayList<Product>();
    }

    public Negotiation(Client client, Type negotiationType, Float negotiationValue) {
       this(client, negotiationType, negotiationValue, new Date());
    }

    public Negotiation(Client client, Type negotiationType, Float negotiationValue, Date negotiationDate) {
        this.type = negotiationType;
        this.negotiationValue = negotiationValue;
        this.negotiationDate = negotiationDate;
        this.client = client;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type negotiationType) {
        this.type = negotiationType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getNegotiationDate() {
        return negotiationDate;
    }

    public void setNegotiationDate(Date negotiationDate) {
        this.negotiationDate = negotiationDate;
    }


    public Float getNegotiationValue() {
        return negotiationValue;
    }

    public void setNegotiationValue(Float negotiationValue) {
        this.negotiationValue = negotiationValue;
    }


}
