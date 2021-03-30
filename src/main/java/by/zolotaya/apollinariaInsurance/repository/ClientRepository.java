package by.zolotaya.apollinariaInsurance.repository;

import by.zolotaya.apollinariaInsurance.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

}
