package com.sriram.lil.landon_hotel.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sriram.lil.landon_hotel.data.entity.Room;

/**
 * The Room Repository extends the JPA Repository,
 * to which the Entity type, and the PK's ({@link Room}'s {@code id} variable's) type is sent.
 *
 * @author chandrabhatta.sriram
 */
public interface RoomRepository extends JpaRepository<Room, Long> {

	/**
	 * This declaration itself is good enough for using this repository's
	 * method, which is this method, to find the room, by room number.
	 * @param roomNumber
	 * @return
	 */
	Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);
	
	/**
	 * From the entity {@link Room} itself, imagine what other methods can
	 * be created.
	 * 
	 * Some questions to ask:
	 * 1. How would you get all rooms with 2 queen size beds? OR
	 * 2. All the rooms of a certain name?
	 * 
	 * This would give us a way on how to create these methods, and they
	 * internally, dynamically [automatically] create the required
	 * query, w/o your intervention. This is really powerful.
	 */
}
