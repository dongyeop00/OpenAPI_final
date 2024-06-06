package com.dongyeop.dbp_api.DTO;

import com.dongyeop.dbp_api.Entity.UserCheckboxValueEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserCheckboxValueDTO {
    private Long id;
    private String value;
    private Long userId;
}
