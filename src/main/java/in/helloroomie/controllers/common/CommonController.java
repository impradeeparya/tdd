package in.helloroomie.controllers.common;

import in.helloroomie.domain.city.City;
import in.helloroomie.domain.zone.Zone;
import in.helloroomie.service.common.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/3/2015.
 */

@Controller
@RequestMapping(value = "/common")
public class CommonController {

    @Autowired
    private ICommonService commonService;

    @RequestMapping(value = "/getAllCities", method = RequestMethod.GET)
    public
    @ResponseBody
    List<City> getAllCities() {
        return commonService.getAllCities();
    }

    @RequestMapping(value = "/getCityZones", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Zone> getCityZones(@RequestBody Long cityId) {
        return commonService.getCityZones(cityId);
    }
}
