package com.example.jetnote.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnote.R

@Composable
fun NoteScreen(){
    Column(modifier = Modifier.padding(6.dp)) {
     TopAppBar(
         title = { Text(text = stringResource(id = R.string.app_name))},
         actions = { Icon(imageVector = Icons.Rounded.Notifications, contentDescription ="topAppBar_Icon" )},
         backgroundColor = Color(0xFF2F6997)
     ) 
         
     
            

    }

}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview(){
    NoteScreen()
}