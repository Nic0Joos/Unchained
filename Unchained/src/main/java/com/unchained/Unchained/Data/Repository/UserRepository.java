package com.unchained.Unchained.Data.Repository;

import com.unchained.Unchained.Data.Domain.UnchainedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Author: Alex Herzog
@Repository
public interface UserRepository extends JpaRepository<UnchainedUser, Long> {

    UnchainedUser findByEmail(String email);
}
