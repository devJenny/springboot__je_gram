package org.example.photogram_re.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

// 애노테이션이 없어도 JpaRepository를 상속하면 IoC 등록이 자동으로 됨
public interface UserRepository extends JpaRepository<User, Long> {

}
