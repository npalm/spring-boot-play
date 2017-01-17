package play.service;

import org.springframework.stereotype.Service;
import play.model.Note;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;

@Service("recordingService")
@Transactional
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteRepository noteRepository;


    @Override
    public Iterable<Note> getNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Iterable<Note> getNoteForUser(String userId) {
        return noteRepository.findByUserId(userId);
    }

    @Override
    public Note getNote(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public Note save(final Note note) {
        if(note.getCreated() == null) {
            note.setCreated(new Date());
        }

        return noteRepository.save(note);
    }


}
