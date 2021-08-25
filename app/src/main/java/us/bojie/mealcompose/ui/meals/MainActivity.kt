package us.bojie.mealcompose.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import us.bojie.mealcompose.model.response.Category
import us.bojie.mealcompose.ui.theme.MealComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealComposeTheme {
                MealsCategoriesScreen()
            }
        }
    }
}

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val rememberedCategories: MutableState<List<Category>> =
        remember { mutableStateOf(emptyList()) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = "Get meals") {
        coroutineScope.launch(Dispatchers.IO) {
            val categories = viewModel.getCategories()
            rememberedCategories.value = categories
        }
    }

    LazyColumn {
        items(rememberedCategories.value) { category ->
            Text(text = category.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealComposeTheme {
        MealsCategoriesScreen()
    }
}