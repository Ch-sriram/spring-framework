package com.sriram.lil.landon_hotel.data.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="reservations")
@Data
@ToString
public class Reservation {
	@Id
	@Column(name="reservation_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="room_id", nullable=false)
	private long roomId;

	@Column(name="guest_id", nullable=false)
	private long guestId;

	@Column(name="res_date")
	private Date reservationDate;
}
