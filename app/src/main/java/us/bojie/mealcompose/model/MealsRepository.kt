package us.bojie.mealcompose.model

import us.bojie.mealcompose.model.api.MealsWebService
import us.bojie.mealcompose.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMeals(): MealsCategoriesResponse = webService.getMeals()
}