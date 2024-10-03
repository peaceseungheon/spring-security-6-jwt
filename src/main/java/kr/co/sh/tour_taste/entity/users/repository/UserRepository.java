package kr.co.sh.tour_taste.entity.users.repository;

import java.util.Optional;
import kr.co.sh.tour_taste.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    User findByEmailAndPassword(String email, String password);

}
