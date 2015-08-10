package in.helloroomie.domain.zone;

import in.helloroomie.domain.city.City;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Pradeep Arya on 7/5/2015.
 */

@Entity
@Table(name = "zone")
public class Zone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String name;

	@OneToOne
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	@NotNull
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
