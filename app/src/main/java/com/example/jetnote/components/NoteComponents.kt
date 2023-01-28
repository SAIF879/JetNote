package com.example.jetnote.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction


// here we first create a function to draw the  required TextFields : )
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteInputText(
    modifier: Modifier,
    text : String,
    label : String  ,
    maxLine : Int = 1 ,
    onTextChange :(String) -> Unit,
    onImeAction: () -> Unit = {},
){
    val keyboardController =LocalSoftwareKeyboardController.current
 TextField(value = text, onValueChange = onTextChange, colors = TextFieldDefaults.textFieldColors(
     backgroundColor = Color.White,
     unfocusedLabelColor = Color.Black,
     focusedLabelColor = Color.Red,
     focusedIndicatorColor = Color.Black,
     unfocusedIndicatorColor = Color.Black
 ),
 maxLines = maxLine , label = { Text(text = label)},
     keyboardOptions = KeyboardOptions.Default.copy(
         imeAction = ImeAction.Done,

     ),
     keyboardActions = KeyboardActions(onDone =
     {
         onImeAction()
         keyboardController?.hide()
     })
 ,
     modifier = modifier,
     textStyle = TextStyle(color = Color.Red)

     )

}

@Composable
fun NoteButton(
    modifier: Modifier,
    text : String,
    onClick : () -> Unit,
    enabled : Boolean = true,
){
    Button(onClick = onClick , enabled = enabled , shape = CircleShape , ) {
        Text(text =text )
    }

}