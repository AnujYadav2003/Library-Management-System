package com.book.LibraryManagementSystem.Service;

import com.book.LibraryManagementSystem.LibraryDTO.BookResponse;
import com.book.LibraryManagementSystem.LibraryDTO.UserRequest;
import com.book.LibraryManagementSystem.LibraryDTO.UserResponse;
import com.book.LibraryManagementSystem.Model.BookModel;
import com.book.LibraryManagementSystem.Model.Role;
import com.book.LibraryManagementSystem.Model.UserModel;
import com.book.LibraryManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public UserResponse createUser(UserRequest userRequest)
//    {
//        UserModel user=new UserModel();
//        user.setUsername(userRequest.getUsername());
//        user.setEmail(userRequest.getEmail());
//        user.setPassword(userRequest.getPassword());
//        user.setRole(userRequest.getRole());
//
//       UserModel newUser= userRepository.save(user);
//        return mapToUserResponse(newUser);
//    }
//
//    public List<UserResponse> getAllUsers()
//    {
//        List<UserModel> allUsers = userRepository.findAll();
//
//        return allUsers.stream()
//                .map(this::mapToUserResponse)
//                .collect(Collectors.toList());
//    }
//
//    public UserResponse getUserById(Long userId)
//    {
//        Optional<UserModel> user = userRepository.findById(userId);
//        if(!user.isPresent())
//            throw new RuntimeException("User not found with User ID: "+userId);
//
//        else {
//            UserModel user1 = user.get();
//            return mapToUserResponse(user1);
//        }
//    }
//
//
//    public String updateRole(String changedRole, Long userId)
//    {
//        Optional<UserModel> isExists = userRepository.findById(userId);
//
//        if(!isExists.isPresent())
//        {
//            throw new RuntimeException("User not found with User ID: " + userId);
//        }
//        else {
//            UserModel user = isExists.get();
//            if(user.getRole()==changedRole)
//                return "User have already with of "+changedRole;
//            user.setRole(changedRole);
//            userRepository.save(user);
//            return "User already has the role of " + changedRole;
//        }
//    }
//
//
//
//    public String updateUserInfo(UserRequest userRequest, Long userId)
//    {
//        Optional<UserModel> isExists = userRepository.findById(userId);
//
//        if(!isExists.isPresent())
//        {
//            throw new RuntimeException("User not found with User ID: " + userId);
//        }
//        else{
//            UserModel user = isExists.get();
//            user.setUsername(userRequest.getUsername());
//            user.setEmail(userRequest.getEmail());
//            user.setPassword(userRequest.getPassword());
//            user.setRole(userRequest.getRole());
//
//            userRepository.save(user);
//            return "User information is updated successfully";
//        }
//    }
//
//
//
//
//    public String deleteUser(Long userId)
//    {
//        Optional<UserModel> isExists = userRepository.findById(userId);
//
//        if(!isExists.isPresent())
//        {
//            throw new RuntimeException("User not found with User ID: " + userId);
//        } else {
//            userRepository.deleteById(userId);
//            return "User Deleted successfully";
//        }
//    }
//
//
//
//
//
//    private UserResponse mapToUserResponse(UserModel user) {
//        return new UserResponse(
//                user.getId(),
//                user.getUsername(),
//                user.getEmail(),
//                user.getPassword(),
//                user.getRole()
//        );
//    }
//
//
//}

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Helper function to find user by userId
    private Optional<UserModel> findUserById(Long userId) {
        Optional<UserModel> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new RuntimeException("User not found with User ID: " + userId);
        }
        return user;
    }

    public UserResponse createUser(UserRequest userRequest) {
        UserModel user = new UserModel();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());

        UserModel newUser = userRepository.save(user);
        return mapToUserResponse(newUser);
    }

    public List<UserResponse> getAllUsers() {
        List<UserModel> allUsers = userRepository.findAll();

        return allUsers.stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getUserById(Long userId) {
        UserModel user = findUserById(userId).get();
        return mapToUserResponse(user);
    }

//    public String updateRole(String changedRole, Long userId) {
//        UserModel user = findUserById(userId).get();
//
//        if (user.getRole().equals(changedRole)) {
//            return "User already has the role of " + changedRole;
//        }
//        user.setRole(changedRole);
//        userRepository.save(user);
//        return "User role updated to " + changedRole;
//    }

    public String updateRole(String changedRole, Long userId) {
        UserModel user = findUserById(userId).get(); // Make sure to handle the potential absence of user

        // Convert String to Enum (Role)
        Role newRole;
        try {
            newRole = Role.valueOf(changedRole.toUpperCase()); // Convert the role to enum (case-insensitive)
        } catch (IllegalArgumentException e) {
            return "Invalid role: " + changedRole; // If role doesn't exist in enum, return error
        }

        // Check if the role is already set
        if (user.getRole().equals(newRole)) {
            return "User already has the role of " + changedRole;
        }

        // Update the user's role
        user.setRole(newRole);
        userRepository.save(user);
        return "User role updated to " + changedRole;
    }

    public String updateUserInfo(UserRequest userRequest, Long userId) {
        UserModel user = findUserById(userId).get();

        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());

        userRepository.save(user);
        return "User information updated successfully";
    }

    public String deleteUser(Long userId) {
        UserModel user = findUserById(userId).get();

        userRepository.deleteById(userId);
        return "User deleted successfully";
    }

    private UserResponse mapToUserResponse(UserModel user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole().name()
        );
    }
}

