package by.zolotaya.apollinariaInsurance.repository;

import by.zolotaya.apollinariaInsurance.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findBySurname(String surname);
}
