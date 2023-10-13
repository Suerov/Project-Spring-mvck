package it.controller;

import it.model.Group;
import it.model.Student;
import it.repository.repository.RepositoryGroup;
import it.repository.repository.RepositoryStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("student/controller")
public class StudentController {
    @Autowired
    private RepositoryStudent repositoryStudent;
    @Autowired
    private RepositoryGroup repositoryGroup;

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("p", repositoryStudent.findAll());
        return "Student-table";
    }

    @GetMapping("find/by/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("s", repositoryStudent.findById(id));
        return "student-find";
    }

    @GetMapping("saves/form")
    public String saveForm(Model model) {
        model.addAttribute("find", repositoryGroup.findAll());
        return "student-save";
    }

    @PostMapping("save")
    public String save(
            @RequestParam("email") String email,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("studentformat") String studentfromat,
            @RequestParam("group_id") int group_id

    ) {

        Student student = new Student();
        student.setEmail(email);
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setStudentformat(studentfromat);
        Group group = repositoryGroup.findById(group_id);
        student.setGroup(group);
        repositoryStudent.save(student);
        return "redirect:/student/controller/";
    }

    @GetMapping("update/form/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("sd", repositoryStudent.findById(id));
        return "update-s";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable int id, @RequestParam("lastname") String lastname, @RequestParam("firstname") String firstname, @RequestParam("email") String email, @RequestParam("studentformat") String studentformat) {
        Student student1 = repositoryStudent.findById(id);
        student1.setLastname(lastname);
        student1.setFirstname(firstname);
        student1.setEmail(email);
        student1.setStudentformat(studentformat);
        student1.setStudentformat(student1.getStudentformat());

        repositoryStudent.update(student1, id);

        return "redirect:/student/controller/";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        repositoryStudent.delete(id);
        return "redirect:/";
    }
}
