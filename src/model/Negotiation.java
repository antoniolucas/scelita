package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Lucas
 */
@Entity
public class Negotiation implements Serializable {
    @Id
    private Long id;


    @ManyToOne
    private NegotiationType negotiationType;

    private Float negotiationValue;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date negotiationDate;

    @ManyToMany
    @JoinTable(
        name="products_negotiation",
        joinColumns=@JoinColumn(name="product_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="negotiation_id", referencedColumnName="id")
    )
    private List<Product> products;

    @ManyToOne(optional=false)
    private Client client;

    public Negotiation() {
    }


    public Negotiation(Client client, NegotiationType negotiationType, Float negotiationValue, Date negotiationDate) {
        this.negotiationType = negotiationType;
        this.negotiationValue = negotiationValue;
        this.negotiationDate = negotiationDate;
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

    public NegotiationType getNegotiationType() {
        return negotiationType;
    }

    public void setNegotiationType(NegotiationType negotiationType) {
        this.negotiationType = negotiationType;
    }

    public Float getNegotiationValue() {
        return negotiationValue;
    }

    public void setNegotiationValue(Float negotiationValue) {
        this.negotiationValue = negotiationValue;
    }


}
