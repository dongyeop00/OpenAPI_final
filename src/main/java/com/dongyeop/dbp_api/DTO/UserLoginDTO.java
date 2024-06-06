package com.dongyeop.dbp_api.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserLoginDTO {
    private Long id;
    private String userEmail;
    private String userPassword;
    private String userNickname;
}
