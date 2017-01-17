package play.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "notes")
public class Note implements Serializable {

    @Id
    @GeneratedValue
    private final Long id = null;

    private String userId;

    private String text;

    private Date created;
}
