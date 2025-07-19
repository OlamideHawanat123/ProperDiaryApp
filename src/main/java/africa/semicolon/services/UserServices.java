package africa.semicolon.services;

import africa.semicolon.DTOs.requests.AddEntryRequest;
import africa.semicolon.DTOs.requests.EditEntryRequest;
import africa.semicolon.DTOs.requests.RegisterUserRequest;
import africa.semicolon.DTOs.responses.AddRequestResponse;
import africa.semicolon.DTOs.responses.EditEntryResponse;
import africa.semicolon.DTOs.responses.RegisterUserResponse;

public interface UserServices {
    RegisterUserResponse registerUser(RegisterUserRequest request);

    AddRequestResponse addEntry(AddEntryRequest request);

    EditEntryResponse editEntry(EditEntryRequest request);
}
