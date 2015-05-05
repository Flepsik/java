package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Client;
import com.springapp.mvc.service.ClientService;
import com.springapp.mvc.validation.ClientValidator;
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
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientValidator clientValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(clientValidator);
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public ModelAndView clientListPage() {
        ModelAndView mav = new ModelAndView("client-list");
        mav.addObject("clientList", clientService.getAll());
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.GET)
    public ModelAndView newClientPage() {
        ModelAndView mav = new ModelAndView("client-new", "client", new Client());
        return mav;
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ModelAndView createNewClient(@ModelAttribute @Valid Client client,
                                        BindingResult result,
                                        final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("client-new");
        }

        ModelAndView mav = new ModelAndView();
        String message = "Новый клиент " + client.getName() + " " + client.getSurname() + " был успешно добавлен";

        clientService.add(client);
        mav.setViewName("redirect:/client/list.html");

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }


    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editClientPage(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("client-edit");
        Client client = clientService.getById(id);
        mav.addObject("client", client);
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView editClient(@ModelAttribute @Valid Client client,
                                    BindingResult result,
                                    @PathVariable Long id,
                                    final RedirectAttributes redirectAttributes) {

        if (result.hasErrors())
            return new ModelAndView("client-edit");

        ModelAndView mav = new ModelAndView("redirect:/client/list.html");
        String message = "Данные клиента были успешно изменены ";
        clientService.edit(client);
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }
}

