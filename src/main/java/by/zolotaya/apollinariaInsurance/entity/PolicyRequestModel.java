package by.zolotaya.apollinariaInsurance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor @NoArgsConstructor
public class PolicyRequestModel {

    @Min(value = 1, message = "id should be greater than 0")
    private int clientid;

    @NotEmpty(message = "Property should not be empty")
    private String property;

    private String coverage;

    @Min(value = 0, message = "Price should be greater than 0")
    private int price;

    }
