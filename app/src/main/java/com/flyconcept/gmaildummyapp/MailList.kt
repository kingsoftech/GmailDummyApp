package com.flyconcept.gmaildummyapp

import android.content.ClipData
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flyconcept.gmaildummyapp.model.MailData


@Composable
fun MailList(paddingValues: PaddingValues, scrollState: ScrollState) {
Box(modifier = Modifier.padding(paddingValues = paddingValues)){
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .scrollable(scrollState,Orientation.Vertical)){
        items(MockData().mailList){
            mailData->
            MailItem(mailData = mailData )

        }
    }
}
}

@Composable
fun MailItem(mailData: MailData, modifier: Modifier = Modifier) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)) {
        Card(
            modifier = modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .clip(CircleShape),
            backgroundColor = Color.Gray
        ) {
            Text(text = mailData.userName[0].toString(),
            textAlign = TextAlign.Center,
            modifier = modifier.padding(8.dp))
        }
        Column(modifier = modifier.weight(2.0f)) {
            Text(mailData.userName,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
            )
            Text(mailData.subject,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(mailData.body,
                fontSize = 14.sp,
            )

        }
        Column {
            Text(text = mailData.timeStamp)
            IconButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .size(50.dp)
                .padding(top = 16.dp)) {
                Icon(imageVector = Icons.Outlined.StarOutline, contentDescription = "")
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun MailItemPreview(){
    val mailData=MailData(
        mailId = 2,
        userName = "Agatha",
        subject = "Job Application",
        body = "This is regarding a job opportunity I found on your website.",
        timeStamp = "20:10"
    )
    MailItem(mailData =mailData, modifier = Modifier)
}