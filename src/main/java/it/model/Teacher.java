package it.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private  String firstname;
    private String lastname;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Override
    public String toString() {
        return "Teacher:" +
                "id:" + id +
                "email:" + email + '\'' +
                "firstname:" + firstname + '\'' +
                "lastname:" + lastname ;
    }
}