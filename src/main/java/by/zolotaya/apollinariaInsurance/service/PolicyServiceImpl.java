package by.zolotaya.apollinariaInsurance.service;

import by.zolotaya.apollinariaInsurance.entity.Policy;
import by.zolotaya.apollinariaInsurance.exception.ValidationException;
import by.zolotaya.apollinariaInsurance.repository.PolicyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class PolicyServiceImpl implements PolicyService{

    private final PolicyRepository policyRepository;

    @Override
    public void savePolicy(Policy policy) throws ValidationException {
       validatePolicy(policy);
       policyRepository.save(policy);
    }

    @Override
    public Policy findById(Integer id) {
        return policyRepository.getPolicyById(id);
    }

    @Override
    public List<Policy> findAll() {
        return policyRepository.getAllPolicies();
    }

    private void validatePolicy(Policy policy) throws ValidationException {
        if (isNull(policy)) {
            throw new ValidationException("Object policy is null");
        }
    }
}
