package com.educando.course.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educando.course.course.model.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
