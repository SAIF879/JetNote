package com.example.jetnote.screen

import androidx.lifecycle.ViewModel
import com.example.jetnote.data.NoteData
import com.example.jetnote.model.Note

class NoteViewModel : ViewModel() {
    var noteList  = mutableListOf<Note>()

    // to load the inital loading of data
    init {
        noteList.addAll(NoteData().loadNotes())
    }

    fun addNote(note: Note){noteList.add(note)}
    fun removeNote(note:Note){noteList.remove(note)}
    fun getAllNotes():List<Note>{return noteList}
}