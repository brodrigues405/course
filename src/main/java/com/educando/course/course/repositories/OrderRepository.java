package com.educando.course.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educando.course.course.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
