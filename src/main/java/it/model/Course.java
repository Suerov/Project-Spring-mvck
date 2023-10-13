package it.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String coursename;
    private String duration;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    private List<Group> groups;

    @OneToOne(mappedBy = "course", cascade = CascadeType.REMOVE)
    private Teacher teacher;

    @Override
    public String toString() {
        return "Course:" +
                "id:" + id +
                "coursename='" + coursename + '\'' +
                "duration='" + duration ;
    }
}