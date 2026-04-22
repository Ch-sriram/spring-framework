package com.sriram.lil.landon_hotel.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sriram.lil.landon_hotel.data.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
