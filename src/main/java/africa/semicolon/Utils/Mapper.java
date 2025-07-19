package africa.semicolon.Utils;

import africa.semicolon.DTOs.requests.AddEntryRequest;
import africa.semicolon.DTOs.requests.RegisterUserRequest;
import africa.semicolon.data.models.Entry;
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

    public static Entry mapDetailsToEntry(AddEntryRequest request) {
        User user = new User();
        Entry entry = new Entry();
        entry.setContent(request.getContent());
        entry.setDateCreated(request.getDateCreated());
        entry.setTitle(request.getTitle());
        entry.setUserId(user.getId());
        return entry;
    }
}
