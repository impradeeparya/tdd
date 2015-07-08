package in.helloroomie.controllers.ad;

import in.helloroomie.dto.ad.AdDto;
import in.helloroomie.service.ad.IAdServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */

@Controller
@RequestMapping(value = "/ad")
public class AdController {

    @Autowired
    private IAdServices adServices;

    @RequestMapping(value = "/getByZoneId", method = RequestMethod.POST)
    public
    @ResponseBody
    List<AdDto> getByZoneId(@RequestBody Long zoneId) {
        return adServices.getByZoneId(zoneId);
    }

}
