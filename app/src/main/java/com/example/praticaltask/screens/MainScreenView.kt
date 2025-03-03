package com.example.praticaltask.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.praticaltask.R
import com.example.praticaltask.uiComponents.DropDownList
import com.example.praticaltask.uiComponents.InputTextField
import com.example.praticaltask.viewModels.MainViewModel

/**
 *Created by Bharat Lalwani on 02/03/25
 */

@Composable
fun MainScreenView(viewModel: MainViewModel?, modifier: Modifier) {
    val updatedData = viewModel?.currencyApiResponse?.collectAsState()?.value
    var isOpen by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
    }

    Column(
        modifier = modifier.fillMaxSize(),
    ) {

        InputTextField(
            placeholder = "Enter Value",
            text = "",
            viewMargin = 0.dp,
            keyboardType = KeyboardType.Decimal,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .padding(2.dp)
                .border(width = 0.5.dp, color = Color.Gray, shape = RoundedCornerShape(4))
        )

        Box(modifier = Modifier.align(Alignment.End).padding(top = 8.dp, end = 10.dp)) {

            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text(
                    text = "ABCD",
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .border(width = 0.5.dp, color = Color.Gray, shape = RoundedCornerShape(4))
                        .height(32.dp)
                        .padding(top = 8.dp, start = 12.dp, end = 28.dp)
                        .clickable {
                            isOpen = true
                        }
                )
                DropDownList(
                    requestToOpen = isOpen,
                    list = arrayListOf("ABCD", "ABCD"),
                    { isOpen = it },

                    ) { name, index ->
                }
            }

            Image(
                painter = painterResource(id = R.drawable.arrow_down),
                contentDescription = "",
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.CenterEnd)
                    .padding(end = 6.dp),
                contentScale = ContentScale.Crop,
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreenView() {
    MainScreenView(null, Modifier.fillMaxSize())
}