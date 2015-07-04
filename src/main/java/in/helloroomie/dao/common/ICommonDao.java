package in.helloroomie.dao.common;

import in.helloroomie.domain.city.CityDTO;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */
public interface ICommonDao {
    List<CityDTO> getAllCities();
}
