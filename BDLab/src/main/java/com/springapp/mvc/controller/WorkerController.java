package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Position;
import com.springapp.mvc.entity.Worker;
import com.springapp.mvc.service.PositionService;
import com.springapp.mvc.service.WorkerService;
import com.springapp.mvc.validation.WorkerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.util.List;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
@Controller
@RequestMapping(value = "/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private WorkerValidator workerValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(workerValidator);
        binder.registerCustomEditor(Position.class, new PositionEditor());
    }

    class PositionEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text){
            Long id = Long.parseLong(text);
            Position position = positionService.getById(id);
            setValue(position);
        }
    }

    @RequestMapping(value="/create", method= RequestMethod.GET)
    public ModelAndView newWorkerPage() {
        List<Position> positions = positionService.getAll();
        ModelAndView mav = new ModelAndView("worker-new", "worker", new Worker());
        mav.addObject("positions", positions);
        return mav;
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ModelAndView createNewWorker(@ModelAttribute @Valid Worker worker,
                                      BindingResult result,
                                      final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            //List<Position> positions = positionService.getAll();
            return new ModelAndView("worker-new");
        }

        ModelAndView mav = new ModelAndView();
        String message = "Новый сотрудник " + worker.getName() + " " + worker.getSurname() + " " + worker.getPatromymic() + " был успешно добавлен";

        workerService.add(worker);
        mav.setViewName("redirect:/worker/list.html");

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public ModelAndView workerListPage() {
        ModelAndView mav = new ModelAndView("worker-list");
        mav.addObject("workerList", workerService.getAll());
        return mav;
    }


    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editWorkerPage(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("worker-edit");
        Worker worker = workerService.getById(id);
        mav.addObject("worker", worker);
        mav.addObject("positions", positionService.getAll());
        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView editWorker(@ModelAttribute @Valid Worker worker,
                                    BindingResult result,
                                    @PathVariable Long id,
                                    final RedirectAttributes redirectAttributes) {

        if (result.hasErrors())
            return new ModelAndView("worker-edit");

        ModelAndView mav = new ModelAndView("redirect:/worker/list.html");
        String message = "Данные сотрудника были успешно изменены.";
        workerService.edit(worker);
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/edit-status/{id}", method=RequestMethod.GET)
    public ModelAndView changeWorkerStatus(@PathVariable Long id,
                                            final RedirectAttributes redirectAttributes) {

        ModelAndView mav = new ModelAndView("redirect:/worker/list.html");

        Worker worker = workerService.getById(id);
        worker.setStatus(!worker.getStatus());
        workerService.changeStatus(worker);
        String message = "Статус " + worker.getName() + " успешно изменен на " + worker.getStatus() + ".";

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }
}

