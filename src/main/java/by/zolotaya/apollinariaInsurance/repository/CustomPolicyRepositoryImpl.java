package by.zolotaya.apollinariaInsurance.repository;

import by.zolotaya.apollinariaInsurance.entity.Policy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CustomPolicyRepositoryImpl implements CustomPolicyRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Policy> getAllPolicies() {

            Query query = entityManager.createNativeQuery(
                    "SELECT client.id, client.name, client.surname, client.passportId, " +
                    "policy.policyid, policy.clientid, policy.property, policy.coverage, policy.price " +
                            "FROM client JOIN policy ON client.id = policy.clientid",Policy.class);
            return query.getResultList();
    }

    @Override
    public Policy getPolicyById(Integer id) {
        Query query = entityManager.createNativeQuery("SELECT client.id, client.name, client.surname, client.passportId, " +
                "policy.policyid, policy.clientid, policy.property, policy.coverage, policy.price " +
                        "FROM client JOIN policy ON client.id = policy.clientid WHERE policy.policyid = (?)",Policy.class);
        query.setParameter(1, id);
        return (Policy) query.getSingleResult();
    }
}
