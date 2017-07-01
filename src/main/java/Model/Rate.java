package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RATES")
public class Rate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RateId")
    private Long Id;
    
      
    @Column(nullable = false)
    private int Value;
      
    @Column(nullable = false)
    private String Description;
      
    @Column(nullable = false)
    private Date Created;

    
    private Date Modified;
    
      
    @Column(nullable = false)
     TipoRate Type;
    
    @ManyToOne
    private User Sender;
    
    @ManyToOne
    private User Receiver;
    
    @ManyToOne
    private Stay stay;
    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public int getValue() {
        return Value;
    }
    

    public void setValue(int Value) {
        this.Value = Value;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date Created) {
        this.Created = Created;
    }

    public Date getModified() {
        return Modified;
    }

    public void setModified(Date Modified) {
        this.Modified = Modified;
    }

    public TipoRate getType() {
        return Type;
    }

    public void setType(TipoRate Type) {
        this.Type = Type;
    }

    
    public User getSender() {
        return Sender;
    }

    public void setSender(User Sender) {
        this.Sender = Sender;
    }

    public User getReceiver() {
        return Receiver;
    }

    public void setReceiver(User Receiver) {
        this.Receiver = Receiver;
    }

    public Stay getStay() {
        return stay;
    }

    public void setStay(Stay stay) {
        this.stay = stay;
    }
      
}
