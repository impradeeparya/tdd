package in.helloroomie.dao.common.impl;

import in.helloroomie.dao.common.ICommonDao;
import in.helloroomie.domain.city.CityDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */

@Repository
public class CommonDaoImpl implements ICommonDao {
    public List<CityDTO> getAllCities() {
        CityDTO cityDTO1 = new CityDTO();
        cityDTO1.setId(1L);
        cityDTO1.setName("New Delhi");

        CityDTO cityDTO2 = new CityDTO();
        cityDTO2.setName("Bengaluru");
        cityDTO2.setId(2L);

        List<CityDTO> cities = new ArrayList<CityDTO>(Arrays.asList(cityDTO1, cityDTO2));
        return cities;

    }
}
