package com.dongyeop.dbp_api.Service.User;

import com.dongyeop.dbp_api.Entity.User.UserCheckboxValueEntity;
import com.dongyeop.dbp_api.Repository.User.UserCheckboxValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCheckboxValueService {
    private final UserCheckboxValueRepository userCheckboxValueRepository;

    public String[] findCheckboxValuesByUserId(Long userId) {
        List<UserCheckboxValueEntity> entities = userCheckboxValueRepository.findByUserId(userId);
        return entities.stream()
                .map(UserCheckboxValueEntity::getValue)
                .toArray(String[]::new);
    }


}
