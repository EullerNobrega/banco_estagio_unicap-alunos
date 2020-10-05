package br.unicap.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Student extends PanacheEntity {

    private String registration;
    private String email;
    private String name;
    private int semester;
    @OneToMany(cascade=CascadeType.ALL)
    private List<SkillStudent> skills;

    public Student() {
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<SkillStudent> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillStudent> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Student [email=" + email + ", name=" + name + ", registration=" + registration + ", semester="
                + semester + ", skills=" + skills + "]";
    }

    
}
