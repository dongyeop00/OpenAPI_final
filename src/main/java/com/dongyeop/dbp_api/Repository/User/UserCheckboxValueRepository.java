package com.dongyeop.dbp_api.Repository.User;

import com.dongyeop.dbp_api.Entity.User.UserCheckboxValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCheckboxValueRepository extends JpaRepository<UserCheckboxValueEntity, Long> {
    List<UserCheckboxValueEntity> findByUserId(Long userId);
}
