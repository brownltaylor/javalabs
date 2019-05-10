package com.brown.userinfo.repository;
import com.brown.userinfo.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<UserInfo, Long> {
}
