package jjad.springframework.recipe.repositories;

import jjad.springframework.recipe.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
