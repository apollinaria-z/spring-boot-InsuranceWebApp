package by.zolotaya.apollinariaInsurance.repository;

import by.zolotaya.apollinariaInsurance.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer>, CustomPolicyRepository {
}
