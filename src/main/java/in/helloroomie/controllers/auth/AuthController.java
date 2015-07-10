package in.helloroomie.controllers.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Pradeep Arya on 7/10/2015.
 */

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Boolean login() {
        return true;
    }
}
