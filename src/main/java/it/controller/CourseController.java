package it.controller;

import it.model.Company;
import it.model.Course;
import it.repository.repository.RepositoryCompany;
import it.repository.repository.RepositoryCourse;

import it.repositorys.CompanyRepositoryImp;
import org.postgresql.copy.CopyOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("course/controller")
public class CourseController {
    @Autowired
    private RepositoryCourse repositoryCourse;
    @Autowired
    private RepositoryCompany repositoryCompany;

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("p", repositoryCourse.findAll());
        return "courses-table";
    }

    @GetMapping("find/by/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("s", repositoryCourse.findById(id));
        return "course-find";
    }

    @GetMapping("save/form")
    public String saveForm(Model model) {
        model.addAttribute("find", repositoryCompany.findAll());
        return "courses-page";
    }

    @PostMapping("save")
    public String save(
            @RequestParam("coursename") String name,
            @RequestParam("duration") String duration,
            @RequestParam("company_id") int company_id
    ) {
        Course course = new Course();
        course.setCoursename(name);
        course.setDuration(duration);
        Company company = repositoryCompany.findById(company_id);
        course.setCompany(company);
        repositoryCourse.save(course);
        return "redirect:/course/controller/";
    }

    @GetMapping("update/form/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("sf", repositoryCourse.findById(id));
        return "update";
    }

    @PostMapping("updates/{id}")
    public String update(@PathVariable int id,
                         @RequestParam("coursename") String coursename,
                         @RequestParam("duration") String duration) {
        Course course = repositoryCourse.findById(id);
        course.setCoursename(coursename);
        course.setDuration(duration);
        repositoryCourse.update(course, id);

        return "redirect:/course/controller/";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        repositoryCourse.delete(id);
        return "redirect:/";
    }
}
