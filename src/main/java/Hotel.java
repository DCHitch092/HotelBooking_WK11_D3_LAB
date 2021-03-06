import java.util.ArrayList;
import java.util.BitSet;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Booking> bookings;
    private String name;

    public Hotel(String name){
        this.name = name;
        this.bedrooms = new ArrayList<Bedroom>();
        this.conferenceRooms = new ArrayList<ConferenceRoom>();
        this.bookings = new ArrayList<Booking>();
    }

    public String getName() {
        return name;
    }


    public ArrayList<Bedroom> getBedrooms() {
        return new ArrayList<Bedroom>(bedrooms);
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return new ArrayList<ConferenceRoom>(conferenceRooms);
    }

    public void addBedroom(Bedroom bedroom) {
        bedrooms.add(bedroom);
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom){
        conferenceRooms.add(conferenceRoom);
    }

    public void checkInGuestToBedroom(Guest guest, Bedroom room) {
        ArrayList<Bedroom> emptyRooms = getEmptyBedrooms();

        if ( emptyRooms.contains(room) && checkIfBedroom(room) && room.checkCapacity() > 0) {
            room.addGuest(guest);
        }


    }

    public void checkInGuestToConferenceRoom(Guest guest, ConferenceRoom room) {
        if ( checkIfConferenceRoom(room) && room.checkCapacity() > 0) {
            room.addGuest(guest);
        }
    }

    public void checkOutGuestFromBedroom(Guest guest, Bedroom room) {
        room.removeGuest(guest);
    }

    public void checkOutGuestFromConferenceRoom(Guest guest, ConferenceRoom room) {
        room.removeGuest(guest);
    }

    public boolean checkIfBedroom(Bedroom room) {
        return bedrooms.contains(room);
    }

    public boolean checkIfConferenceRoom(ConferenceRoom room) {
        return conferenceRooms.contains(room);
    }

    public Booking createBooking(Bedroom room, int numberOfNights, ArrayList<Guest> guests) {
        Booking newBooking = new Booking(room, numberOfNights, guests);
        bookings.add(newBooking);
        return newBooking;
    }

    public ArrayList<Booking> getBookings(){
        return new ArrayList<Booking>(bookings);
    }

    public ArrayList<Bedroom> getEmptyBedrooms() {
        ArrayList<Bedroom> emptyRooms = new ArrayList<Bedroom>();
        for ( Bedroom room : bedrooms){
            if(room.checkCapacity() == room.getCapacity()){
                emptyRooms.add(room);
            }
        }
        return emptyRooms;
    }

    public void checkInGuestViaBooking(Booking booking) {
            ArrayList<Bedroom> emptyRooms = getEmptyBedrooms();
            ArrayList<Guest> guests = booking.getGuests();
            Bedroom room = booking.getBedroom();

            if ( emptyRooms.contains(room) && checkIfBedroom(room) && room.getCapacity() > guests.size()) {
                for(Guest guest : guests) {
                    room.addGuest(guest);
                }
            }


        }

}
