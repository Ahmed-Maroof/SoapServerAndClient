package com.concretepage.repository;


import com.concretepage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    @Transactional
    @Modifying
    @Query("update User u set u.balance = ?1 where u.id = ?2")
    void updateUserBalanceById(Long newBalance, Long billId  );
}