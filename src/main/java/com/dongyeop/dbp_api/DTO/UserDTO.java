package com.dongyeop.dbp_api.DTO;

import com.dongyeop.dbp_api.Entity.UserEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserDTO {

    private Long id;
    private String userName;
    private String userNickname;
    private String userEmail;
    private String userPassword;
    private String userGender;
    private List<String> selectedValues;

    public static UserLoginDTO toUserLoginDTO(UserEntity userEntity) {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setId(userEntity.getId());
        userLoginDTO.setUserEmail(userEntity.getUserEmail());
        userLoginDTO.setUserPassword(userEntity.getUserPassword());
        userLoginDTO.setUserNickname(userEntity.getUserNickname());
        return userLoginDTO;
    }

    public static UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setUserNickname(userEntity.getUserNickname());
        userDTO.setUserEmail(userEntity.getUserEmail());
        userDTO.setUserPassword(userEntity.getUserPassword());
        userDTO.setUserGender(userEntity.getUserGender());
        return userDTO;
    }
}
