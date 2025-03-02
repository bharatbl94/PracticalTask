package com.example.praticaltask.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Bharat Lalwani on 12/07/22.
 */
@Composable
fun SpinnerSelection(name: String, list: List<String>, selectedString: String = "", textLabel: String = "") {
    var text by remember { mutableStateOf(selectedString) } // initial value
    var isOpen by remember { mutableStateOf(false) } // initial value
    val openCloseOfDropDownList: (Boolean) -> Unit = {
        isOpen = it
    }
    val userSelectedString: (String, Int) -> Unit = { data, index ->
        text = data
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = name,
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(3f)
        )
        Box(modifier = Modifier.weight(7f)) {
            Column {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    enabled = false,
                    label = { Text(text = textLabel) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                )
                DropDownList(
                    requestToOpen = isOpen,
                    list = list,
                    openCloseOfDropDownList,
                    userSelectedString
                )
            }
            Spacer(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.Transparent)
                    .padding(10.dp)
                    .clickable(
                        onClick = { isOpen = true }
                    )
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_down),
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterEnd)
                    .padding(8.dp, 2.dp),
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSpinner() {
    SpinnerSelection("Spinner Name", listOf("Bharat", "Outdoor", "India"), "Outdoor", "svf")
}
