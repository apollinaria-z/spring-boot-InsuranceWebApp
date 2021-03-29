package by.zolotaya.apollinariaInsurance.service;

import by.zolotaya.apollinariaInsurance.dto.ClientDto;
import by.zolotaya.apollinariaInsurance.entity.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter {
    public Client fromClientDtoToClient(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setSurname(clientDto.getSurname());
        client.setPassportId(clientDto.getPassportId());
        return client;
    }

    public ClientDto fromClientToClientDto(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .surname(client.getSurname())
                .passportId(client.getPassportId())
                .build();
    }
}
