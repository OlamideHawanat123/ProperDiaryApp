package africa.semicolon.services;

import africa.semicolon.DTOs.requests.*;
import africa.semicolon.DTOs.responses.*;
import africa.semicolon.Exceptions.EmailAlreadyExistException;
import africa.semicolon.Exceptions.InvalidDetailsException;
import africa.semicolon.Exceptions.InvalidPasswordSizeException;
import africa.semicolon.Utils.Mapper;
import africa.semicolon.data.models.Entry;
import africa.semicolon.data.models.User;
import africa.semicolon.data.repositories.EntriesRepository;
import africa.semicolon.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserServices {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntriesRepository entriesRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        verifyUserEmail(request.getEmail().trim().toLowerCase());
        checkEmailAndPassword(request.getEmail().trim().toLowerCase(), request.getPassword().trim().toLowerCase());
        validateFirstNameAndLastName(request.getFirstName(), request.getLastName());
        validatePasswordLength(request.getPassword().trim());

        User user = Mapper.mapRequestToUser(request);
        userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("User registered successfully");
        response.setId(user.getId());
        return response;
    }

    @Override
    public AddRequestResponse addEntry(AddEntryRequest request) {
        Entry entry = Mapper.mapDetailsToEntry(request);
       entriesRepository.save(entry);
       AddRequestResponse response =  new AddRequestResponse();
       response.setMessage("Entry added successfully");
       return response;
    }

    @Override
    public EditEntryResponse editEntry(EditEntryRequest request) {
        String oldTitle = request.getOldTitle().trim();
        Entry entry = entriesRepository.findByTitleIgnoreCase(request.getOldTitle()).orElseThrow();
        entry.setTitle(request.getNewTitle());
        entry.setContent(request.getNewContent());
        entry.setDateCreated(request.getDateModified());
        entriesRepository.save(entry);

        EditEntryResponse response = new EditEntryResponse();
        response.setMessage("Entry updated successfully!");
        return response;

    }

    @Override
    public DeleteEntryResponse deleteEntry(DeleteEntryRequest request) {
        Entry entry = entriesRepository.findByTitleIgnoreCase(request.getEntryTitle()).orElseThrow();
        entriesRepository.delete(entry);
        DeleteEntryResponse response = new DeleteEntryResponse();
        response.setMessage("Entry deleted successfully!");
        return response;

    }

    @Override
    public DeleteUserResponse deleteUser(DeleteUserRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        userRepository.delete(user);
        DeleteUserResponse response = new DeleteUserResponse();
        response.setMessage("Account deleted successfully!");
        return response;
    }

    private boolean confirmExistingEntry(String oldTitle){
        return entriesRepository.existsByTitle(oldTitle);
    }

//    private Entry getExistingEntry(String title){
//        return entriesRepository.findByTitle(title);
//    }

    private void verifyUserEmail(String email) {
        if (userRepository.existsByEmail(email)) throw new EmailAlreadyExistException("Email already exist");
    }

    private void checkEmailAndPassword(String email, String password) {
        if (email.isBlank() || password.isBlank()) throw new InvalidDetailsException("Email or password cannot be empty");

    }

    private void validateFirstNameAndLastName(String firstName, String lastName) {
        if (firstName.isBlank() && lastName.isBlank()) throw new InvalidDetailsException("First name or last name cannot be empty");
    }

    private void validatePasswordLength(String password){
        if(password.trim().length() <  4 ||  password.trim().length() > 16)throw new InvalidPasswordSizeException("Password length must be greaterthan 4 and less than 16");
    }


}

