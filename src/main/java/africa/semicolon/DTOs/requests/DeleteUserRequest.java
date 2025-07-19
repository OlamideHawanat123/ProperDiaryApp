package africa.semicolon.DTOs.requests;

import africa.semicolon.data.models.Reason;
import lombok.Data;

@Data
public class DeleteUserRequest {
    private String email;
    private String password;
    private Reason reason;
}
