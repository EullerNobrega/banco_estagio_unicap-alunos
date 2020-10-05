package br.unicap.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class RequirementVacancy extends PanacheEntity {
    private String descriptionRequirement;

    public String getDescription() {
        return descriptionRequirement;
    }

    public void setDescription(String description) {
        this.descriptionRequirement = description;
    }

}
