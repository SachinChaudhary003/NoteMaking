package com.example.notemaking

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
   val allnotes : LiveData<List<Note>>

  private  val repository: NoteRepository
    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
         repository = NoteRepository(dao)
         allnotes = repository.allNotes
    }

    fun delete(note: Note) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(note)
    }

    fun insert(note: Note) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }
}