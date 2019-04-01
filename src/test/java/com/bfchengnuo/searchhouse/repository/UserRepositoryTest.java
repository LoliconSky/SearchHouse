package com.bfchengnuo.searchhouse.repository;

import com.bfchengnuo.searchhouse.SearchHouseApplicationTests;
import com.bfchengnuo.searchhouse.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * Created by 冰封承諾Andy on 2019/3/30.
 */
public class UserRepositoryTest extends SearchHouseApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne() {
        Optional<User> user = userRepository.findById(1L);
        Assert.assertEquals("loli", user.get().getName());
    }
}
