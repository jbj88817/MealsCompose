package us.bojie.mealcompose.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import us.bojie.mealcompose.model.MealsRepository
import us.bojie.mealcompose.model.response.Category

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
) : ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        // Show an error to the UI
    }

    init {
        viewModelScope.launch(coroutineExceptionHandler) {
            val categories = getCategories()
            categoriesState.value = categories
        }
    }

    val categoriesState: MutableState<List<Category>> = mutableStateOf(emptyList())

    private suspend fun getCategories(): List<Category> = repository.getMeals().categories

}