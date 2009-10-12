package model;

import net.java.ao.Entity;
import net.java.ao.schema.NotNull;



public interface Client extends Entity{
    
    @NotNull
    public ClientClassification getClientClassification() ;

    @NotNull
    public void setClientClassification(ClientClassification clientClassification) ;
    

    public ClientObservation getClientObservation() ;

    public void setClientObservation(ClientObservation clientObservation) ;
    

    public Phone getPhone() ;
    

    public void setPhone(Phone phone) ;


   @NotNull
   public Float getSaldo();

   @NotNull
   public void setSaldo(Float saldo);

   public String getReferencia();

   public void setReferencia(String referencia);


	 

	 
}
 
