package kr.co.sh.spring_security6_jwt.entity.users.repository;

import kr.co.sh.spring_security6_jwt.entity.users.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
