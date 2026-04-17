package com.sriram.lil.landon_hotel.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="rooms") // the table is named as "rooms", and the class is named as "Room", since the table contains all rooms, and the class serves a Room object.
@Data // Getter and Setter access for the data in this entity, defined by Lombok
@ToString // Convenience by lombok
public class Room {

	@Id
	@Column(name="room_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="room_number")
	private String roomNumber;

	@Column(name="bed_info")
	private String bedInfo;
}
