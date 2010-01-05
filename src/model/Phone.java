package model;

import net.java.ao.Entity;

public interface Phone  extends Entity{
 
    public Long getNumber();

    public void setNumber(Long number);


    public Client getClient();

    public void setClient(Client client) ;
	 
}
 
