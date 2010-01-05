package model;

import net.java.ao.Entity;
import net.java.ao.OneToMany;
import net.java.ao.OneToOne;


public interface Client extends Entity{

    public Integer getPaymentDay();

    public void setPaymentDay(Integer i);

    public String getAddress();

    public void setAddress(String address);

    public String getName();

    public void setName(String name);

    public String getNickName();

    public void setNickName(String nickName);

    public ClientClassification getClientClassification() ;

    public void setClientClassification(ClientClassification clientClassification) ;

    @OneToMany
    public ClientObservation[] getClientObservation() ;

//    public void setClientObservation(ClientObservation clientObservation) ;
    

    @OneToMany
    public Phone[] getPhones() ;


//    public void setPhone(Phone phone) ;



   public Float getSaldo();


   public void setSaldo(Float saldo);

   public String getReferencia();

   public void setReferencia(String referencia);

   //Not implemented yet!
   public Client getClientReferencia();

   public void setClientReferencia(Client referencia);

	 
}
 
