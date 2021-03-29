package by.zolotaya.apollinariaInsurance.controller;

import by.zolotaya.apollinariaInsurance.dto.ClientDto;
import by.zolotaya.apollinariaInsurance.exception.ValidationException;
import by.zolotaya.apollinariaInsurance.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
@Log
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/save")
    public ClientDto saveClient(@RequestBody ClientDto clientDto) throws ValidationException {
        log.info("Handling save clients: " + clientDto);
        return clientService.saveClient(clientDto);
    }

    @GetMapping("/findAll")
    public List<ClientDto> findAllClients() {
        log.info("Handling find all clients request");
        return clientService.findAll();
    }

    @GetMapping("/findBySurname")
    public ClientDto findBySurname(@RequestParam String surname) {
        log.info("Handling find by surname request: " + surname);
        return clientService.findBySurname(surname);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        log.info("Handling delete client request: " + id);
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
