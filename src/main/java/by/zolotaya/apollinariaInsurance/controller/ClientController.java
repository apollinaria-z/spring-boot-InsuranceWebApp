package by.zolotaya.apollinariaInsurance.controller;

import by.zolotaya.apollinariaInsurance.entity.Client;
import by.zolotaya.apollinariaInsurance.exception.ValidationException;
import by.zolotaya.apollinariaInsurance.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients")
@AllArgsConstructor
@Log
public class ClientController {

    private final ClientService clientService;

    @GetMapping()
    public String findAllClients(Model model) {
        log.info("Handling find all clients request");
        model.addAttribute("clients",clientService.findAll());
        return "clients/getAllClients";
    }

    @GetMapping("/{id}")
    public String getClientById(@PathVariable("id") Integer id, Model model) {
        log.info("Handling get by id clients request");
        model.addAttribute("client", clientService.findById(id));
        return "clients/getClientById";
    }

    @GetMapping("/new")
    public String newClient(@ModelAttribute("client") Client client){
        return "clients/newClient";
    }

    @PostMapping()
    public String addClient(@ModelAttribute("client") @Valid Client client,
                            BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors())
            return "clients/newClient";

        log.info("Handling new client request");

        clientService.saveClient(client);
        return "redirect:/clients";
    }


}
