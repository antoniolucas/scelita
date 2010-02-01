package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lucas
 */
@Entity
public class Parcel implements Serializable{

    @Id
    private Long id;

    private Float parcelValue;

    @Temporal(TemporalType.DATE)
    private Date parcelDate;

    private boolean alreadyPaid = false;

}
