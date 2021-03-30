package by.zolotaya.apollinariaInsurance.service;

import by.zolotaya.apollinariaInsurance.entity.Client;
import by.zolotaya.apollinariaInsurance.exception.ValidationException;
import by.zolotaya.apollinariaInsurance.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    @Override
    public void saveClient(Client client) throws ValidationException{
        validateClient(client);
        clientRepository.save(client);
    }

    @Override
    public Client findById(Integer id) {
        return clientRepository.findById(id).orElse(new Client());
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    private void validateClient(Client client) throws ValidationException {
        if (isNull(client)) {
            throw new ValidationException("Object client is null");
        }
    }
}
