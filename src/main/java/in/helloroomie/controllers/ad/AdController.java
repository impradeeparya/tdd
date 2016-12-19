package in.helloroomie.controllers.ad;

import in.helloroomie.dto.ad.AdDto;
import in.helloroomie.dto.ad.AdImageDto;
import in.helloroomie.service.ad.IAdServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Pradeep Arya on 7/6/2015.
 */

@Controller
@RequestMapping(value = "/ad")
public class AdController {

    @Autowired
    private IAdServices adServices;

    @RequestMapping(value = "/zone/{zoneId}", method = RequestMethod.POST)
    public
    @ResponseBody
    List<AdDto> fetchByZoneId(@RequestParam("zoneId") long zoneId) {
        return adServices.fetchByZoneId(zoneId);
    }

    @RequestMapping(value = "/city/{cityId}", method = RequestMethod.POST)
    public
    @ResponseBody
    List<AdDto> fetchByCityId(@RequestParam("cityId") long cityId) {
        return adServices.fetchByCityId(cityId);
    }

    @RequestMapping(value = "/locality/{localityId}", method = RequestMethod.POST)
    public
    @ResponseBody
    List<AdDto> fetchByLocalityId(
            @RequestParam("localityId") long localityId) {
        return adServices.fetchByLocalityId(localityId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public
    @ResponseBody
    Boolean postAd(
            @RequestHeader("Authorization") String token,
            @RequestBody AdImageDto adImageDto) {
        return adServices.postAd(token, adImageDto);
    }

    @RequestMapping(value = "/uploadImages", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Long> uploadRoomImages(
            MultipartHttpServletRequest request) {
        List<Long> uploadFileIds = new ArrayList<Long>();
        Iterator<String> itr = request.getFileNames();

        while (itr.hasNext()) {
            MultipartFile multipartFile = request.getFile(itr.next());
            try {
                multipartFile.getBytes();
                uploadFileIds.add(adServices.uploadImage(
                        multipartFile.getOriginalFilename(),
                        multipartFile.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return uploadFileIds;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public
    @ResponseBody
    List<AdDto> fetchCurrentUserAds(
            @RequestHeader("Authorization") String token) {
        return adServices.fetchCurrentUserAds(token);
    }

    @RequestMapping(value = "/{adId}/{status}", method = RequestMethod.PUT)
    public
    @ResponseBody
    Boolean updateAdStatus(@RequestParam("adId") long adId, @RequestParam("status") char status) {
        return adServices.updateStatus(adId, status);
    }

}
