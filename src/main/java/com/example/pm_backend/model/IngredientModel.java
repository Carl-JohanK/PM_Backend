package com.example.pm_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class IngredientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String item;

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

    public String getItem() {
        return item;
    }

    @JsonIgnore
    public boolean isValid(){
        return !this.item.isEmpty();
    }
}
