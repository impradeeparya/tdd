package in.helloroomie.controllers.ad;

import in.helloroomie.domain.ad.Ad;
import in.helloroomie.domain.user.User;
import in.helloroomie.dto.ad.AdDto;
import in.helloroomie.service.ad.IAdServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/post", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Boolean postAd(@RequestHeader("Authorization") String token, @RequestBody Ad ad) {
        return adServices.postAd(token, ad);
    }

}
