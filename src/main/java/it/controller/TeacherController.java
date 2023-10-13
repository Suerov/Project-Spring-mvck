package it.controller;


import it.model.Course;
import it.model.Teacher;
import it.repository.repository.RepositoryCourse;
import it.repository.repository.RepositoryTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("teacher/controller")
public class TeacherController {
    @Autowired
    private RepositoryCourse repositoryCourse;
    @Autowired
    private RepositoryTeacher repositoryTeacher;

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("d", repositoryTeacher.findAll());
        return "teachers-table";
    }

    @GetMapping("find/by/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("n", repositoryTeacher.findById(id));
        return "Teacher-find";
    }

    @GetMapping("save/form")
    public String saveForm(Model model) {
        model.addAttribute("finds", repositoryCourse.findAll());
        return "teacher-save";
    }

    @PostMapping("save")
    public String save(
            @RequestParam("email") String email,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("course_id") int course_id

    ) {

        Teacher teacher = new Teacher();
        teacher.setEmail(email);
        teacher.setFirstname(firstname);
        teacher.setLastname(lastname);
        Course course=repositoryCourse.findById(course_id);
        teacher.setCourse(course);
        repositoryTeacher.save(teacher);
        return "redirect:/teacher/controller/";
    }

    @GetMapping("update/form/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("st", repositoryTeacher.findById(id));
        return "teacher-update";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable int id, @RequestParam("email") String email, @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
        Teacher teacher = repositoryTeacher.findById(id);
        teacher.setEmail(email);
        teacher.setFirstname(firstname);
        teacher.setLastname(lastname);
        repositoryTeacher.update(teacher, id);

        return "redirect:/teacher/controller/";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        repositoryTeacher.delete(id);
        return "redirect:/";
    }
}
