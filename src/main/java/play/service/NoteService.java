package play.service;

import play.model.Note;

public interface NoteService {

    public Iterable<Note> getNotes();

    public Iterable<Note> getNoteForUser(String userId);

    public Note getNote(Long id);

    public Note save(Note note);

}
