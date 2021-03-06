package ru.cppshiz.todolistapp.feature_todo.presentation.todos.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconRadioButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    selected: Boolean,
    onSelect: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onSelect,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colors.primary,
                unselectedColor = MaterialTheme.colors.primaryVariant
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(imageVector = imageVector,
            contentDescription = "RadioButtonImage",
            Modifier.clickable { onSelect() })
    }
}