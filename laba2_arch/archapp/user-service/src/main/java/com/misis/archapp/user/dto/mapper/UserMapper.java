package com.misis.archapp.user.dto.mapper;

import com.misis.archapp.user.db.User;
import com.misis.archapp.user.dto.UserCreateDTO;
import com.misis.archapp.user.dto.UserDTO;
import com.misis.archapp.user.dto.UserUpdateDTO;
import java.util.List;

public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserCreateDTO dto);
    List<UserDTO> toDTOList(List<User> users);
    void updateUserFromDTO(UserUpdateDTO dto, User user);
}