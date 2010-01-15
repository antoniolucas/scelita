package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ClientObservation implements Serializable {
    @Id
    private Long id;

    private String clientObservation;

    @ManyToOne
    private Client client ;

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

    public String getClientObservation() {
        return clientObservation;
    }

    public void setClientObservation(String clientObservation) {
        this.clientObservation = clientObservation;
    }

    
}
 
