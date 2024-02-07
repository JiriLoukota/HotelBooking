import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    //Attribute
    private List<Booking> bookings;
    //Constructor
    public BookingManager(List<Booking> bookings){
        this.bookings = bookings;
    }
    //Getter and setter
    public List<Booking> getBookings() {
        return bookings;
    }
    public void setBookings(List<Booking> bookings) {
        this.bookings=bookings;
    }
    //Special methods:

    //Returns booking of inserted index
    public Booking getBooking(int index){
        return bookings.get(index);
    }
    //Adds new booking
    public void addBooking(Booking newBooking){
        bookings.addLast(newBooking);
    }
    //Clears whole bookings list
    public void clearBookings(){
        bookings.clear();
    }
    //Returns number of working booking in the list
    public int getNumberOfWorkingBookings(){
        int numberOfWorkingBookings = 0;
        for (Booking booking : bookings) {
            if (booking.isWorkingStay()) {
                numberOfWorkingBookings++;
            }
        }
        return numberOfWorkingBookings;
    }
    //Returns average number of guests per one booking
    public double getAverageGuests(){
        double averageGuests=0;
        for(Booking booking : bookings){
            averageGuests += Double.valueOf(booking.getNumberOfGuests());
        }
        averageGuests = averageGuests/bookings.size();
        return averageGuests;

    }

}
