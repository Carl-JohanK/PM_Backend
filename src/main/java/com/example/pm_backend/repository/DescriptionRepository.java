package com.example.pm_backend.repository;

import com.example.pm_backend.model.DescriptionModel;
import com.example.pm_backend.model.RecipeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends JpaRepository<DescriptionModel, Long> {
}
