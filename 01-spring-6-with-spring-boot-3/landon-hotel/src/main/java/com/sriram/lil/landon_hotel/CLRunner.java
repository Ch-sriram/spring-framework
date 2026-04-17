package com.sriram.lil.landon_hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sriram.lil.landon_hotel.data.entity.Room;
import com.sriram.lil.landon_hotel.data.repository.RoomRepository;

@Component
public class CLRunner implements CommandLineRunner {

	private final RoomRepository roomRepository;

	/**
	 * This does an injection from the Spring's IoC container,
	 * and that means that Spring would need to have the
	 * {@link RoomRepository} object configured in it's IoC container.
	 * @param roomRepository
	 */
	public CLRunner(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	/**
	 * Check the Room related data in {@link data.sql}
	 */
	@Override
	public void run(String... args) throws Exception {
		List<Room> rooms = roomRepository.findAll();
		
		// Since it's ignore case, make use of "p1", instead of "P1", since the table values of room number are all capital.
		Optional<Room> room = roomRepository.findByRoomNumberIgnoreCase("p1");

		System.out.println(room);

		rooms.forEach(System.out::println);
	}
	
	/**
	 * O/P:
	 * 
	 * Optional[Room(id=1, name=Piccadilly, roomNumber=P1, bedInfo=1Q)]
     * Room(id=1, name=Piccadilly, roomNumber=P1, bedInfo=1Q)
     * Room(id=2, name=Piccadilly, roomNumber=P2, bedInfo=1Q)
     * Room(id=3, name=Piccadilly, roomNumber=P3, bedInfo=1Q)
     * Room(id=4, name=Piccadilly, roomNumber=P4, bedInfo=2D)
     * Room(id=5, name=Piccadilly, roomNumber=P5, bedInfo=2D)
     * Room(id=6, name=Piccadilly, roomNumber=P6, bedInfo=2D)
     * Room(id=7, name=Cambridge, roomNumber=C1, bedInfo=1K)
     * Room(id=8, name=Cambridge, roomNumber=C2, bedInfo=1K)
     * Room(id=9, name=Cambridge, roomNumber=C3, bedInfo=1K)
     * Room(id=10, name=Westminster, roomNumber=W1, bedInfo=1K)
     * Room(id=11, name=Westminster, roomNumber=W2, bedInfo=1K)
     * Room(id=12, name=Westminster, roomNumber=W3, bedInfo=1K)
     * Room(id=13, name=Westminster, roomNumber=W4, bedInfo=1K)
     * Room(id=14, name=Westminster, roomNumber=W5, bedInfo=2D)
     * Room(id=15, name=Westminster, roomNumber=W6, bedInfo=2D)
     * Room(id=16, name=Westminster, roomNumber=W7, bedInfo=2D)
     * Room(id=17, name=Oxford, roomNumber=O1, bedInfo=1K)
     * Room(id=18, name=Oxford, roomNumber=O2, bedInfo=1K)
     * Room(id=19, name=Oxford, roomNumber=O3, bedInfo=1Q)
     * Room(id=20, name=Oxford, roomNumber=O4, bedInfo=1Q)
     * Room(id=21, name=Oxford, roomNumber=O5, bedInfo=1Q)
     * Room(id=22, name=Victoria, roomNumber=V1, bedInfo=1K)
     * Room(id=23, name=Victoria, roomNumber=V2, bedInfo=2D)
     * Room(id=24, name=Victoria, roomNumber=V3, bedInfo=2D)
     * Room(id=25, name=Manchester, roomNumber=M1, bedInfo=1K)
     * Room(id=26, name=Manchester, roomNumber=M2, bedInfo=1K)
     * Room(id=27, name=Manchester, roomNumber=M3, bedInfo=1K)
     * Room(id=28, name=Manchester, roomNumber=M4, bedInfo=1K)
	 */

}
