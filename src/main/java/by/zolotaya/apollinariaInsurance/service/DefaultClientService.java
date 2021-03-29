package by.zolotaya.apollinariaInsurance.service;

import by.zolotaya.apollinariaInsurance.dto.ClientDto;
import by.zolotaya.apollinariaInsurance.entity.Client;
import by.zolotaya.apollinariaInsurance.exception.ValidationException;
import by.zolotaya.apollinariaInsurance.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultClientService implements ClientService{

    private final ClientRepository clientRepository;
    private final ClientConverter clientConverter;

    @Override
    public ClientDto saveClient(ClientDto clientDto) throws ValidationException{
        validateClientDto(clientDto);
        Client savedClient = clientRepository.save(clientConverter.fromClientDtoToClient(clientDto));
        return clientConverter.fromClientToClientDto(savedClient);
    }

    @Override
    public void deleteClient(Integer clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public ClientDto findBySurname(String surname) {
        Client client = clientRepository.findBySurname(surname);
        if(client != null){
            return clientConverter.fromClientToClientDto(client);
        }
        return null;
    }

    @Override
    public List<ClientDto> findAll() {

        return clientRepository.findAll()
                .stream()
                .map(clientConverter :: fromClientToClientDto)
                .collect(Collectors.toList());
    }

    private void validateClientDto(ClientDto clientDto) throws ValidationException {
        if (isNull(clientDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(clientDto.getSurname()) || clientDto.getSurname().isEmpty()) {
            throw new ValidationException("Surname is empty");
        }
    }
}
