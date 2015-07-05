package in.helloroomie.dao.common;

import in.helloroomie.domain.city.City;
import in.helloroomie.domain.zone.Zone;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */
public interface ICommonDao {
    List<City> getAllCities();

    List<Zone> getCityZones(Long cityId);
}
