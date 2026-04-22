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

@Component
public class CLRunner implements CommandLineRunner {

	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;

	/**
	 * This does an injection from the Spring's IoC container,
	 * and that means that Spring would need to have the
	 * {@link RoomRepository} object configured in it's IoC container.
	 * @param roomRepository
	 */
	public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}

	/**
	 * Command Line Runner: Runs when the application starts!
	 */
	@Override
	public void run(String... args) throws Exception {
		// Since it's ignore case, make use of "p1", instead of "P1", since the table values of room number are all capital.
		Optional<Room> room = roomRepository.findByRoomNumberIgnoreCase("p1");
		System.out.println(room);

		System.out.println("*************ROOMS**************");
		List<Room> rooms = roomRepository.findAll();
		rooms.forEach(System.out::println);

		System.out.println("*************GUESTS**************");
		List<Guest> guests = guestRepository.findAll();
		guests.forEach(System.out::println);

		System.out.println("*************RESERVATIONS**************");
		List<Reservation> reservations = reservationRepository.findAll();
		reservations.forEach(System.out::println);
	}

  /**
   * O/P:
   * 
   * Optional[Room(id=1, name=Piccadilly, roomNumber=P1, bedInfo=1Q)]
   * *************ROOMS**************
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
   * *************GUESTS**************
   * Guest(id=1, firstName=Roy, lastName=Adams, email=radams1v@xinhuanet.com, address=2872 Marquette Street, country=United States, state=NY, phoneNumber=1-(235)314-9823)
   * Guest(id=2, firstName=Martin, lastName=Adams, email=madams2b@msu.edu, address=4 Mandrake Plaza, country=China, state=, phoneNumber=9-(401)660-9813)
   * Guest(id=3, firstName=Roger, lastName=Alvarez, email=ralvarezk@blogs.com, address=3 Green Plaza, country=United States, state=FL, phoneNumber=6-(980)036-6105)
   * Guest(id=4, firstName=Anne, lastName=Alvarez, email=aalvarez1y@mlb.com, address=6 Glendale Parkway, country=United States, state=FL, phoneNumber=7-(967)349-7237)
   * Guest(id=5, firstName=Ann, lastName=Alvarez, email=aalvarez20@jalbum.net, address=851 Nelson Circle, country=Afghanistan, state=, phoneNumber=7-(418)731-2327)
   * Guest(id=6, firstName=Betty, lastName=Anderson, email=banderson14@digg.com, address=3538 Scofield Drive, country=United States, state=TX, phoneNumber=1-(291)830-0405)
   * Guest(id=7, firstName=Laura, lastName=Anderson, email=landerson24@icio.us, address=805 Paget Court, country=United States, state=NY, phoneNumber=3-(587)240-6409)
   * Guest(id=8, firstName=Christopher, lastName=Armstrong, email=carmstrong2p@cyberchimps.com, address=4514 Independence Point, country=United States, state=TX, phoneNumber=3-(411)160-3757)
   * Guest(id=9, firstName=David, lastName=Bell, email=dbell2l@wp.com, address=5205 Vera Junction, country=United States, state=CA, phoneNumber=8-(035)412-4547)
   * Guest(id=10, firstName=Paula, lastName=Berry, email=pberry1z@admin.ch, address=5095 International Drive, country=China, state=, phoneNumber=6-(195)796-7745)
   * Guest(id=11, firstName=Dennis, lastName=Bishop, email=dbishopo@xinhuanet.com, address=11442 East Circle, country=Armenia, state=, phoneNumber=4-(871)489-3543)
   * Guest(id=12, firstName=Carolyn, lastName=Bishop, email=cbishopw@1688.com, address=23273 Emmet Road, country=Ukraine, state=, phoneNumber=5-(795)729-5690)
   * Guest(id=13, firstName=Harold, lastName=Black, email=hblack2p@clickbank.net, address=7715 Havey Center, country=Indonesia, state=, phoneNumber=0-(378)142-3343)
   * Guest(id=14, firstName=Jerry, lastName=Bowman, email=jbowman1j@fotki.com, address=49381 Northridge Point, country=Indonesia, state=, phoneNumber=9-(389)678-8585)
   * Guest(id=15, firstName=Keith, lastName=Bradley, email=kbradley1c@techcrunch.com, address=21 Sauthoff Point, country=United States, state=OH, phoneNumber=5-(780)609-5353)
   * Guest(id=16, firstName=Samuel, lastName=Brooks, email=sbrooks4@google.co.uk, address=9857 Hollow Ridge Park, country=United States, state=PA, phoneNumber=5-(517)250-0437)
   * Guest(id=17, firstName=Donald, lastName=Bryant, email=dbryant1@cdbaby.com, address=8 Crescent Oaks Circle, country=South Korea, state=, phoneNumber=5-(629)251-0019)
   * Guest(id=18, firstName=Tammy, lastName=Burke, email=tburke2a@theglobeandmail.com, address=7298 Bluejay Road, country=Russia, state=, phoneNumber=8-(710)063-1619)
   * Guest(id=19, firstName=Joe, lastName=Burns, email=jburns18@mail.ru, address=2795 Lighthouse Bay Place, country=Russia, state=, phoneNumber=3-(465)132-7455)
   * Guest(id=20, firstName=Jessica, lastName=Campbell, email=jcampbell2i@cpanel.net, address=7963 Ohio Alley, country=United States, state=OR, phoneNumber=0-(150)386-2177)
   * Guest(id=21, firstName=Christopher, lastName=Campbell, email=ccampbell2i@amazon.de, address=6 Walton Court, country=Russia, state=, phoneNumber=5-(275)117-4811)
   * Guest(id=22, firstName=Pamela, lastName=Carpenter, email=pcarpenterj@china.com.cn, address=661 Karstens Road, country=United States, state=HI, phoneNumber=6-(268)816-2465)
   * Guest(id=23, firstName=Paul, lastName=Carpenter, email=pcarpenter28@dropbox.com, address=33614 Cambridge Road, country=Philippines, state=, phoneNumber=3-(561)990-7094)
   * Guest(id=24, firstName=Tammy, lastName=Carter, email=tcarter1j@washington.edu, address=3 Leroy Crossing, country=United States, state=TN, phoneNumber=7-(489)865-7002)
   * Guest(id=25, firstName=Paul, lastName=Carter, email=pcarter1z@cnet.com, address=3 Green Plaza, country=United States, state=CA, phoneNumber=3-(854)158-1783)
   * Guest(id=26, firstName=Justin, lastName=Chapman, email=jchapmans@aol.com, address=2127 David Lane, country=United States, state=WV, phoneNumber=1-(910)152-0295)
   * Guest(id=27, firstName=Margaret, lastName=Chapman, email=mchapmanb@hud.gov, address=953 Reindahl Parkway, country=Canada, state=, phoneNumber=1-(010)495-9996)
   * Guest(id=28, firstName=Bonnie, lastName=Clark, email=bclark6@bing.com, address=4 Porter Avenue, country=United States, state=CO, phoneNumber=9-(524)812-6248)
   * Guest(id=29, firstName=Andrea, lastName=Clark, email=aclark2j@sphinn.com, address=02 Haas Park, country=United States, state=MI, phoneNumber=1-(123)323-9494)
   * Guest(id=30, firstName=Shirley, lastName=Coleman, email=scoleman26@bizjournals.com, address=4903 Commercial Drive, country=United States, state=AL, phoneNumber=7-(798)598-1459)
   * Guest(id=31, firstName=Angela, lastName=Coleman, email=acoleman6@gmpg.org, address=1208 Menomonie Terrace, country=Russia, state=, phoneNumber=9-(959)063-5551)
   * Guest(id=32, firstName=Harold, lastName=Cox, email=hcox23@dyndns.org, address=08 Butterfield Place, country=France, state=B5, phoneNumber=6-(983)957-3202)
   * Guest(id=33, firstName=Alan, lastName=Cruz, email=acruzj@marketwatch.com, address=023 Laurel Terrace, country=China, state=, phoneNumber=1-(003)990-0308)
   * Guest(id=34, firstName=Anna, lastName=Cunningham, email=acunningham2@yale.edu, address=1 Steensland Lane, country=China, state=, phoneNumber=7-(769)474-5961)
   * Guest(id=35, firstName=Robin, lastName=Daniels, email=rdaniels2d@weebly.com, address=9728 Paget Court, country=United States, state=AR, phoneNumber=7-(116)447-5902)
   * Guest(id=36, firstName=Phillip, lastName=Daniels, email=pdaniels1y@hexun.com, address=5 Blue Bill Park Trail, country=Kazakhstan, state=, phoneNumber=4-(029)713-9304)
   * Guest(id=37, firstName=Thomas, lastName=Davis, email=tdavis1h@globo.com, address=6332 Fuller Pass, country=United States, state=TX, phoneNumber=5-(778)054-9695)
   * Guest(id=38, firstName=Joe, lastName=Dean, email=jdeanp@vinaora.com, address=8 Darwin Crossing, country=United States, state=AZ, phoneNumber=9-(625)975-9705)
   * Guest(id=39, firstName=Sara, lastName=Dean, email=sdean1t@unc.edu, address=9 South Crossing, country=Mexico, state=GUA, phoneNumber=7-(206)725-7117)
   * Guest(id=40, firstName=Patricia, lastName=Dixon, email=pdixon2m@biglobe.ne.jp, address=49 Moose Way, country=United States, state=DC, phoneNumber=1-(159)384-4102)
   * Guest(id=41, firstName=Cynthia, lastName=Dixon, email=cdixon1e@vimeo.com, address=52645 Dorton Pass, country=China, state=, phoneNumber=6-(422)372-7084)
   * Guest(id=42, firstName=Todd, lastName=Dixon, email=tdixon2o@ed.gov, address=82172 Lukken Alley, country=China, state=, phoneNumber=0-(290)722-9657)
   * Guest(id=43, firstName=David, lastName=Elliott, email=delliottn@wsj.com, address=6478 Doe Crossing Court, country=Russia, state=, phoneNumber=4-(687)980-5138)
   * Guest(id=44, firstName=Gregory, lastName=Elliott, email=gelliott2f@exblog.jp, address=01298 Raven Alley, country=Indonesia, state=, phoneNumber=2-(826)961-5278)
   * Guest(id=45, firstName=James, lastName=Ellis, email=jellisa@wordpress.com, address=8108 Upham Avenue, country=United States, state=CA, phoneNumber=9-(104)768-0365)
   * Guest(id=46, firstName=Russell, lastName=Ferguson, email=rferguson1b@uol.com.br, address=9143 Hudson Terrace, country=United States, state=OH, phoneNumber=7-(498)208-8970)
   * Guest(id=47, firstName=Mark, lastName=Ferguson, email=mferguson2m@columbia.edu, address=6 Fisk Drive, country=Poland, state=, phoneNumber=7-(920)445-0162)
   * Guest(id=48, firstName=Lori, lastName=Fields, email=lfieldsq@smh.com.au, address=76485 Roth Alley, country=United States, state=WA, phoneNumber=2-(229)182-4243)
   * Guest(id=49, firstName=Thomas, lastName=Fisher, email=tfisher26@sina.com.cn, address=8 Haas Avenue, country=Uzbekistan, state=, phoneNumber=1-(842)637-0935)
   * Guest(id=50, firstName=Matthew, lastName=Ford, email=mfordi@ucoz.com, address=63 East Place, country=Syria, state=, phoneNumber=5-(508)161-9676)
   * Guest(id=51, firstName=Clarence, lastName=Fowler, email=cfowler1t@unicef.org, address=890 Nevada Road, country=United States, state=CT, phoneNumber=5-(922)750-2234)
   * Guest(id=52, firstName=Steve, lastName=Fowler, email=sfowler2f@ed.gov, address=243 Ohio Plaza, country=United States, state=AL, phoneNumber=8-(435)340-9290)
   * Guest(id=53, firstName=Craig, lastName=Fox, email=cfox1v@sakura.ne.jp, address=576 Novick Alley, country=Philippines, state=, phoneNumber=3-(453)987-1524)
   * Guest(id=54, firstName=Kimberly, lastName=Freeman, email=kfreemank@cmu.edu, address=46613 Buena Vista Pass, country=Australia, state=NSW, phoneNumber=0-(289)984-9766)
   * Guest(id=55, firstName=Johnny, lastName=Freeman, email=jfreeman1g@aboutads.info, address=719 Trailsway Street, country=China, state=, phoneNumber=6-(658)139-7764)
   * Guest(id=56, firstName=Carl, lastName=Garza, email=cgarzal@friendfeed.com, address=92 Scott Court, country=United States, state=DC, phoneNumber=2-(818)774-1651)
   * Guest(id=57, firstName=Martha, lastName=Garza, email=mgarza29@fastcompany.com, address=64 Farwell Circle, country=Philippines, state=, phoneNumber=9-(455)359-2298)
   * Guest(id=58, firstName=Angela, lastName=George, email=ageorgew@slashdot.org, address=1 Corben Street, country=United States, state=MD, phoneNumber=5-(864)699-8310)
   * Guest(id=59, firstName=Linda, lastName=George, email=lgeorge27@mtv.com, address=5793 Northport Center, country=United States, state=MI, phoneNumber=7-(899)692-4554)
   * Guest(id=60, firstName=Rose, lastName=Gilbert, email=rgilbert1c@java.com, address=32441 Oriole Junction, country=Indonesia, state=, phoneNumber=9-(771)659-3359)
   * Guest(id=61, firstName=Jacqueline, lastName=Gomez, email=jgomeze@miitbeian.gov.cn, address=794 Armistice Crossing, country=France, state=A7, phoneNumber=9-(345)143-4371)
   * Guest(id=62, firstName=Antonio, lastName=Gordon, email=agordon28@weather.com, address=8 Maywood Parkway, country=United States, state=CA, phoneNumber=5-(724)135-8826)
   * Guest(id=63, firstName=Raymond, lastName=Grant, email=rgrant11@amazonaws.com, address=248 Scott Trail, country=China, state=, phoneNumber=0-(001)715-0415)
   * Guest(id=64, firstName=Janet, lastName=Grant, email=jgrant2c@nbcnews.com, address=07 Schurz Circle, country=Philippines, state=, phoneNumber=3-(757)166-1573)
   * Guest(id=65, firstName=Steven, lastName=Gray, email=sgray17@over-blog.com, address=4 5th Street, country=Sweden, state=AB, phoneNumber=8-(004)861-6730)
   * Guest(id=66, firstName=William, lastName=Hamilton, email=whamilton2a@biglobe.ne.jp, address=23 Ronald Regan Drive, country=United States, state=MO, phoneNumber=7-(178)515-6650)
   * Guest(id=67, firstName=Ernest, lastName=Hamilton, email=ehamilton0@51.la, address=3 Bay Park, country=Poland, state=, phoneNumber=1-(402)667-5979)
   * Guest(id=68, firstName=Jane, lastName=Hansen, email=jhansen0@xrea.com, address=8 Beilfuss Place, country=United States, state=SC, phoneNumber=8-(468)743-8087)
   * Guest(id=69, firstName=Annie, lastName=Hansen, email=ahansen7@furl.net, address=728 Fisk Plaza, country=United States, state=MD, phoneNumber=3-(527)508-7158)
   * Guest(id=70, firstName=Carolyn, lastName=Hanson, email=chanson1r@netlog.com, address=5066 Dottie Junction, country=United States, state=NY, phoneNumber=8-(597)931-5162)
   * Guest(id=71, firstName=Christopher, lastName=Hanson, email=chansonp@ftc.gov, address=50 Claremont Crossing, country=Indonesia, state=, phoneNumber=5-(759)595-6039)
   * Guest(id=72, firstName=Michael, lastName=Harris, email=mharris2g@printfriendly.com, address=43 Veith Parkway, country=United States, state=CT, phoneNumber=2-(345)753-2214)
   * Guest(id=73, firstName=Stephanie, lastName=Harrison, email=sharrison21@devhub.com, address=709 Pepper Wood Avenue, country=Poland, state=, phoneNumber=1-(280)302-4944)
   * Guest(id=74, firstName=Anne, lastName=Harvey, email=aharvey2g@sfgate.com, address=4 American Place, country=China, state=, phoneNumber=9-(535)847-7555)
   * Guest(id=75, firstName=Barbara, lastName=Hayes, email=bhayes2q@jiathis.com, address=6 Scofield Circle, country=United States, state=TX, phoneNumber=0-(173)195-7190)
   * Guest(id=76, firstName=Nicole, lastName=Hayes, email=nhayes10@qq.com, address=98830 Schlimgen Park, country=China, state=, phoneNumber=7-(755)477-0983)
   * Guest(id=77, firstName=Emily, lastName=Hayes, email=ehayes1h@ox.ac.uk, address=784 Susan Street, country=Indonesia, state=, phoneNumber=8-(944)943-0482)
   * Guest(id=78, firstName=Martin, lastName=Henderson, email=mhenderson16@wsj.com, address=7306 Buhler Plaza, country=United States, state=TX, phoneNumber=6-(058)886-9240)
   * Guest(id=79, firstName=Billy, lastName=Hernandez, email=bhernandezx@sphinn.com, address=994 Kennedy Street, country=United States, state=PA, phoneNumber=2-(728)757-6883)
   * Guest(id=80, firstName=Heather, lastName=Hernandez, email=hhernandezr@hostgator.com, address=74 Clove Drive, country=Indonesia, state=, phoneNumber=5-(593)151-3362)
   * Guest(id=81, firstName=Sharon, lastName=Hicks, email=shicks3@wsj.com, address=0974 Calypso Junction, country=Indonesia, state=, phoneNumber=3-(868)311-6209)
   * Guest(id=82, firstName=Lori, lastName=Hicks, email=lhicks9@wordpress.org, address=854 Lakewood Gardens Court, country=China, state=, phoneNumber=9-(849)992-9828)
   * Guest(id=83, firstName=Richard, lastName=Howard, email=rhoward1i@theatlantic.com, address=6 Welch Pass, country=United States, state=CA, phoneNumber=5-(673)015-8549)
   * Guest(id=84, firstName=Ronald, lastName=Howell, email=rhowell13@soup.io, address=75904 Hoffman Way, country=Japan, state=, phoneNumber=3-(124)276-4530)
   * Guest(id=85, firstName=Judy, lastName=Hughes, email=jhughes25@4shared.com, address=03 Sullivan Circle, country=United States, state=DE, phoneNumber=4-(702)002-3923)
   * Guest(id=86, firstName=Amy, lastName=Hunter, email=ahuntere@intel.com, address=9781 Kennedy Avenue, country=United States, state=WV, phoneNumber=0-(992)102-4834)
   * Guest(id=87, firstName=Kathryn, lastName=Jackson, email=kjackson3@wikia.com, address=43603 Northwestern Plaza, country=United States, state=MS, phoneNumber=9-(266)577-1031)
   * Guest(id=88, firstName=Steven, lastName=Jenkins, email=sjenkins1e@a8.net, address=7396 Canary Center, country=United States, state=CA, phoneNumber=3-(613)563-6513)
   * Guest(id=89, firstName=Kevin, lastName=Johnson, email=kjohnson2h@unesco.org, address=5 Haas Circle, country=Poland, state=, phoneNumber=8-(553)359-6387)
   * Guest(id=90, firstName=Christina, lastName=Johnston, email=cjohnston1m@nationalgeographic.com, address=05059 Fordem Lane, country=Gabon, state=, phoneNumber=7-(543)809-5071)
   * Guest(id=91, firstName=Ryan, lastName=Johnston, email=rjohnston1s@ucla.edu, address=4 Sunfield Avenue, country=Russia, state=, phoneNumber=3-(807)624-4323)
   * Guest(id=92, firstName=Marie, lastName=Jordan, email=mjordan1n@weather.com, address=5 Moulton Avenue, country=United States, state=GA, phoneNumber=9-(380)848-6527)
   * Guest(id=93, firstName=Pamela, lastName=Kelley, email=pkelley2c@hibu.com, address=97636 5th Pass, country=United States, state=KS, phoneNumber=0-(546)670-0937)
   * Guest(id=94, firstName=Evelyn, lastName=Kelly, email=ekelly2h@facebook.com, address=82091 Leroy Center, country=United States, state=KY, phoneNumber=5-(319)309-1959)
   * Guest(id=95, firstName=Dorothy, lastName=Kennedy, email=dkennedy23@unblog.fr, address=01 Park Meadow Place, country=United States, state=TX, phoneNumber=0-(605)308-6131)
   * Guest(id=96, firstName=Sean, lastName=King, email=skingl@geocities.jp, address=6611 Spaight Street, country=Indonesia, state=, phoneNumber=5-(463)415-7449)
   * Guest(id=97, firstName=Kimberly, lastName=King, email=kking1r@naver.com, address=7 Northfield Avenue, country=Nigeria, state=, phoneNumber=4-(192)264-2329)
   * Guest(id=98, firstName=Nicholas, lastName=King, email=nking2r@businessweek.com, address=3 Gulseth Drive, country=Philippines, state=, phoneNumber=4-(647)544-4105)
   * Guest(id=99, firstName=Katherine, lastName=Knight, email=kknight1p@walmart.com, address=3 Surrey Circle, country=United States, state=LA, phoneNumber=6-(906)910-4569)
   * Guest(id=100, firstName=Martin, lastName=Larson, email=mlarson24@tripadvisor.com, address=32 Surrey Road, country=United States, state=NC, phoneNumber=8-(568)965-0021)
   * Guest(id=101, firstName=Louis, lastName=Lee, email=lleeh@yellowbook.com, address=80 Boyd Court, country=United States, state=NJ, phoneNumber=3-(100)131-3147)
   * Guest(id=102, firstName=Ruby, lastName=Lewis, email=rlewisv@answers.com, address=37 Saint Paul Place, country=United States, state=IA, phoneNumber=1-(585)331-1972)
   * Guest(id=103, firstName=Jonathan, lastName=Lewis, email=jlewis4@tuttocitta.it, address=1771 Cascade Place, country=Mauritania, state=, phoneNumber=2-(107)787-5478)
   * Guest(id=104, firstName=Eric, lastName=Little, email=elittle18@cdc.gov, address=1008 6th Street, country=United States, state=FL, phoneNumber=9-(855)524-1969)
   * Guest(id=105, firstName=Kathy, lastName=Little, email=klittlec@slideshare.net, address=033 Victoria Circle, country=China, state=, phoneNumber=9-(104)402-8499)
   * Guest(id=106, firstName=Frank, lastName=Martin, email=fmartin1a@ed.gov, address=21822 Talisman Drive, country=United States, state=TX, phoneNumber=1-(296)887-1815)
   * Guest(id=107, firstName=Roy, lastName=Martin, email=rmarting@delicious.com, address=789 Scoville Plaza, country=Bolivia, state=, phoneNumber=8-(330)043-5619)
   * Guest(id=108, firstName=Randy, lastName=Martinez, email=rmartinez1q@adobe.com, address=9031 Clove Court, country=United States, state=KS, phoneNumber=6-(835)245-0202)
   * Guest(id=109, firstName=Janet, lastName=Mason, email=jmason1m@pbs.org, address=48485 Springs Lane, country=United States, state=WA, phoneNumber=0-(404)244-1973)
   * Guest(id=110, firstName=Ann, lastName=Mcdonald, email=amcdonaldu@drupal.org, address=94 Columbus Crossing, country=United States, state=IN, phoneNumber=2-(019)467-7792)
   * Guest(id=111, firstName=Kathryn, lastName=Mcdonald, email=kmcdonald5@mit.edu, address=3486 Vidon Street, country=Indonesia, state=, phoneNumber=3-(381)326-4723)
   * Guest(id=112, firstName=Lisa, lastName=Meyer, email=lmeyer2k@ycombinator.com, address=6 Mallory Circle, country=Tuvalu, state=, phoneNumber=6-(321)779-8895)
   * Guest(id=113, firstName=Pamela, lastName=Miller, email=pmiller2b@t-online.de, address=951 High Crossing Alley, country=United States, state=TX, phoneNumber=1-(377)914-2151)
   * Guest(id=114, firstName=Brandon, lastName=Miller, email=bmiller1u@prweb.com, address=3992 Sugar Circle, country=Indonesia, state=, phoneNumber=6-(106)294-1370)
   * Guest(id=115, firstName=Julia, lastName=Miller, email=jmiller2d@zdnet.com, address=551 Bartelt Crossing, country=Argentina, state=, phoneNumber=0-(666)185-0852)
   * Guest(id=116, firstName=Lois, lastName=Montgomery, email=lmontgomeryf@nba.com, address=8 Farwell Center, country=United States, state=NC, phoneNumber=8-(375)554-1933)
   * Guest(id=117, firstName=Jonathan, lastName=Morales, email=jmorales19@ed.gov, address=715 Muir Pass, country=United States, state=TX, phoneNumber=7-(721)881-1745)
   * Guest(id=118, firstName=Ronald, lastName=Moreno, email=rmorenoa@wp.com, address=6832 Dakota Drive, country=Indonesia, state=, phoneNumber=1-(452)732-4207)
   * Guest(id=119, firstName=Anne, lastName=Moreno, email=amorenox@imgur.com, address=72 Autumn Leaf Drive, country=China, state=, phoneNumber=7-(297)043-6194)
   * Guest(id=120, firstName=Martha, lastName=Moreno, email=mmoreno1a@skyrock.com, address=41 Ridgeview Pass, country=China, state=, phoneNumber=8-(179)386-6387)
   * Guest(id=121, firstName=Linda, lastName=Moreno, email=lmoreno22@odnoklassniki.ru, address=09 Mesta Street, country=Indonesia, state=, phoneNumber=6-(716)643-5063)
   * Guest(id=122, firstName=Shawn, lastName=Morgan, email=smorgany@a8.net, address=5351 Blaine Street, country=United States, state=UT, phoneNumber=9-(614)327-3110)
   * Guest(id=123, firstName=Ruby, lastName=Morgan, email=rmorgan1n@narod.ru, address=13 Arapahoe Drive, country=France, state=B2, phoneNumber=4-(056)808-7190)
   * Guest(id=124, firstName=Russell, lastName=Morris, email=rmorrist@yahoo.com, address=2 Dryden Street, country=United States, state=CA, phoneNumber=8-(312)542-5335)
   * Guest(id=125, firstName=Ernest, lastName=Morris, email=emorris17@linkedin.com, address=538 Lawn Hill, country=United States, state=NY, phoneNumber=0-(722)159-2263)
   * Guest(id=126, firstName=Frank, lastName=Morris, email=fmorris15@goo.ne.jp, address=073 Moland Avenue, country=Greece, state=, phoneNumber=3-(574)360-9298)
   * Guest(id=127, firstName=Sharon, lastName=Murphy, email=smurphy1x@exblog.jp, address=030 Tomscot Trail, country=United States, state=NC, phoneNumber=3-(392)774-3776)
   * Guest(id=128, firstName=Angela, lastName=Murray, email=amurray1f@elegantthemes.com, address=11496 Bobwhite Junction, country=United States, state=VA, phoneNumber=7-(311)742-6306)
   * Guest(id=129, firstName=Tina, lastName=Murray, email=tmurray8@admin.ch, address=63 Arapahoe Avenue, country=Brazil, state=, phoneNumber=7-(922)695-1373)
   * Guest(id=130, firstName=Judith, lastName=Murray, email=jmurray12@weather.com, address=772 Eagle Crest Court, country=China, state=, phoneNumber=5-(447)261-8375)
   * Guest(id=131, firstName=Michelle, lastName=Nguyen, email=mnguyen9@home.pl, address=76 Vidon Crossing, country=United States, state=LA, phoneNumber=3-(168)110-6625)
   * Guest(id=132, firstName=Sean, lastName=Nichols, email=snichols1d@alexa.com, address=48 Garrison Court, country=Indonesia, state=, phoneNumber=9-(909)775-6033)
   * Guest(id=133, firstName=Joyce, lastName=Owens, email=jowens1o@icq.com, address=0017 Fordem Hill, country=United States, state=CA, phoneNumber=6-(213)022-2309)
   * Guest(id=134, firstName=Alan, lastName=Owens, email=aowens16@domainmarket.com, address=9 Tomscot Place, country=Zimbabwe, state=, phoneNumber=3-(534)603-4932)
   * Guest(id=135, firstName=Rebecca, lastName=Perez, email=rperezo@sbwire.com, address=67390 Manitowish Pass, country=United States, state=TX, phoneNumber=7-(406)875-9890)
   * Guest(id=136, firstName=Marilyn, lastName=Perez, email=mperez1g@epa.gov, address=191 East Lane, country=United States, state=TN, phoneNumber=2-(678)829-2820)
   * Guest(id=137, firstName=John, lastName=Perry, email=jperry1d@xinhuanet.com, address=02184 2nd Way, country=United States, state=MD, phoneNumber=3-(362)867-6688)
   * Guest(id=138, firstName=Sharon, lastName=Perry, email=sperryd@barnesandnoble.com, address=9202 Clemons Avenue, country=China, state=, phoneNumber=3-(895)126-1278)
   * Guest(id=139, firstName=Alice, lastName=Pierce, email=apierce2r@umich.edu, address=6 Corben Trail, country=United States, state=MI, phoneNumber=0-(467)177-3734)
   * Guest(id=140, firstName=Ernest, lastName=Pierce, email=epierce1w@flavors.me, address=99 Warner Drive, country=France, state=B2, phoneNumber=7-(918)938-0007)
   * Guest(id=141, firstName=Lois, lastName=Pierce, email=lpierce2n@spotify.com, address=819 Holy Cross Drive, country=Argentina, state=, phoneNumber=4-(370)593-0211)
   * Guest(id=142, firstName=Debra, lastName=Porter, email=dporter1x@sakura.ne.jp, address=1 Haas Street, country=Indonesia, state=, phoneNumber=8-(747)340-6398)
   * Guest(id=143, firstName=Frank, lastName=Ramirez, email=framirez2k@goodreads.com, address=3 Rowland Parkway, country=United States, state=NC, phoneNumber=0-(669)037-4790)
   * Guest(id=144, firstName=Norma, lastName=Ray, email=nray1l@columbia.edu, address=8 Crescent Oaks Terrace, country=United States, state=CA, phoneNumber=3-(007)729-3299)
   * Guest(id=145, firstName=Katherine, lastName=Reid, email=kreid2@reverbnation.com, address=51 Stang Crossing, country=United States, state=CA, phoneNumber=1-(816)180-4329)
   * Guest(id=146, firstName=Phyllis, lastName=Reid, email=preids@amazon.co.uk, address=46 Rusk Parkway, country=Peru, state=, phoneNumber=8-(695)108-5308)
   * Guest(id=147, firstName=Ashley, lastName=Reid, email=areid1p@taobao.com, address=88 Village Green Center, country=United States, state=OH, phoneNumber=0-(960)491-5644)
   * Guest(id=148, firstName=Nicole, lastName=Reyes, email=nreyes5@exblog.jp, address=67524 Nobel Way, country=United States, state=AZ, phoneNumber=7-(420)898-9688)
   * Guest(id=149, firstName=Gary, lastName=Reynolds, email=greynoldsz@state.gov, address=1 Prairieview Center, country=United States, state=WA, phoneNumber=5-(337)284-9527)
   * Guest(id=150, firstName=Jessica, lastName=Richards, email=jrichards21@issuu.com, address=924 John Wall Trail, country=United States, state=ME, phoneNumber=8-(061)711-6311)
   * Guest(id=151, firstName=Patricia, lastName=Riley, email=prileyd@topsy.com, address=459 3rd Avenue, country=United States, state=GA, phoneNumber=8-(662)260-9720)
   * Guest(id=152, firstName=Cynthia, lastName=Rivera, email=crivera1i@dagondesign.com, address=257 Raven Street, country=Central African Republic, state=, phoneNumber=2-(285)744-2177)
   * Guest(id=153, firstName=Christine, lastName=Rodriguez, email=crodriguez1l@amazonaws.com, address=78026 Everett Center, country=Mauritius, state=, phoneNumber=8-(868)081-1984)
   * Guest(id=154, firstName=Kelly, lastName=Rodriguez, email=krodriguez25@china.com.cn, address=9 Beilfuss Plaza, country=Dominican Republic, state=, phoneNumber=7-(441)055-8273)
   * Guest(id=155, firstName=Frank, lastName=Rogers, email=frogers1w@statcounter.com, address=37717 Rutledge Park, country=United States, state=PA, phoneNumber=8-(685)173-5668)
   * Guest(id=156, firstName=Janet, lastName=Rogers, email=jrogers1o@ft.com, address=5 Muir Terrace, country=Argentina, state=, phoneNumber=5-(740)110-8659)
   * Guest(id=157, firstName=Sarah, lastName=Rose, email=srose1@japanpost.jp, address=3147 3rd Place, country=United States, state=CA, phoneNumber=9-(625)374-4080)
   * Guest(id=158, firstName=Scott, lastName=Rose, email=srose2o@chron.com, address=7741 Dennis Crossing, country=United States, state=IA, phoneNumber=2-(957)474-8286)
   * Guest(id=159, firstName=Paula, lastName=Ruiz, email=pruiz10@de.vu, address=0 Stone Corner Drive, country=United States, state=CA, phoneNumber=5-(733)929-8978)
   * Guest(id=160, firstName=Jerry, lastName=Russell, email=jrussellh@mtv.com, address=18 Redwing Center, country=Indonesia, state=, phoneNumber=7-(835)874-3804)
   * Guest(id=161, firstName=Patrick, lastName=Ryan, email=pryanq@bing.com, address=2456 Randy Junction, country=Portugal, state=13, phoneNumber=7-(908)548-4462)
   * Guest(id=162, firstName=Shawn, lastName=Sanchez, email=ssanchezy@utexas.edu, address=3 Butternut Point, country=Colombia, state=, phoneNumber=6-(314)041-2239)
   * Guest(id=163, firstName=Patricia, lastName=Sanders, email=psandersb@squarespace.com, address=9349 Morning Center, country=United States, state=MO, phoneNumber=1-(201)273-2884)
   * Guest(id=164, firstName=Marie, lastName=Sanders, email=msandersz@jiathis.com, address=956 Texas Terrace, country=Indonesia, state=, phoneNumber=6-(897)485-7971)
   * Guest(id=165, firstName=Frances, lastName=Sanders, email=fsanders2j@ow.ly, address=048 Mifflin Plaza, country=China, state=, phoneNumber=5-(360)904-8808)
   * Guest(id=166, firstName=Carol, lastName=Shaw, email=cshaw2e@marriott.com, address=650 Grover Alley, country=United States, state=GA, phoneNumber=6-(867)939-2196)
   * Guest(id=167, firstName=James, lastName=Simmons, email=jsimmons22@mysql.com, address=79 Hansons Circle, country=United States, state=VA, phoneNumber=4-(084)741-2810)
   * Guest(id=168, firstName=Fred, lastName=Snyder, email=fsnyder2n@samsung.com, address=5 8th Drive, country=United States, state=CA, phoneNumber=4-(204)127-6115)
   * Guest(id=169, firstName=Benjamin, lastName=Snyder, email=bsnyderv@cafepress.com, address=8 Steensland Point, country=Poland, state=, phoneNumber=3-(961)447-1196)
   * Guest(id=170, firstName=Joyce, lastName=Stephens, email=jstephens20@zimbio.com, address=5 Toban Drive, country=United States, state=MO, phoneNumber=9-(961)593-9442)
   * Guest(id=171, firstName=Barbara, lastName=Stephens, email=bstephens1f@yellowbook.com, address=27 Fulton Plaza, country=Cuba, state=, phoneNumber=5-(765)751-8667)
   * Guest(id=172, firstName=Kelly, lastName=Stone, email=kstonei@cdc.gov, address=26 Kropf Way, country=United States, state=NY, phoneNumber=8-(139)634-6415)
   * Guest(id=173, firstName=Angela, lastName=Torres, email=atorres8@uol.com.br, address=63232 Columbus Place, country=United States, state=MA, phoneNumber=1-(439)654-3373)
   * Guest(id=174, firstName=Roy, lastName=Tucker, email=rtuckerg@example.com, address=6707 Maple Parkway, country=United States, state=OH, phoneNumber=3-(093)128-8690)
   * Guest(id=175, firstName=Joseph, lastName=Tucker, email=jtucker15@disqus.com, address=17922 Quincy Pass, country=United States, state=CA, phoneNumber=0-(990)513-0451)
   * Guest(id=176, firstName=Dorothy, lastName=Tucker, email=dtucker14@ehow.com, address=3593 Atwood Circle, country=France, state=B5, phoneNumber=9-(243)144-3879)
   * Guest(id=177, firstName=Rebecca, lastName=Turner, email=rturner27@google.co.uk, address=89156 Atwood Junction, country=China, state=, phoneNumber=4-(853)728-1963)
   * Guest(id=178, firstName=Brian, lastName=Wagner, email=bwagner13@quantcast.com, address=3833 Pierstorff Point, country=United States, state=MD, phoneNumber=5-(595)231-2208)
   * Guest(id=179, firstName=Kenneth, lastName=Walker, email=kwalker29@aboutads.info, address=9 Superior Crossing, country=United States, state=WA, phoneNumber=0-(953)489-2738)
   * Guest(id=180, firstName=Debra, lastName=Wallace, email=dwallacer@nps.gov, address=23 Ohio Terrace, country=United States, state=CT, phoneNumber=0-(483)351-8933)
   * Guest(id=181, firstName=Raymond, lastName=Ward, email=rwardm@nationalgeographic.com, address=47656 Old Shore Street, country=United States, state=NC, phoneNumber=3-(715)261-7860)
   * Guest(id=182, firstName=Henry, lastName=Warren, email=hwarren19@apache.org, address=12 Kennedy Plaza, country=Philippines, state=, phoneNumber=4-(180)111-6593)
   * Guest(id=183, firstName=Henry, lastName=Washington, email=hwashington2q@mail.ru, address=80 Autumn Leaf Street, country=Indonesia, state=, phoneNumber=6-(962)303-1876)
   * Guest(id=184, firstName=Adam, lastName=Watkins, email=awatkinst@timesonline.co.uk, address=4 Susan Street, country=Egypt, state=, phoneNumber=7-(977)440-3683)
   * Guest(id=185, firstName=Nicholas, lastName=Watkins, email=nwatkins1b@va.gov, address=74962 Steensland Avenue, country=China, state=, phoneNumber=1-(946)323-6647)
   * Guest(id=186, firstName=Timothy, lastName=Watson, email=twatson1k@shinystat.com, address=184 Lukken Hill, country=United States, state=NE, phoneNumber=1-(046)935-7571)
   * Guest(id=187, firstName=Louis, lastName=Webb, email=lwebb2e@blogspot.com, address=1958 Granby Avenue, country=Indonesia, state=, phoneNumber=0-(713)613-4968)
   * Guest(id=188, firstName=Charles, lastName=Webb, email=cwebb2l@twitter.com, address=5012 Eggendart Pass, country=Latvia, state=, phoneNumber=2-(444)641-6850)
   * Guest(id=189, firstName=Tina, lastName=Welch, email=twelch1u@yahoo.co.jp, address=4 Bashford Terrace, country=United States, state=MN, phoneNumber=1-(518)288-4237)
   * Guest(id=190, firstName=Rose, lastName=Welch, email=rwelchu@gnu.org, address=56176 Burning Wood Lane, country=Serbia, state=, phoneNumber=9-(271)628-1625)
   * Guest(id=191, firstName=Paula, lastName=Wheeler, email=pwheeler1s@mac.com, address=39639 Leroy Avenue, country=United States, state=OH, phoneNumber=4-(874)769-0414)
   * Guest(id=192, firstName=Shawn, lastName=Williams, email=swilliamsc@joomla.org, address=60 Sugar Plaza, country=United States, state=MI, phoneNumber=4-(867)695-7864)
   * Guest(id=193, firstName=Harold, lastName=Williams, email=hwilliamsm@dion.ne.jp, address=6728 Colorado Street, country=Russia, state=, phoneNumber=5-(250)547-3562)
   * Guest(id=194, firstName=Paul, lastName=Willis, email=pwillis12@e-recht24.de, address=0177 Everett Junction, country=United States, state=DC, phoneNumber=7-(560)524-0255)
   * Guest(id=195, firstName=Jose, lastName=Wood, email=jwoodn@mtv.com, address=59447 Ludington Parkway, country=United States, state=NY, phoneNumber=3-(322)044-6672)
   * Guest(id=196, firstName=Janet, lastName=Wood, email=jwood1k@goodreads.com, address=445 Harper Parkway, country=Ireland, state=, phoneNumber=0-(943)656-4847)
   * Guest(id=197, firstName=Victor, lastName=Wright, email=vwright7@baidu.com, address=542 Mandrake Center, country=Ukraine, state=, phoneNumber=0-(279)357-3386)
   * Guest(id=198, firstName=Kimberly, lastName=Wright, email=kwrightf@tinyurl.com, address=9893 Summit Plaza, country=Brazil, state=, phoneNumber=3-(288)433-6668)
   * Guest(id=199, firstName=Joan, lastName=Wright, email=jwright1q@phoca.cz, address=55 Dawn Parkway, country=Moldova, state=, phoneNumber=7-(830)749-3794)
   * Guest(id=200, firstName=Judith, lastName=Young, email=jyoung11@goodreads.com, address=2 Sachtjen Parkway, country=United States, state=WV, phoneNumber=9-(659)879-6466)
   * *************RESERVATIONS**************
   * Reservation(id=1, roomId=8, guestId=200, reservationDate=2023-08-28)
   */

}
