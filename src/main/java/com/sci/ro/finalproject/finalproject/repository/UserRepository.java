package com.sci.ro.finalproject.finalproject.repository;


import com.sci.ro.finalproject.finalproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Users} instances. Provides basic CRUD operations due to the extension *of {@link JpaRepository}.
 *
 */

public interface UserRepository extends JpaRepository<Users, Long> {

    /**
     * This method searches the user's database by username and to check that there is no duplicate.
     * @param username the name chosen by the user
     * @return the attributes of username
     */
    Users findByUsername(String username);
}