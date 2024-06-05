package com.dongyeop.dbp_api.Repository.User;

import com.dongyeop.dbp_api.Entity.UserCheckboxValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCheckboxValueRepository extends JpaRepository<UserCheckboxValueEntity, Long> {
}
