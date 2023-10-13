package it.controller;

import it.model.Company;
import it.repository.repository.RepositoryCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class CompanyController {
    @Autowired
    private RepositoryCompany repositoryCompany;

    @GetMapping("/")
    public String menut() {
        return "first-page";
    }
    @GetMapping("/table")
    public String findAll(Model model) {
        model.addAttribute("p", repositoryCompany.findAll());
        return "find-all";
    }

    @GetMapping("find/by/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("s", repositoryCompany.findById(id));
        return "company-find";
    }

    @GetMapping("save/form")
    public String saveForm() {
        return "company-save";
    }

    @PostMapping("save")
    public String save(
            @RequestParam("companyName") String companyName,
            @RequestParam("locatedCountry") String locatedCountry
    ) {
        Company company = new Company();
        company.setCompanyname(companyName);
        company.setLocatedcountry(locatedCountry);
        repositoryCompany.save(company);
        return "redirect:/";
    }

    @GetMapping("update/form/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("st", repositoryCompany.findById(id));
        return "update-form";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable int id, @RequestParam("companyname") String companyname, @RequestParam("located") String located) {
        Company company = repositoryCompany.findById(id);
        company.setCompanyname(companyname);
        company.setLocatedcountry(located);
        repositoryCompany.update(company, id);
        return "redirect:/table";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        repositoryCompany.delete(id);
        return "redirect:/";
    }
}