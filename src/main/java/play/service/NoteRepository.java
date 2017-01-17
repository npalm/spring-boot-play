package play.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import play.model.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {

    Page<Note> findAll(Pageable pageable);

    Iterable<Note> findByUserId(String userId);

    Note findById(Long id);
}
