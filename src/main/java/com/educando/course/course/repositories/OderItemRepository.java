package com.educando.course.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educando.course.course.model.OrderItem;

public interface OderItemRepository extends JpaRepository<OrderItem, Long>{

}