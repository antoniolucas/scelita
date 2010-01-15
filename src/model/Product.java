package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import mark.utils.bean.IntFormatter;
import mark.utils.bean.MoneyFormatter;
import mark.utils.el.annotation.Resolvable;
import mark.utils.el.handler.MethodHandler;

/**
 *
 * @author Lucas
 */
@Entity
public class Product implements Serializable {

    @Id
    private Long id;

    @Resolvable(accessMethod = MethodHandler.class, formatter = IntFormatter.class,colName="Código")
    private Integer code;
    @Resolvable(accessMethod = MethodHandler.class)
    private String description;
    @Resolvable(accessMethod = MethodHandler.class, formatter = MoneyFormatter.class, colName = "Valor de Venda")
    private Float sellValue;
    @Resolvable(accessMethod = MethodHandler.class, formatter = MoneyFormatter.class, colName = "Valor de Compra")
    private Float purchaseValue;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(Float purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public Float getSellValue() {
        return sellValue;
    }

    public void setSellValue(Float sellValue) {
        this.sellValue = sellValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
