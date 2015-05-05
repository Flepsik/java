package com.springapp.mvc.controller;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * Created by Fleps_000 on 14.04.2015.
 */
@Controller
public class NavigationController {

    @RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

}