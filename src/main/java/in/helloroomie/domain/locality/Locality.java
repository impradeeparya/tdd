package in.helloroomie.domain.locality;

import in.helloroomie.domain.zone.Zone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */

@Entity
@Table(name = "locality")
public class Locality {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zone_id", referencedColumnName = "id")
	@NotNull
	private Zone zone;

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

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}
}
