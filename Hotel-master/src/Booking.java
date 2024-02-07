import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    //Attributes
    private Room room;
    private LocalDate firstDay;
    private LocalDate lastDay;
    private boolean workingStay;
    private Guest mainGuest;
    private List<Guest> guests;
    //Constructors
    public Booking(Room room, LocalDate firstDay, LocalDate lastDay, boolean workingStay,Guest mainGuest, List<Guest> guests) {
        this.room = room;
        this.firstDay = firstDay;
        this.lastDay = lastDay;
        this.workingStay = workingStay;
        this.mainGuest = mainGuest;
        this.guests = guests;
    }
    public Booking(Room room, LocalDate firstDay, LocalDate lastDay, boolean workingStay,Guest mainGuest) {
        this.room = room;
        this.firstDay = firstDay;
        this.lastDay = lastDay;
        this.workingStay = workingStay;
        this.mainGuest = mainGuest;
        List<Guest> guestList = new ArrayList<>();
        guestList.add(mainGuest);
        this.guests = guestList;
    }


    //region Settery a Gettery

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(LocalDate firstDay) {
        this.firstDay = firstDay;
    }

    public LocalDate getLastDay() {
        return lastDay;
    }

    public void setLastDay(LocalDate lastDay) {
        this.lastDay = lastDay;
    }

    public boolean isWorkingStay() {
        return workingStay;
    }

    public void setWorkingStay(boolean workingStay) {
        this.workingStay = workingStay;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public Guest getMainGuest() {
        return mainGuest;
    }

    public void setMainGuest(Guest mainGuest) {
        this.mainGuest = mainGuest;
    }
    //endregion

    //Special methods:

    //Returns number of guests
    public int getNumberOfGuests(){
        return guests.size();
    }
    //Returns length of booking in days
    public int getBookingLength(){
        return lastDay.compareTo(firstDay) + 1;
    }
    //Returns total price of booking
    public BigDecimal getPrice(){
        return this.getRoom().getPricePerNight().multiply(BigDecimal.valueOf(this.getBookingLength()));
    }
    //Converting booking information into text
    @Override
    public String toString() {
        String viewToSea;
        if(this.getRoom().isHasViewToSea())  viewToSea = "ano";
        else viewToSea="ne";
        return this.getFirstDay().getDayOfMonth() + ". " + this.getFirstDay().getMonthValue() + ". " + this.getFirstDay().getYear() + " až " + this.getLastDay().getDayOfMonth() + ". " + this.getLastDay().getMonthValue() + ". " + this.getLastDay().getYear() + ": " + this.getMainGuest().getFirstName() + " " + this.getMainGuest().getSurname() +
                " (" + this.getMainGuest().getBirthday().getDayOfMonth() + ". " + this.getMainGuest().getBirthday().getMonthValue() + ". " + this.getMainGuest().getBirthday().getYear()
                + ") [" + this.getNumberOfGuests() + ", " + viewToSea + "] za " + this.getRoom().getPricePerNight().multiply(BigDecimal.valueOf(this.getBookingLength())) + " Kč";
    }
}