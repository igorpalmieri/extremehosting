/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "STAYS")
public class Stay implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StayId")
    private Long Id;
    
    @ManyToOne
    private User guest;
    @ManyToOne
    private House house;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    
    @ColumnDefault(value="0")
    private int extraGuests;
    
    private EstadoStay status;
    
    private boolean approved;

    public User getGuest() {
        return guest;
    }

    public void setGuest(User guest) {
        this.guest = guest;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    

    public int getExtraGuests() {
        return extraGuests;
    }

    public void setExtraGuests(int extraGuests) {
        this.extraGuests = extraGuests;
    }

    public EstadoStay getStatus() {
        return status;
    }

    public void setStatus(EstadoStay status) {
        this.status = status;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    
    public boolean isConflict(Date start, Date end){
       //inicio1.before(inicio2) and fim1.after(inicio2)
       //inicio1.after(inicio2) and inicio1.before(fim2)
       return (this.startdate.before(start) && this.enddate.after(start) || this.startdate.after(start) && this.startdate.before(end));
    }
    
    
}
