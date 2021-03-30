package by.zolotaya.apollinariaInsurance.controller;

import by.zolotaya.apollinariaInsurance.entity.Policy;
import by.zolotaya.apollinariaInsurance.exception.ValidationException;
import by.zolotaya.apollinariaInsurance.service.PolicyService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/policies")
@AllArgsConstructor
@Log
public class PolicyController {

    private final PolicyService policyService;

    @GetMapping()
    public String findAll(Model model) {
        log.info("Handling find all policies request");
        model.addAttribute("policies",policyService.findAll());
        return "policies/getAllPolicies";
    }

    @GetMapping("/{id}")
    public String getPolicyById(@PathVariable("id") Integer id, Model model) {
        log.info("Handling get by id policies request");
        model.addAttribute("client", policyService.findById(id));
        return "policies/getPolicyById";
    }

    @GetMapping("/new")
    public String newPolicy(@ModelAttribute("policy") Policy policy){
        return "policies/newPolicy";
    }

    @PostMapping()
    public String addPolicy(@ModelAttribute("policy") @Valid Policy policy,
                            BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors())
            return "policies/newPolicy";

        log.info("Handling new policy request");

        policyService.savePolicy(policy);
        return "redirect:/policies";
    }
}
