package nl.inthebag.inthebagbackend.services;

import nl.inthebag.inthebagbackend.dtos.UserDto;
import nl.inthebag.inthebagbackend.exceptions.RecordNotFoundException;
import nl.inthebag.inthebagbackend.models.User;
import nl.inthebag.inthebagbackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

//    UserService Controller
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    Find all users in the application
    public List<UserDto> findAllUsers() {
        List<User> allUsers = userRepository.findAll();
        List<UserDto> allDtoUsers = new ArrayList<>();

        for (User u : allUsers) {
            UserDto userDto = transferToDto(u);
            allDtoUsers.add(userDto);
        }

        return allDtoUsers;
    }

//    Find user by ID
    public UserDto findUserById(int id) {
        UserDto userDto;
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userDto = transferToDto(user);
        } else {
            throw new RecordNotFoundException("Deze gebruiker komt niet voor in de database.");
        }
        return userDto;
    }

//    Post new User
    public UserDto addNewUser(UserDto userDto) {
        User newUser = transferToEntity(userDto);
        userRepository.save(newUser);
        return transferToDto(newUser);
    }

//    Update existing user
    public UserDto updateExistingUser(int id, UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(id);
        User user;

        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            throw new RecordNotFoundException("Deze gebruiker komt niet voor in de database");
        }

        userRepository.save(user);
        return transferToDto(user);
    }

//    Delete User from the DB
    public void deleteUser(int id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Deze gebruiker komt niet voor in de database.");
        }
    }

//    Transfer Entity to Dto
    public UserDto transferToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setDob(user.getDob());
        userDto.setEmailAddress(user.getEmailAddress());
        return userDto;
    }

//    Transfer Dto to Entity
    public User transferToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setDob(userDto.getDob());
        user.setEmailAddress(userDto.getEmailAddress());
        return user;
    }

}
