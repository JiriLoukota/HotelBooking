import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BookingManager bookingManager;
    static List<Booking> bookingList = new ArrayList<>();
    public static void main(String[] args) {
        fillBookings();
        System.out.println("Všechny rezervace:");
        writeAllBookings();
        System.out.println("Prvních osm rekreačních rezervací:");
        writeRecreations(8);
        System.out.println("Statistiky:");
        printGuestStatistics();
    }
    public static void fillBookings(){
        //Rooms
        Room roomOne = new Room(3,1, true, false, BigDecimal.valueOf(1200));
        Room roomTwo = new Room(2,2, false, true, BigDecimal.valueOf(2400));
        //Guests
        Guest guestOne = new Guest("Karel", "Dvořák", LocalDate.of(1990,5,15));
        Guest guestTwo = new Guest("Karel", "Dvořák", LocalDate.of(1979,1,3));
        Guest guestThree = new Guest("Karolína", "Tmavá", LocalDate.of(1990,5,15));
        //Bookings
        Booking bookingOne = new Booking(roomOne, LocalDate.of(2023,6,1), LocalDate.of(2023,6,7), true, guestOne);
        Booking bookingTwo = new Booking(roomTwo, LocalDate.of(2023,7,18), LocalDate.of(2023,7,21), false, guestTwo);
        Booking bookingThree = new Booking(roomOne, LocalDate.of(2023,8,1), LocalDate.of(2023,8,31), false, guestThree);

        int dayOne = 0, dayTwo = 0;
        for(int i =0; i < 10; i++){
            dayOne = (i * 2) + 1;
            dayTwo = dayOne+1;
            bookingList.add(new Booking(roomTwo,LocalDate.of(2023,8,dayOne), LocalDate.of(2023,8,dayTwo), false, guestThree));

        }
        //adding all bookings into list and adding the list into BookingManager
        bookingList.add(bookingOne);
        bookingList.add(bookingTwo);
        bookingList.add(bookingThree);
        bookingManager = new BookingManager(bookingList);
    }

    public static void writeAllBookings(){
        //This method creates
        for (Booking booking: bookingList ) System.out.println(booking.toString());
    }
    public static void writeRecreations(int number){
        int recreation = 0;
        for(Booking booking : bookingList){
            if(!booking.isWorkingStay()){
                recreation++;
                System.out.println(booking.toString());
            }
            if(recreation==number) break;
        }
    }
    public static void printGuestStatistics(){
        int oneGuest = 0, twoGuests= 0, moreThanTwoGuests =0;
        for(Booking booking : bookingList){
            if (booking.getNumberOfGuests()==1)oneGuest++;
            if (booking.getNumberOfGuests()==2)twoGuests++;
            if (booking.getNumberOfGuests()>2)moreThanTwoGuests++;
        }
        System.out.println("Počet rezervací s jedním hostem: " + oneGuest);
        System.out.println("Počet rezervací se dvěma hosty: " + twoGuests);
        System.out.println("Počet rezervací s více než dvěma hosty: " + moreThanTwoGuests);
    }
}