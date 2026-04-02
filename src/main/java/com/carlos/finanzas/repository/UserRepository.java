package com.carlos.finanzas.repository;

import com.carlos.finanzas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
