package africa.semicolon.services;

import africa.semicolon.DTOs.requests.RegisterUserRequest;
import africa.semicolon.DTOs.responses.RegisterUserResponse;
import africa.semicolon.Exceptions.EmailAlreadyExistException;
import africa.semicolon.Exceptions.InvalidDetailsException;
import africa.semicolon.Exceptions.InvalidPasswordSizeException;
import africa.semicolon.data.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplementationTest {
    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testThatUserCanRegister(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFirstName("Ademide");
        request.setLastName("Adebayo");
        request.setEmail("Opemipo@gmail.com");
        request.setPassword("Opemps");
        RegisterUserResponse response = userServices.registerUser(request);
        assertNotNull(response);
        assertEquals("User registered successfully", response.getMessage());
    }

    @Test
    public void testThatUserCannotRegisterWithTheSameEmail(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFirstName("opemipo");
        request.setLastName("Adebayo");
        request.setEmail("malik@gmail.com");
        request.setPassword("opemipo");

        RegisterUserRequest request2 = new RegisterUserRequest();
        request2.setFirstName("adewale");
        request2.setLastName("Adeshile");
        request2.setEmail("malik@gmail.com");
        request2.setPassword("hakeem");
        userServices.registerUser(request2);

        assertThrows(EmailAlreadyExistException.class, () ->{
            userServices.registerUser(request);
        });
    }

    @Test
    public void testThatEmailCannotBeEmptyWhileRegistering(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFirstName("tope");
        request.setLastName("Adebayo");
        request.setEmail("");
        request.setPassword("tope");

        assertThrows(InvalidDetailsException.class, ()-> {
            userServices.registerUser(request);
        });
    }

    @Test
    public void testThatPasswordCannotBeEmptyWhileRegistering(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFirstName("tope");
        request.setLastName("Adebayo");
        request.setEmail("Ola@gmail.com");
        request.setPassword("");

        assertThrows(InvalidDetailsException.class, ()-> {
            userServices.registerUser(request);
        });
    }

    @Test
    public void testThatBothFirstNameAndLastNameCannotBeEmptyWhileRegistering(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFirstName("");
        request.setLastName("");
        request.setEmail("tee@gmail.com");
        request.setPassword("tope");

        assertThrows(InvalidDetailsException.class, ()-> {
            userServices.registerUser(request);
        });
    }

    @Test
    public void testThatUserPasswordMustBeOfNotBeLessThanFourCharacters(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFirstName("Olabiti");
        request.setLastName("");
        request.setEmail("Olabiti@gmail.com");
        request.setPassword("123");
        assertThrows(InvalidPasswordSizeException.class, ()->{
            userServices.registerUser(request);
        });
    }

    @Test
    public void testThatUserPasswordHasToBeLessThanSixteenCharacters(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFirstName("Olabiti");
        request.setLastName("");
        request.setEmail("pee@gmail.com");
        request.setPassword("12345678901234567");
        assertThrows(InvalidPasswordSizeException.class, ()->{
            userServices.registerUser(request);
        });
    }
}