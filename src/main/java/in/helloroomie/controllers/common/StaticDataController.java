package in.helloroomie.controllers.common;

import in.helloroomie.domain.city.City;
import in.helloroomie.domain.locality.Locality;
import in.helloroomie.domain.zone.Zone;
import in.helloroomie.dto.user.UserDto;
import in.helloroomie.service.common.IStaticDataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */

@Controller
@RequestMapping(value = "/")
public class StaticDataController {

    @Autowired
    private IStaticDataServices staticDataServices;

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public
    @ResponseBody
    List<City> fetchAllCities() {
        return staticDataServices.fetchAllCities();
    }

    @RequestMapping(value = "/city/{cityId}/zones", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Zone> fetchZonesByCity(@PathVariable("cityId") long cityId) {
        return staticDataServices.fetchZonesByCity(cityId);
    }

    @RequestMapping(value = "/zone/{zoneId}/localities", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Locality> fetchLocalityByZone(
            @PathVariable("zoneId") long zoneId) {
        return staticDataServices.fetchLocalitiesByZone(zoneId);
    }

    @RequestMapping(value = "/city/{cityId}/localities", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Locality> fetchLocalityByCity(
            @PathVariable("cityId") long cityId) {
        return staticDataServices.fetchLocalitiesByCity(cityId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public
    @ResponseBody
    UserDto fetchCurrentUser(
            @RequestHeader(value = "Authorization") String token) {
        return staticDataServices.fetchUserByToken(token);
    }
}
