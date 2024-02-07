import java.math.BigDecimal;

public class Room {
    //Attributes
    private int roomNo;
    private int numberOfBeds;
    private boolean hasBalcony;
    private boolean hasViewToSea;
    private BigDecimal pricePerNight;
    //Constructor
    public Room(int roomNo,int numberOfBeds, boolean hasBalcony, boolean hasViewToSea, BigDecimal pricePerNight){
        this.roomNo=roomNo;
        this.numberOfBeds=numberOfBeds;
        this.hasBalcony=hasBalcony;
        this.hasViewToSea=hasViewToSea;
        this.pricePerNight=pricePerNight;
    }


    //region Setters and Getters
    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean isHasViewToSea() {
        return hasViewToSea;
    }

    public void setHasViewToSea(boolean hasViewToSea) {
        this.hasViewToSea = hasViewToSea;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    //endregion

    //Converting room info into text
    @Override
    public String toString() {
        StringBuilder descriptionOfRoom = new StringBuilder("Číslo pokoje:  " + roomNo + ", počet postelí " + numberOfBeds + ", balkón: ");
        if(hasBalcony){
            descriptionOfRoom.append("ano, ");
        }else{
            descriptionOfRoom.append("ne, ");
        }
        if(hasViewToSea){
            descriptionOfRoom.append("výhled na moře: ano, ");
        }else{
            descriptionOfRoom.append("výhled na moře: ne, ");
        }
        descriptionOfRoom.append("cena na jednu noc: ").append(pricePerNight.toString()).append(" Kč");
        return String.valueOf(descriptionOfRoom);
    }
}
