package com.googleapp.unitconverterapp.compose.converter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.googleapp.unitconverterapp.data.Conversion

@Composable
fun ConversionMenu(list: List<Conversion>, modifier: Modifier = Modifier, convert : (Conversion) -> Unit) {
    var displayText by remember { mutableStateOf("Select the conversion type") }
    var textSizeField by remember { mutableStateOf(Size.Zero) }
    var expand by remember { mutableStateOf(false) }
    var icon = if (expand)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    Column() {
        OutlinedTextField(
            value = displayText, onValueChange = { displayText = it },
            textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned { cordinates ->
                    textSizeField = cordinates.size.toSize()
                },
            label = { Text(text = "Conversion type") },
            trailingIcon = {
                Icon(icon, contentDescription = "icon",
                    modifier.clickable { expand = !expand })
            },
            readOnly = true
        )
        DropdownMenu(
            expanded = expand, onDismissRequest = { expand = false },
            modifier = modifier.width(with(LocalDensity.current) {
                textSizeField.width.toDp()
            })
        ) {
            list.forEach { conversion ->
                DropdownMenuItem(text = {
                    Text(
                        text = conversion.description,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }, onClick = {
                    displayText = conversion.description
                    expand = false
                    convert(conversion)
                })


            }
        }
    }

}