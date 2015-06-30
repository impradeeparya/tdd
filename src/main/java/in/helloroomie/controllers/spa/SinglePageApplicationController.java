package in.helloroomie.controllers.spa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Pradeep Arya on 6/29/2015.
 */

@Controller
@RequestMapping(value = "/")
public class SinglePageApplicationController {

    @RequestMapping(method = RequestMethod.GET)
    public String loadSPA() {
        return "spa";
    }
}
