import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MainGUI extends JPanel {
    private ReservationSystem reservationSystem = new ReservationSystem();
    private JTextArea textArea;
    private JPanel panel1;
    private JTextField textField1;

    public MainGUI() {
        setLayout(new BorderLayout());

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton displayTrainsButton = new JButton("Display Available Trains");
        displayTrainsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAvailableTrains();
            }
        });

        JButton checkAvailabilityButton = new JButton("Check Seat Availability");
        checkAvailabilityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkSeatAvailability();
            }
        });

        JButton bookTicketButton = new JButton("Book a Ticket");
        bookTicketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookTicket();
            }
        });

        JButton cancelTicketButton = new JButton("Cancel a Ticket");
        cancelTicketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelTicket();
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        buttonPanel.add(displayTrainsButton);
        buttonPanel.add(checkAvailabilityButton);
        buttonPanel.add(bookTicketButton);
        buttonPanel.add(cancelTicketButton);

        add(buttonPanel, BorderLayout.EAST);
    }

    private void displayAvailableTrains() {
        ArrayList<Train> trains = reservationSystem.getAvailableTrains();
        textArea.setText("Available Trains:\nTrain Name\tTime\tPassenger Strength\tTrain Number\n");
        for (Train train : trains) {
            textArea.append(train.name + "\t" + train.time + "\t" + train.passengerStrength + "\t" + train.trainNumber + "\n");
        }
    }

    private void checkSeatAvailability() {
        String input = JOptionPane.showInputDialog("Enter Train Number:");
        if (input != null) {
            int trainNumber = Integer.parseInt(input);
            reservationSystem.checkSeatAvailability(trainNumber);
        }
    }

    private void bookTicket() {
        String input = JOptionPane.showInputDialog("Enter Train Number:");
        if (input != null) {
            int trainNumber = Integer.parseInt(input);
            String passengerName = JOptionPane.showInputDialog("Enter Passenger Name:");
            reservationSystem.bookTicket(trainNumber, passengerName);
        }
    }

    private void cancelTicket() {
        String passengerName = JOptionPane.showInputDialog("Enter Passenger Name to Cancel:");
        if (passengerName != null) {
            reservationSystem.cancelTicket(passengerName);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Railway Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainGUI());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

