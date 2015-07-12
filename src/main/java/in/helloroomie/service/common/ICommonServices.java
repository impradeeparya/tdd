package in.helloroomie.service.common;

import in.helloroomie.domain.city.City;
import in.helloroomie.domain.locality.Locality;
import in.helloroomie.domain.zone.Zone;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */
public interface ICommonServices {
    List<City> getAllCities();

    List<Zone> getCityZones(Long cityId);

    List<Locality> getLocalityByZone(Long zoneId);

    String getCurrentUser(String token);
}
