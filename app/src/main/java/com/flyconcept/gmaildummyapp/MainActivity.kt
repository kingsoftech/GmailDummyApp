package com.flyconcept.gmaildummyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.flyconcept.gmaildummyapp.component.GmailDrawerMenu
import com.flyconcept.gmaildummyapp.component.GmailFab
import com.flyconcept.gmaildummyapp.component.HomeAppBar
import com.flyconcept.gmaildummyapp.component.HomeBottomMenu
import com.flyconcept.gmaildummyapp.ui.theme.GmailDummyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailDummyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GmailApp()
                }
            }
        }
    }
}

@Composable
fun GmailApp() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val openDialog = remember{
        mutableStateOf(false)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeAppBar(scaffoldState, coroutineScope,openDialog) },
        drawerContent = {
            GmailDrawerMenu(scrollState)

        },
        bottomBar = { HomeBottomMenu() },
    floatingActionButton = { GmailFab(scrollState)}) {
        MailList(paddingValues = it,scrollState)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailDummyAppTheme {
        GmailApp()
    }
}