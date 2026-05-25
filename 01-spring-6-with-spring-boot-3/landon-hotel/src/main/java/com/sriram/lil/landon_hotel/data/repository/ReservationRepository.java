package com.sriram.lil.landon_hotel.data.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sriram.lil.landon_hotel.data.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findAllByReservationDate(Date reservationDate);
}
