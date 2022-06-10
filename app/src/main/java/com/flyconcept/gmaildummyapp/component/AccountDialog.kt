package com.flyconcept.gmaildummyapp.component


import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PersonAddAlt
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmapConfig
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.flyconcept.gmaildummyapp.MockData
import com.flyconcept.gmaildummyapp.R
import com.flyconcept.gmaildummyapp.model.Accounts

@Composable
fun AccountDialog(openDialog: MutableState<Boolean>) {

    Dialog(onDismissRequest = { openDialog.value = false },
    properties = DialogProperties(dismissOnClickOutside = false)
    ) {
        AccountDialogUI(openDialog = openDialog)
    }
}

@Composable
fun AccountDialogUI(modifier: Modifier = Modifier, openDialog: MutableState<Boolean>) {
    Card() {
        Column(
            modifier = modifier
                .background(Color.White)
                .padding(bottom = 16.dp)
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { openDialog.value = false }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "")
                }

                Image(
                    painter = painterResource(id = R.drawable.img), contentDescription = "",
                    modifier
                        .size(30.dp)
                        .weight(2.0f)
                )
            }
            AccountItem(accounts = MockData().accountList[0])

            Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Card(
                    modifier.requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = Color.Gray)
                ) {
                    Text(
                        text = "Google Account",
                        modifier.padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = modifier.width(10.dp))
            }
            Divider(modifier.padding(top = 16.dp))
            Column {
                AccountItem(accounts = MockData().accountList[1])
                AccountItem(accounts = MockData().accountList[2])
            }
            AddAccount(icon = Icons.Default.PersonAddAlt, title = "Add account on this device")
            AddAccount(icon = Icons.Outlined.ManageAccounts, title = "Manage Account")
            Divider(modifier.padding(top = 16.dp, bottom = 16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Privacy policy")
                Card(modifier = Modifier
                    .padding(top = 10.dp)
                    .size(5.dp), shape = CircleShape) {

                }
                Text(text = "Terms of service")
            }

        }
    }
}

@Composable
fun AccountItem(accounts: Accounts) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp)
    ) {
        if (accounts.icon != null) {
            Image(
                painter = painterResource(id = accounts.icon),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Color.Gray)
            )
        } else {
            Card(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(40.dp)
                    .clip(CircleShape),
                backgroundColor = Color.Gray
            ) {
                Text(
                    text = accounts.userName[0].toString(),
                    textAlign = TextAlign.Center, modifier = Modifier.padding(8.dp)
                )

            }
        }
        Column(
            modifier = Modifier
                .weight(2.0f)
                .padding(start = 16.dp, bottom = 16.dp)
        ) {
            Text(text = accounts.userName, fontWeight = FontWeight.Bold)
            Text(text = accounts.email)
        }
        Text(text = accounts.unReadMails.toString(), modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun AddAccount(icon: ImageVector, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview

fun AccountDialogUIPreview() {
    AccountDialogUI(openDialog = mutableStateOf(false))
}