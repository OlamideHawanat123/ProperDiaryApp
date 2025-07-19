package africa.semicolon.services;

import africa.semicolon.DTOs.requests.*;
import africa.semicolon.DTOs.responses.*;

public interface UserServices {
    RegisterUserResponse registerUser(RegisterUserRequest request);

    AddRequestResponse addEntry(AddEntryRequest request);

    EditEntryResponse editEntry(EditEntryRequest request);

    DeleteEntryResponse deleteEntry(DeleteEntryRequest request);

    DeleteUserResponse deleteUser(DeleteUserRequest request);
}
