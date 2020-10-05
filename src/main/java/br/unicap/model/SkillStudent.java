package br.unicap.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class SkillStudent extends PanacheEntity {
    private String descriptionSkill;

    public String getDescription() {
        return descriptionSkill;
    }

    public void setDescription(String description) {
        this.descriptionSkill = description;
    }

}
