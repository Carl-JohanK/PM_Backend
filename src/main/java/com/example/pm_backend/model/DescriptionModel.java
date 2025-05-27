package com.example.pm_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DescriptionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 500)
    String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    RecipeModel recipe;

    @JsonIgnore
    public void setRecipe(RecipeModel recipe) {
        this.recipe = recipe;
    }

    public RecipeModel getRecipe() {
        return recipe;
    }

    public String getDescription() {
        return description;
    }

    @JsonIgnore
    public boolean isValid(){
        return !this.description.isEmpty();
    }
}
