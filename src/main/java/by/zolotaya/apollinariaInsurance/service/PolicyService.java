package by.zolotaya.apollinariaInsurance.service;

import by.zolotaya.apollinariaInsurance.entity.Client;
import by.zolotaya.apollinariaInsurance.entity.Policy;
import by.zolotaya.apollinariaInsurance.exception.ValidationException;

import java.util.List;

public interface PolicyService {
    void savePolicy(Policy policy) throws ValidationException;
    Policy findById(Integer id);
    List<Policy> findAll();
}
