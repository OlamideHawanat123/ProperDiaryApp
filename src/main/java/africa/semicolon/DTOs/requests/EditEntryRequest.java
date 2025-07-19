package africa.semicolon.DTOs.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EditEntryRequest {
    private String oldTitle;
    private String newTitle;
    private String newContent;
    private LocalDate dateModified;
}
