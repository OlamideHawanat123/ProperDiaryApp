package africa.semicolon.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
public class Entry {
    @Id
    private String id;
    private String title;
    private String content;
    private LocalDate dateCreated;

    private String userId;
}
