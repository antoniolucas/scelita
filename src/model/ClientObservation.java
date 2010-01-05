package model;

import net.java.ao.Entity;

public interface ClientObservation  extends Entity{

    public String getObservation() ;

    public void setObservation(String clientObservation);

    public Client getClient() ;

    public void setClient(Client client) ;
	 
}
 
