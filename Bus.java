public class Bus {
    private String busNumber;
    private Seat[][] seats;

        public Bus() {
        this("DEFAULT-BUS", 2);
    }

        public Bus(String busNumber, int rows) {
        this.busNumber = busNumber;
        this.seats = new Seat[rows][4];         
        int seatNum = 1;
            for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 4; j++) {
                seats[i][j] = new Seat(seatNum++);
            }
        }
    }

        public void displaySeats() {
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Row " + (i + 1) + ": ");
            for (int j = 0; j < seats[i].length; j++) {
                Seat s = seats[i][j];
                String status = s.isReserved() ? "X" : "O";
                String formattedNum = String.format("%02d", s.getSeatNumber());
                
                System.out.print(formattedNum + ":" + status + " ");
                
                    if (j == 1) {
                    System.out.print("|| ");
                }
            }
            System.out.println();
        }
    }

    public void reserveSeat(int seatNumber) {
        Seat targetSeat = null;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j].getSeatNumber() == seatNumber) {
                    targetSeat = seats[i][j];
                    break;
                }
            }
        }

        if (targetSeat != null) {
            if (targetSeat.reserve()) {
                System.out.println("Reserving Seat " + seatNumber + ": Successful");
            } else {
                System.out.println("Reserving Seat " + seatNumber + ": Already Reserved");
            }
        } else {
            System.out.println("Reserving Seat " + seatNumber + ": Seat not found");
        }
    }

    public int countAvailableSeats() {
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (!seats[i][j].isReserved()) {
                    count++;
                }
            }
        }
        return count;
    }
}