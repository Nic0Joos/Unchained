package com.unchained.Unchained.Data.Repository;

import com.unchained.Unchained.Data.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Author: Alex
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
