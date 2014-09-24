package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import pl.java.scalatech.domain.User;

public interface UserRepository extends JpaRepository<User,Long>, QueryDslPredicateExecutor<User>{

}
