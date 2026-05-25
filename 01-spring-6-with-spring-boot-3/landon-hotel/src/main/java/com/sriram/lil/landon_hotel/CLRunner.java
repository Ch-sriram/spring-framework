package com.sriram.lil.landon_hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sriram.lil.landon_hotel.data.entity.Guest;
import com.sriram.lil.landon_hotel.data.entity.Reservation;
import com.sriram.lil.landon_hotel.data.entity.Room;
import com.sriram.lil.landon_hotel.data.repository.GuestRepository;
import com.sriram.lil.landon_hotel.data.repository.ReservationRepository;
import com.sriram.lil.landon_hotel.data.repository.RoomRepository;
import com.sriram.lil.landon_hotel.service.RoomReservationService;
import com.sriram.lil.landon_hotel.service.model.RoomReservation;


@Component
public class CLRunner implements CommandLineRunner {

	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;
	private final RoomReservationService roomReservationService;

	/**
	 * This does an injection from the Spring's IoC container,
	 * and that means that Spring would need to have the
	 * {@link RoomRepository} object configured in it's IoC container.
	 * @param roomRepository
	 */
	public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository, RoomReservationService roomReservationService) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
		this.roomReservationService = roomReservationService;
	}

	/**
	 * Command Line Runner: Runs when the application starts!
	 */
	@Override
	public void run(String... args) throws Exception {
//		// Since it's ignore case, make use of "p1", instead of "P1", since the table values of room number are all capital.
//		Optional<Room> room = roomRepository.findByRoomNumberIgnoreCase("p1");
//		System.out.println(room);
//
//		System.out.println("*************ROOMS**************");
//		List<Room> rooms = roomRepository.findAll();
//		rooms.forEach(System.out::println);
//
//		System.out.println("*************GUESTS**************");
//		List<Guest> guests = guestRepository.findAll();
//		guests.forEach(System.out::println);
//
//		System.out.println("*************RESERVATIONS**************");
//		List<Reservation> reservations = reservationRepository.findAll();
//		reservations.forEach(System.out::println);
		List<RoomReservation> reservations = roomReservationService.getRoomReservationForDate("2023-08-28");
		reservations.forEach(System.out::println);
	}

}
