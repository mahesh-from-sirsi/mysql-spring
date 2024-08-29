package com.mvs.user_manangement_mysql_db.repository;

import com.mvs.user_manangement_mysql_db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
