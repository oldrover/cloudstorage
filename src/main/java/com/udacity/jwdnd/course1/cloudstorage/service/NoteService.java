package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private NoteMapper noteMapper;


    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    public int addNote(User user, NoteForm noteForm) {
        return noteMapper.insertNote(new Note(null, noteForm.getNoteTitle(), noteForm.getNoteDescription(), user.getUserId()));
    }

    public int deleteNote(Integer noteId) {
        return noteMapper.deleteNote(noteId);
    }

    public int updateNote(NoteForm noteForm) {
        return noteMapper.updateNote(new Note(noteForm.getNoteId(), noteForm.getNoteTitle(),noteForm.getNoteDescription(), null ));

    }

    public List<Note> getNotes(Integer userId) {
        return noteMapper.getNote(userId);
    }

}
