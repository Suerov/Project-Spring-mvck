package it.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dateoffinish;
    private String dateofstart;
    private String groupname;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Student> students;

    @ManyToMany
    @JoinTable(name = "groups_courses",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @Override
    public String toString() {
        return "Group:" +
                "id:" + id +
                "dateoffinish:" + dateoffinish + '\'' +
                ", dateofstart:" + dateofstart + '\'' +
                ", groupname:" + groupname;
    }
}