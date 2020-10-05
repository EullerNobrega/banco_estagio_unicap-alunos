package br.unicap.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Vacancy extends PanacheEntity {

    private String title;
    private String description;
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    private List<RequirementVacancy> requirements;

    public Vacancy() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RequirementVacancy> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<RequirementVacancy> requirements) {
        this.requirements = requirements;
    }

}
