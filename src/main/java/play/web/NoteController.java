package play.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import play.model.Note;
import play.service.NoteService;

import javax.annotation.Resource;


@Controller
@RequestMapping(value = "/notes")
public class NoteController {

    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

    @Resource
    private NoteService noteService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Note>> list(@RequestParam(value = "userId") final String userId) {
        logger.info(String.format("Looking up notes for user: '%s", userId));

        return new ResponseEntity<>(noteService.getNoteForUser(userId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Note> getNote(@PathVariable(value = "id") final Long id) {
        logger.info(String.format("Looking up note '%d", id));
        return new ResponseEntity<>(noteService.getNote(id), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Note> create(@RequestBody Note note) {
        if(note.getText() == null) {
            throw new IllegalArgumentException();
        } else if (note.getText().equalsIgnoreCase("bla")) {
            throw new IllegalStateException();
        }

        logger.info("Creating new record.");
        return new ResponseEntity<>(noteService.save(note), HttpStatus.CREATED);
    }




}
