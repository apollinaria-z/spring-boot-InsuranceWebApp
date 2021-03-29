package by.zolotaya.apollinariaInsurance.service;

import by.zolotaya.apollinariaInsurance.dto.ClientDto;
import by.zolotaya.apollinariaInsurance.exception.ValidationException;

import java.util.List;

public interface ClientService {

    ClientDto saveClient(ClientDto clientDto) throws ValidationException;
    void deleteClient(Integer clientId);
    ClientDto findBySurname(String surname);
    List<ClientDto> findAll();
}
