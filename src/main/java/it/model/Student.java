package it.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String firstname;
    private String lastname;
    private String studentformat;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Override
    public String toString() {
        return "Student:" +
                "id:" + id +
                "email:" + email + '\'' +
                "firstname:" + firstname + '\'' +
                "lastname:" + lastname + '\'' +
                "studentformat:" + studentformat;
    }
}
