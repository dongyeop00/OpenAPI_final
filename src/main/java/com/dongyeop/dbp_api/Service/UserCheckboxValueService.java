package com.dongyeop.dbp_api.Service;

import com.dongyeop.dbp_api.Entity.UserCheckboxValueEntity;
import com.dongyeop.dbp_api.Repository.User.UserCheckboxValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
