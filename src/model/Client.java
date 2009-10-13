package model;

import net.java.ao.Entity;


public interface Client extends Entity{


    public String getAddress();

    public void setAddress(String address);

    public String getName();

    public void setName(String name);

    public String getNickName();

    public void setNickName(String nickName);

    public String getClientClassification() ;


    public void setClientClassification(String clientClassification) ;
    

    public ClientObservation getClientObservation() ;

    public void setClientObservation(ClientObservation clientObservation) ;
    

    public Phone getPhone() ;
    

    public void setPhone(Phone phone) ;



   public Float getSaldo();


   public void setSaldo(Float saldo);

   public String getReferencia();

   public void setReferencia(String referencia);

	 
}
 
