package by.zolotaya.apollinariaInsurance.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {

    private Integer id;
    private String name;
    private String surname;
    private String passportId;
}
