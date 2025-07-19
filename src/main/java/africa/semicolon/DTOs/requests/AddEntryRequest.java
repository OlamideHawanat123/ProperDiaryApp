package africa.semicolon.DTOs.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddEntryRequest {
    private String title;
    private String content;
    private LocalDate dateCreated;
}
