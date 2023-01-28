package com.example.jetnote.screen

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnote.R
import com.example.jetnote.components.NoteInputText
import com.example.jetnote.components.NoteButton
import com.example.jetnote.data.NoteData
import com.example.jetnote.model.Note
import java.time.format.DateTimeFormatter


@Composable
fun NoteScreen( notes : List<Note> , onAddNote : (Note) -> Unit , onRemoveNote : (Note) -> Unit){
    var title by remember{
        mutableStateOf("")
    }
    var discription by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(6.dp)) {
     TopAppBar(
         title = { Text(text = stringResource(id = R.string.app_name))},
         actions = { Icon(imageVector = Icons.Rounded.Notifications, contentDescription ="topAppBar_Icon" )},
         backgroundColor = Color(0xFF2F6997)
     )
    // content
   Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
       NoteInputText(modifier = Modifier.padding(top = 9.dp , bottom = 8.dp), text =title , label = "Title", onTextChange ={
           title = it
       })
       NoteInputText(modifier = Modifier.padding(top = 9.dp , bottom = 8.dp), text =discription , label = "Add a note", onTextChange = {
           discription = it
       })
       NoteButton(modifier =Modifier , text ="save" , onClick = {
                if (title.isNotEmpty() && discription.isNotEmpty()){
                    title = ""
                    discription = ""
                }
       })
   }  
   
   Divider()
        LazyColumn{
            items(notes){note->
           NoteRow(note = note, onNoteClicked ={} )

            }
        }

    }

}
@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note :Note,
    onNoteClicked : (Note) -> Unit
){
    
    Surface(modifier = Modifier
        .padding(4.dp)
        .clip(RoundedCornerShape(topEnd = 33.dp, bottomEnd = 33.dp))
        .fillMaxWidth(),
            color = Color(0xFFDFE6EB) , elevation = 6.dp
        ){
        Column(modifier = Modifier
            .clickable { }
            .padding(horizontal = 14.dp, vertical = 6.dp), horizontalAlignment = Alignment.Start) {
            Text(text = note.title , style = MaterialTheme.typography.subtitle2)
            Text(text = note.discription, style = MaterialTheme.typography.subtitle2)
            Text(text = note.entryData.format(DateTimeFormatter.ofPattern("EEE , d MMM")) , style =MaterialTheme.typography.caption )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun NoteScreenPreview(){
    NoteScreen( notes =NoteData().loadNotes() , onAddNote = {} , onRemoveNote = {})
}