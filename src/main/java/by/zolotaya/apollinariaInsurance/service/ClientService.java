package by.zolotaya.apollinariaInsurance.service;

import by.zolotaya.apollinariaInsurance.entity.Client;
import by.zolotaya.apollinariaInsurance.exception.ValidationException;

import java.util.List;

public interface ClientService {

    void saveClient(Client client) throws ValidationException;
    Client findById(Integer id);
    List<Client> findAll();

}
