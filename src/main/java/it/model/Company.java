package it.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String companyname;
    private String locatedcountry;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Course> courses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Group> groups;

    @Override
    public String toString() {
        return "Company:" +
                "id:" + id +"\n"+
                "companyname:" + companyname + "\n" +
                "locatedcountry:" + locatedcountry;
    }
}
