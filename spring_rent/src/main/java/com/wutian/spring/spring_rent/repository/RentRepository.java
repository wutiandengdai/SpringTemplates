package com.wutian.spring.spring_rent.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

import com.wutian.spring.spring_rent.entity.Rent;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {
    List<Rent> findByDate(Date date);
}