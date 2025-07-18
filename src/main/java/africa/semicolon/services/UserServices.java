package africa.semicolon.services;

import africa.semicolon.DTOs.requests.RegisterUserRequest;
import africa.semicolon.DTOs.responses.RegisterUserResponse;

public interface UserServices {
    RegisterUserResponse registerUser(RegisterUserRequest request);
}
