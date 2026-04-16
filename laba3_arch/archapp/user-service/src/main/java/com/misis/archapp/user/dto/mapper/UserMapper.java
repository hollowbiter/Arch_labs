package com.misis.archapp.user.dto.mapper;

import com.misis.archapp.user.db.User;
import com.misis.archapp.user.dto.UserCreateDTO;
import com.misis.archapp.user.dto.UserDTO;
import com.misis.archapp.user.dto.UserUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserCreateDTO dto);
    List<UserDTO> toDTOList(List<User> users);
    void updateEntity(@MappingTarget User user, UserUpdateDTO dto);
}