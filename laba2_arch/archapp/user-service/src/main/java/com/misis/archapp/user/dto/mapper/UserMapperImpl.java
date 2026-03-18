package com.misis.archapp.user.dto.mapper;

import com.misis.archapp.user.db.User;
import com.misis.archapp.user.dto.UserCreateDTO;
import com.misis.archapp.user.dto.UserDTO;
import com.misis.archapp.user.dto.UserUpdateDTO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        if (user == null) return null;
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    @Override
    public User toEntity(UserCreateDTO dto) {
        if (dto == null) return null;
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        return user;
    }

    @Override
    public List<UserDTO> toDTOList(List<User> users) {
        if (users == null) return null;
        return users.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void updateUserFromDTO(UserUpdateDTO dto, User user) {
        if (dto == null || user == null) return;
        dto.name().ifPresent(user::setName);
        dto.email().ifPresent(user::setEmail);
    }
}