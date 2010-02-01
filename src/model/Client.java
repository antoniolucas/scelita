package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import mark.utils.bean.IntFormatter;
import mark.utils.bean.MoneyFormatter;
import mark.utils.el.annotation.Resolvable;
import mark.utils.el.handler.MethodHandler;

@Entity
public class Client implements Serializable {

    public Client(){
        phones = new ArrayList<Phone>();
        clientObservations = new ArrayList<ClientObservation>();
    }
    @Id
    private Long id;
    @Resolvable(accessMethod = MethodHandler.class, colName = "Nome")
    private String name = "";
    @Resolvable(accessMethod = MethodHandler.class, colName = "Apelido")
    private String nickName = "";
    @Resolvable(accessMethod = MethodHandler.class, formatter = IntFormatter.class, colName = "Dia Pagamento")
    private Integer paymentDay = 0;
    @Resolvable(accessMethod = MethodHandler.class, colName = "Endereço")
    private String address;
    @ManyToOne
    private ClientClassification clientClassification;
    @OneToMany(mappedBy = "client")//TODO ver como sao geradas as  tabelas
    private List<ClientObservation> clientObservations;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Phone> phones;
    @Resolvable(accessMethod = MethodHandler.class, colName = "Saldo", formatter = MoneyFormatter.class)
    private float saldo;
    @Resolvable(accessMethod = MethodHandler.class, colName = "Referência")
    private String reference;
    //Not implemented yet!
    @OneToOne
    private Client clientReference;

    @Override
    public String toString() {
        return getName() + " - " + getReference();
    }

    public void compra(Number value) {
        compra(value.floatValue());
    }

    public void compra(float value) {
        this.saldo += value;
    }

    public void pagamento(Number value) {
        pagamento(value.floatValue());
    }

    public void pagamento(float value) {
        this.saldo -= value;
    }

    public void devolucao(Number value) {
        pagamento(value.floatValue());
    }

    public void devolucao(float value) {
       pagamento(value);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClientClassification getClientClassification() {
        return clientClassification;
    }

    public void setClientClassification(ClientClassification clientClassification) {
        this.clientClassification = clientClassification;
    }

    public List<ClientObservation> getClientObservations() {
        return clientObservations;
    }

    public void setClientObservations(List<ClientObservation> clientObservations) {
        this.clientObservations = clientObservations;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Client getClientReference() {
        return clientReference;
    }

    public void setClientReference(Client clientReference) {
        this.clientReference = clientReference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(Integer paymentDay) {
        this.paymentDay = paymentDay;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void addPhone(Phone p) {
        this.phones.add(p);
    }
}
 
