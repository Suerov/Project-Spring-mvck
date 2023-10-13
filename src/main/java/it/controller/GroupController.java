package it.controller;


import it.model.Company;
import it.model.Course;
import it.model.Group;
import it.repository.repository.RepositoryCompany;
import it.repository.repository.RepositoryCourse;
import it.repository.repository.RepositoryGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("group/controller")
public class GroupController {
    @Autowired
    private RepositoryGroup repositoryGroup;
    @Autowired
    private RepositoryCompany repositoryCompany;
    @Autowired
    private RepositoryCourse repositoryCourse;


    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("p", repositoryGroup.findAll());
        return "group-table";
    }

    @GetMapping("find/by/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("s", repositoryGroup.findById(id));
        return "group-find";
    }

    @GetMapping("save/form")
    public String saveForm(Model model) {
        model.addAttribute("find", repositoryCompany.findAll());
        model.addAttribute("finds", repositoryCourse.findAll());
        return "group-save";
    }

    @PostMapping("save")
    public String save(
            @RequestParam("dateoffinsih") String dateoffinsih,
            @RequestParam("dateofstart") String dateofstart,
            @RequestParam("groupname") String groupname,
            @RequestParam("company_id") int company_id,
            @RequestParam("course_id") int course_id
    ) {

        Group group = new Group();
        group.setDateofstart(dateofstart);
        group.setDateoffinish(dateoffinsih);
        group.setGroupname(groupname);
        Course course = repositoryCourse.findById(course_id);
        group.setCourses(List.of(course));
        Company company = repositoryCompany.findById(company_id);
        group.setCompany(company);
        repositoryGroup.save(group);
        return "redirect:/group/controller/";
    }

    @GetMapping("update/form/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("st", repositoryGroup.findById(id));
        return "update-g";
    }

    @PostMapping("updates/{id}")
    public String update(@PathVariable int id, @RequestParam("groupname") String groupname, @RequestParam("dateofstart") String dateofstart , @RequestParam("dateoffinish") String dateoffinish) {
        Group group = repositoryGroup.findById(id);
        group.setGroupname(groupname);
        group.setDateofstart(dateofstart);
        group.setDateoffinish(dateoffinish);
        repositoryGroup.update(group, id);
        return "redirect:/group/controller/";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        repositoryGroup.delete(id);
        return "redirect:/";
    }
}




