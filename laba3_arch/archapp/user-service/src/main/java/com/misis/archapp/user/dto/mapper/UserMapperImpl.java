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
        return new UserDTO(user.getId(), user.getEmail(), user.getName());
    }

    @Override
    public User toEntity(UserCreateDTO dto) {
        if (dto == null) return null;
        User user = new User();
        user.setEmail(dto.email());
        user.setName(dto.name());
        return user;
    }

    @Override
    public List<UserDTO> toDTOList(List<User> users) {
        if (users == null) return null;
        return users.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public void updateEntity(User user, UserUpdateDTO dto) {
        if (user == null || dto == null) return;
        dto.email().ifPresent(user::setEmail);
        dto.name().ifPresent(user::setName);
    }
}