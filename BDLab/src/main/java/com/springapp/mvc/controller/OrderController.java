package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Client;
import com.springapp.mvc.entity.Order;
import com.springapp.mvc.entity.Service;
import com.springapp.mvc.entity.Worker;
import com.springapp.mvc.service.ClientService;
import com.springapp.mvc.service.OrderService;
import com.springapp.mvc.service.ServiceService;
import com.springapp.mvc.service.WorkerService;
import com.springapp.mvc.validation.OrderValidator;
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
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private OrderValidator orderValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(orderValidator);
        binder.registerCustomEditor(Worker.class, new WorkerEditor());
        binder.registerCustomEditor(Service.class, new ServiceEditor());
        binder.registerCustomEditor(Client.class, new ClientEditor());

    }

    class WorkerEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text){
            Long id = Long.parseLong(text);
            Worker worker = workerService.getById(id);
            setValue(worker);
        }
    }

    class ClientEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text){
            Long id = Long.parseLong(text);
            Client client = clientService.getById(id);
            setValue(client);
        }
    }

    class ServiceEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text){
            Long id = Long.parseLong(text);
            Service service = serviceService.getById(id);
            setValue(service);
        }
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public ModelAndView bookListPage() {
        ModelAndView mav = new ModelAndView("order-list");
        mav.addObject("orderList", orderService.getAll());
        return mav;
    }

    @RequestMapping(value="/create", method= RequestMethod.GET)
    public ModelAndView newOrderPage() {
        List<Client> clients = clientService.getAll();
        List<Worker> workers = workerService.getAll();
        List<Service> services = serviceService.getAll();
        ModelAndView mav = new ModelAndView("order-new", "order", new Order());
        mav.addObject("clients", clients);
        mav.addObject("workers", workers);
        mav.addObject("services", services);
        return mav;
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ModelAndView createNewOrder(@ModelAttribute @Valid Order order,
                                        BindingResult result,
                                        final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("order-new");
        }

        ModelAndView mav = new ModelAndView();
        String message = "Новый заказ " + order.getService().getName() + " для клиента "
                + order.getClient().getName() + " "
                + order.getClient().getSurname() + " был успешно добавлен";

        orderService.add(order);
        mav.setViewName("redirect:/order/list.html");

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteOrder(@PathVariable Long id,
                                   final RedirectAttributes redirectAttributes) {

        ModelAndView mav = new ModelAndView("redirect:/order/list.html");
        Order order = orderService.getById(id);
        orderService.delete(id);
        String message = "Заказ номер "
                + order.getId() + " на имя "
                + order.getClient().getName() + " "
                + order.getClient().getSurname() + " был успешно удален";

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="/edit-status/{id}", method=RequestMethod.GET)
    public ModelAndView changeOrderStatus(@PathVariable Long id,
                                            final RedirectAttributes redirectAttributes) {

        ModelAndView mav = new ModelAndView("redirect:/order/list.html");

        Order order = orderService.getById(id);
        order.setStatus(!order.getStatus());
        orderService.changeStatus(order);
        String message = "Статус заказа номер " + order.getId() + " успешно изменен на " + order.getStatus() + ".";

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }
}
