package in.helloroomie.controllers.common;

import in.helloroomie.domain.city.CityDTO;
import in.helloroomie.service.common.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ICommonService commonService;

    @RequestMapping(value = "/getAllCities", method = RequestMethod.GET)
    public
    @ResponseBody
    List<CityDTO> getAllCities() {
        return commonService.getAllCities();
    }
}
