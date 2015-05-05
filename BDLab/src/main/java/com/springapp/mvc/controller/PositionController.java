package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Position;
import com.springapp.mvc.service.PositionService;
import com.springapp.mvc.validation.PositionValidator;
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
@RequestMapping(value = "/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @Autowired
    private PositionValidator positionValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(positionValidator);
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public ModelAndView positionListPage() {
        ModelAndView mav = new ModelAndView("position-list", "position", new Position());
        mav.addObject("positionList", positionService.getAll());
        return mav;
    }


    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ModelAndView createNewPosition(@ModelAttribute @Valid Position position,
                                         BindingResult result,
                                         final RedirectAttributes redirectAttributes) {

        if (result.hasErrors())
            return new ModelAndView("position-list");

        ModelAndView mav = new ModelAndView();
        positionService.add(position);
        String message = "Новая должность "+position.getName()+" была успешно создана";
        mav.setViewName("redirect:/position/list.html");

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editPositionPage(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("position-edit");
        Position position = positionService.getById(id);
        mav.addObject("position", position);
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView editService(@ModelAttribute @Valid Position position,
                                    BindingResult result,
                                    @PathVariable Long id,
                                    final RedirectAttributes redirectAttributes) {

        if (result.hasErrors())
            return new ModelAndView("position-edit");

        ModelAndView mav = new ModelAndView("redirect:/position/list.html");
        String message = "Должность была успешно изменена.";
        positionService.edit(position);
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }
}

