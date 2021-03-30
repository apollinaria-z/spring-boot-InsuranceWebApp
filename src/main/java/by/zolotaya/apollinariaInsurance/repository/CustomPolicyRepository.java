package by.zolotaya.apollinariaInsurance.repository;

import by.zolotaya.apollinariaInsurance.entity.Policy;

import java.util.List;

public interface CustomPolicyRepository {
    List<Policy> getAllPolicies();
    Policy getPolicyById(Integer id);
}
