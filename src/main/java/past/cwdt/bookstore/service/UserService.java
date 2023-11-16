package past.cwdt.bookstore.service;

import past.cwdt.bookstore.dto.user.UserRegistrationRequestDto;
import past.cwdt.bookstore.dto.user.UserResponseDto;
import past.cwdt.bookstore.exceptions.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto userRegistrationRequestDto)
            throws RegistrationException;
}
