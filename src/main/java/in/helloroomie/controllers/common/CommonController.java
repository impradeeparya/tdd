package in.helloroomie.controllers.common;

import in.helloroomie.domain.City.CityDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */

@Controller
@RequestMapping(value = "/common")
public class CommonController {

    @RequestMapping(value = "/getAllCities", method = RequestMethod.GET)
    public
    @ResponseBody
    List<CityDTO> getAllCities() {
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
