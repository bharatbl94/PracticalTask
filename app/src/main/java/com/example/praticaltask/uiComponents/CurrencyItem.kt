package com.example.praticaltask.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuickLinkItem(
    modifier: Modifier = Modifier,
    name: String,
    icon: Int,
    iconColor: Color? = null,
    backgroundColor: Color = Color.White,
    borderColor: Color = Color.White,
    onClickItem: () -> Unit
) {
    val blackColor = Color.Black
    val textStyleValue = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal, color = blackColor, textAlign = TextAlign.Center)
    val textStyleName = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal, color = blackColor, textAlign = TextAlign.Center)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(2.dp).width(80.dp).clickable { onClickItem() }
    ) {
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = name,
            style = textStyleValue,
            color = blackColor,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Divider(modifier = Modifier.padding(top = 6.dp).height(0.5.dp).background(color = Color.Gray))
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = name,
            style = textStyleName,
            color = blackColor,
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewQuickLinkItem(){
//    QuickLinkItem(
//        name = "Add Meetings",
//        icon = R.drawable.add_meeting_icon,
//        backgroundColor = Color.White
//    )
//}

