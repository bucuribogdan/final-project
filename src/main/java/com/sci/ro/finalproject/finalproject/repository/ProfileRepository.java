package com.sci.ro.finalproject.finalproject.repository;

import com.sci.ro.finalproject.finalproject.model.Trip;
import com.sci.ro.finalproject.finalproject.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Users, Long> {
}
