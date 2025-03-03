package com.example.praticaltask.uiComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun DropDownList(
    requestToOpen: Boolean = false,
    list: List<String>,
    request: (Boolean) -> Unit,
    selectedString: (String, Int) -> Unit,
) {
    DropdownMenu(
        modifier = Modifier.fillMaxWidth(),
//        toggl = {
//            // Implement your toggle
//        },
        expanded = requestToOpen,
        onDismissRequest = { request(false) },
    ) {
        list.forEachIndexed { index, data ->
            DropdownMenuItem(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    request(false)
                    selectedString(data, index)
                }, text = {
                    Text(
                        data,
                        modifier = Modifier
                            .wrapContentWidth()
                    )
                })
        }
    }
}
