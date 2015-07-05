package in.helloroomie.domain.zone;

import in.helloroomie.domain.city.City;

import javax.persistence.*;

/**
 * Created by Pradeep Arya on 7/5/2015.
 */

@Entity
@Table(name = "zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCityId() {
        return city;
    }

    public void setCityId(City city) {
        this.city = city;
    }
}
