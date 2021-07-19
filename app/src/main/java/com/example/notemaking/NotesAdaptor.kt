package com.example.notemaking

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.prefs.NodeChangeListener

class NotesAdaptor(private val context : Context, private val listener: INotesRvAdaptor) : RecyclerView.Adapter<NotesAdaptor.NotesViewHolder>() {
   private val allnotes = ArrayList<Note>()
    inner class NotesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton = itemView.findViewById<ImageView>(R.id.deletebutton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
       val viewHolder = NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note , parent, false))
         viewHolder.deleteButton.setOnClickListener{
             listener.onItemClicked(allnotes[viewHolder.adapterPosition])
    }
        return viewHolder

    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
      val currentNote =allnotes[position]
      holder.textView.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return allnotes.size
    }

    fun updatelist(newlist : List<Note>){
        allnotes.clear()
        allnotes.addAll(newlist)

        notifyDataSetChanged()
    }
}

interface INotesRvAdaptor {
    fun onItemClicked(note: Note)
}