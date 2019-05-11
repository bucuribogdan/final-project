package com.sci.ro.finalproject.finalproject.repository;

import com.sci.ro.finalproject.finalproject.model.User;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<User, Integer> {
}
