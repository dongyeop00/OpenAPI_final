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

    private String userName;
    private String userNickname;
    private String userEmail;
    private String userPassword;
    private String userGender;
    private List<String> selectedValues;

    public static UserLoginDTO toUserDTO(UserEntity userEntity) {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setUserEmail(userEntity.getUserEmail());
        userLoginDTO.setUserPassword(userEntity.getUserPassword());
        userLoginDTO.setUserNickname(userEntity.getUserNickname());
        return userLoginDTO;
    }
}
