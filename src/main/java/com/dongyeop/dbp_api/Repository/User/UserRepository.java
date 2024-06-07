package com.dongyeop.dbp_api.Repository.User;

import com.dongyeop.dbp_api.Entity.User.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserEmail(String userEmail);
}
