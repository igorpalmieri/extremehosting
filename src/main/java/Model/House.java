package Model;

import DAO.HouseDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "HOUSES")
public class House implements Serializable {

        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HouseId")
    private Long Id;
    
    private String Address;
    private String Country;
    private String City;
    private String Region;
    @ColumnDefault(value="0")
    private int vacancy;
    @ManyToOne
    private User owner;
    
    @OneToMany(mappedBy="house")
    private List<Stay> Stays;
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public List<Stay> getStays() {
        return Stays;
    }

    public void setStays(List<Stay> Stays) {
        this.Stays = Stays;
    }
    
    public static List<String> getCountries(){
        return HouseDAO.getCountries();
    }
    
    public static List<String> getCities(String country){
        return HouseDAO.getCities(country);
    }
    
    public static List<House> getAvailableHouses(String country, String city, int quantity){
        return HouseDAO.getAvailableHouses(country,city,quantity);
    }
    
}
