package in.helloroomie.service.common;

import in.helloroomie.domain.city.City;
import in.helloroomie.domain.locality.Locality;
import in.helloroomie.domain.zone.Zone;
import in.helloroomie.dto.user.UserDto;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */
public interface IStaticDataServices {
	List<City> fetchAllCities();

	List<Zone> fetchZonesByCity(long cityId);

	List<Locality> fetchLocalitiesByZone(long zoneId);

	List<Locality> fetchLocalitiesByCity(long cityId);

	UserDto fetchUserByToken(String token);
}
