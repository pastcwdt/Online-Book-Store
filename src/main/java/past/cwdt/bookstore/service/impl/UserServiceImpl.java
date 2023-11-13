package past.cwdt.bookstore.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import past.cwdt.bookstore.dto.user.UserRegistrationRequestDto;
import past.cwdt.bookstore.dto.user.UserResponseDto;
import past.cwdt.bookstore.exceptions.RegistrationException;
import past.cwdt.bookstore.mapper.UserMapper;
import past.cwdt.bookstore.model.RoleName;
import past.cwdt.bookstore.model.User;
import past.cwdt.bookstore.repository.user.RoleRepository;
import past.cwdt.bookstore.repository.user.UserRepository;
import past.cwdt.bookstore.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto request)
            throws RegistrationException {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new RegistrationException("Unable to complete registration.");
        }
        User savedUser = new User();
        savedUser.setEmail(request.email());
        savedUser.setRoles(new HashSet<>(Arrays.asList(
                roleRepository.findRoleByName(RoleName.USER))));
        savedUser.setFirstName(request.firstName());
        savedUser.setLastName(request.lastName());
        savedUser.setShippingAddress(request.shippingAddress());
        savedUser.setPassword(passwordEncoder.encode(request.password()));
        userRepository.save(savedUser);
        return userMapper.toUserResponseDto(savedUser);
    }
}
