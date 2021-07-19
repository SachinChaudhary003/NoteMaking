package com.example.notemaking

import androidx.lifecycle.LiveData

class NoteRepository(private  val nodeDao: NodeDao) {

    val allNotes : LiveData<List<Note>> = nodeDao.getAllNotes()

    suspend fun insert(note: Note){
        nodeDao.insert(note)
    }

    suspend fun delete(note: Note){
        nodeDao.delete(note)
    }
}