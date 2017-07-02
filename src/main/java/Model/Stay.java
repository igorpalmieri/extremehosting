/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.RateDAO;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    
    private StatusStay status;

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
    
    public String getStartdateString(){
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(startdate);
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
    public String getEnddateString(){
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(enddate);
    }
    

    public int getExtraGuests() {
        return extraGuests;
    }
    public void setExtraGuests(int extraGuests) {
        this.extraGuests = extraGuests;
    }

    public StatusStay getStatus() {
        return status;
    }
    public void setStatus(StatusStay status) {
        this.status = status;
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
       return (this.startdate.before(start) && this.enddate.after(start) || this.startdate.after(start) && this.startdate.before(end) || (this.startdate.compareTo(start) == 0 && this.enddate.compareTo(end) == 0));
    }
    public void submitApproval(boolean approve){
        if(approve)
            status = StatusStay.APROVADO;
        else
            status = StatusStay.REPROVADO;
    }
    
    public boolean isEvaluated(User sender){
        return (RateDAO.getRates(this).stream().filter(r -> r.getSender().getId().equals(sender.getId())).count() > 0);
    }
    
    
}
