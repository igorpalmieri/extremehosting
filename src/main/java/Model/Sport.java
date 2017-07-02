package Model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "SPORTS")
public class Sport implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SportId")
    private Long Id;
    private String Name;

    public Long getId() {
        return Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    
   
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    
}
