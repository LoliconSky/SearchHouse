package com.bfchengnuo.searchhouse.repository;

import com.bfchengnuo.searchhouse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 冰封承諾Andy on 2019/3/30.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
