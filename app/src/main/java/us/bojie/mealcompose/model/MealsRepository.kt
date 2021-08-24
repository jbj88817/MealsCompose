package us.bojie.mealcompose.model

import us.bojie.mealcompose.model.response.MealsCategoriesResponse

class MealsRepository {

    fun getMeals(): MealsCategoriesResponse = MealsCategoriesResponse(arrayListOf())
}