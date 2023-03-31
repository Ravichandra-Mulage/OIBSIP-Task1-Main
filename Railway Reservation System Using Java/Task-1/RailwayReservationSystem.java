import java.util.*;

public class RailwayReservationSystem {
    // Define the train details
    private static final String TRAIN_NAME = "MyTrain";
    private static final int TOTAL_SEATS = 50;
    private static final int MAX_BOOKING_LIMIT = 5;

    // Define the variables to keep track of seat availability and booking details
    private static int seatsLeft = TOTAL_SEATS;
    private static Map<String, Integer> bookings = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to " + TRAIN_NAME + " reservation system!");
            System.out.println("1. Check availability");
            System.out.println("2. Book tickets");
            System.out.println("3. Cancel booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkAvailability();
                    break;
                case 2:
                    bookTickets();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    System.out.println("Thank you for using " + TRAIN_NAME + " reservation system!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Method to check the availability of seats
    private static void checkAvailability() {
        System.out.println("Total seats: " + TOTAL_SEATS);
        System.out.println("Seats left: " + seatsLeft);
        System.out.println("Booked seats: " + bookings);
    }

    // Method to book tickets
    private static void bookTickets() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of seats to book: ");
        int numSeats = scanner.nextInt();
        if (numSeats > MAX_BOOKING_LIMIT) {
            System.out.println("Booking limit exceeded. Maximum booking limit is " + MAX_BOOKING_LIMIT + ".");
            return;
        }
        if (numSeats > seatsLeft) {
            System.out.println("Sorry, seats are not available for your requested number of seats.");
            return;
        }
        System.out.print("Enter your name: ");
        String name = scanner.next();
        bookings.put(name, numSeats);
        seatsLeft -= numSeats;
        System.out.println("Congratulations, your booking is confirmed!");
        System.out.println("Booked seats: " + bookings);
    }

    // Method to cancel booking
    private static void cancelBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.next();
        if (bookings.containsKey(name)) {
            int numSeats = bookings.get(name);
            bookings.remove(name);
            seatsLeft += numSeats;
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("No booking found for the given name.");
        }
    }
}
