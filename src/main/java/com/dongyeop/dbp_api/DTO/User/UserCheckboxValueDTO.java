package com.dongyeop.dbp_api.DTO.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserCheckboxValueDTO {
    private Long id;
    private String value;
    private Long userId;
}
