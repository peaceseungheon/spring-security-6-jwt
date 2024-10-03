package kr.co.sh.tour_taste.entity.users.repository;

import static org.junit.jupiter.api.Assertions.*;

import kr.co.sh.tour_taste.entity.users.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void fetchUser(){
        // given
        String email = "test@test.com";
        String password = "1234";

        // when
        User user = userRepository.findByEmailAndPassword(email, password);

        //then
        Assertions.assertEquals(email, user.getEmail());
    }

}