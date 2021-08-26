package us.bojie.mealcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import us.bojie.mealcompose.ui.meals.MealsCategoriesScreen
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
