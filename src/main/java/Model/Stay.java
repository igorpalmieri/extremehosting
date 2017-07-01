/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ColumnDefault;

public class Stay {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StayId")
    private Long Id;
    
    @ManyToOne
    private User guest;
    @ManyToOne
    private House house;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;
    
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
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
    
}
