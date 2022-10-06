package com.example.groject.domain.user.domain.repository;

import com.example.groject.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByNumber(String number);
}
