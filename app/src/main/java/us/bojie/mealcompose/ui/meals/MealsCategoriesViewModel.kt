package us.bojie.mealcompose.ui.meals

import androidx.lifecycle.ViewModel
import us.bojie.mealcompose.model.MealsRepository
import us.bojie.mealcompose.model.response.Category

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
) : ViewModel() {

    suspend fun getCategories(): List<Category> = repository.getMeals().categories

}