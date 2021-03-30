package by.zolotaya.apollinariaInsurance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "policy")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@AllArgsConstructor @NoArgsConstructor
public class Policy {

    @Id
    @Column(name = "policyid")
    @SequenceGenerator(name = "clientIdSeq", sequenceName = "client_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientIdSeq")
    private Integer policyid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "clientid")
    private Client client;

    @NotEmpty(message = "Property should not be empty")
    private String property;

    @Column(name = "coverage")
    private Coverage coverage;

    @Column(name = "price")
    @Min(value = 0, message = "Prise should be greater than 0")
    private int price;


}
