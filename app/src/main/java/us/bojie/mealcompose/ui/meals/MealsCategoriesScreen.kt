package us.bojie.mealcompose.ui.meals

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import us.bojie.mealcompose.model.response.Category
import us.bojie.mealcompose.ui.theme.MealComposeTheme


@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val categories = viewModel.categoriesState.value

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(categories) { category ->
            MealCategory(category = category)
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MealCategory(category: Category) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row {
            Image(
                painter = rememberImagePainter(category.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
            )
            Column(
                Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(
                    text = category.name,
                    style = MaterialTheme.typography.h6
                )
            }
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