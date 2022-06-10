package com.flyconcept.gmaildummyapp.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector

sealed class HomeBottomMenuData(
    val icon: ImageVector,
    val title: String
) {
    object Mail : HomeBottomMenuData(icon = Icons.Outlined.Mail, "Mail")
    object Meet : HomeBottomMenuData(icon = Icons.Outlined.VideoCall, "videoCall")
}