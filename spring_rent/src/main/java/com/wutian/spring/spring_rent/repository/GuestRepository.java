package com.wutian.spring.spring_rent.repository;

import com.wutian.spring.spring_rent.entity.Guest;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {}