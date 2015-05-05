package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Service;
import com.springapp.mvc.service.ServiceService;
import com.springapp.mvc.validation.ServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
@Controller
@RequestMapping(value = "/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ServiceValidator serviceValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(serviceValidator);
    }

    @RequestMapping(value="/create", method=RequestMethod.GET)
    public ModelAndView newServicePage() {
        ModelAndView mav = new ModelAndView("service-new", "service", new Service());
        return mav;
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ModelAndView createNewService(@ModelAttribute @Valid Service service,
                                      BindingResult result,
                                      final RedirectAttributes redirectAttributes) {

        if (result.hasErrors())
            return new ModelAndView("service-new");

        ModelAndView mav = new ModelAndView();
        serviceService.add(service);
        String message = "Новая услуга "+service.getName()+" была успешно создана";
        mav.setViewName("redirect:/service/list.html");

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public ModelAndView serviceListPage() {
        ModelAndView mav = new ModelAndView("service-list");
        mav.addObject("serviceList", serviceService.getAll());
        return mav;
    }


    @RequestMapping(value="/edit-status/{id}", method=RequestMethod.GET)
    public ModelAndView changeServiceStatus(@PathVariable Long id,
                                   final RedirectAttributes redirectAttributes) {

        ModelAndView mav = new ModelAndView("redirect:/service/list.html");

        Service service = serviceService.getById(id);
        service.setStatus(!service.getStatus());
        serviceService.changeStatus(service);
        String message = "Статус " + service.getName() + " успешно изменен на " + service.getStatus() + ".";

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editServicePage(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("service-edit");
        Service service = serviceService.getById(id);
        mav.addObject("service", service);
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView editService(@ModelAttribute @Valid Service service,
                                 BindingResult result,
                                 @PathVariable Long id,
                                 final RedirectAttributes redirectAttributes) {

        if (result.hasErrors())
            return new ModelAndView("service-edit");

        ModelAndView mav = new ModelAndView("redirect:/service/list.html");
        String message = "Услуга была успешно изменена.";
        serviceService.edit(service);
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }
}

