package com.flyconcept.gmaildummyapp.component

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.flyconcept.gmaildummyapp.model.HomeBottomMenuData

@Composable
fun HomeBottomMenu() {
    val item = listOf(
        HomeBottomMenuData.Mail,
        HomeBottomMenuData.Meet
    )
    BottomNavigation(backgroundColor = Color.White, contentColor = Color.Black) {
        item.forEach {

            BottomNavigationItem(
                label = { Text(text = it.title) }, selected = false, onClick = { /*TODO*/ },
                alwaysShowLabel = true,
                icon = { Icon(imageVector = it.icon!!, contentDescription = it.title) })
        }
    }
}