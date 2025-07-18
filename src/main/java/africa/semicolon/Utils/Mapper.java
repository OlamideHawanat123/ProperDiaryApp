package africa.semicolon.Utils;

import africa.semicolon.DTOs.requests.RegisterUserRequest;
import africa.semicolon.data.models.User;

public class Mapper {
    public static User mapRequestToUser(RegisterUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail().trim().toLowerCase());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        return user;
    }
}
