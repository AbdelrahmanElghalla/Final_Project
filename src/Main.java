import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        NetworkEquipmentLibrary library = new NetworkEquipmentLibrary();

        Scanner scanner = new Scanner(System.in);

        // Load data from file
        library.loadFromFile("equipment_data.txt");

        int choice;
        do {
            System.out.println("\n--- Network Equipment Library Menu ---");
            System.out.println("1. Add new equipment");
            System.out.println("2. Find equipment by MAC address");
            System.out.println("3. Update equipment IP address");
            System.out.println("4. Connect equipment to another equipment");
            System.out.println("5. Disconnect equipment from another equipment");
            System.out.println("6. Get last updated equipment");
            System.out.println("7. Get last connected equipment");
            System.out.println("8. Store data to file");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("\n--- Add new equipment ---");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Enter model number: ");
                    String modelNumber = scanner.nextLine();
                    System.out.print("Enter serial number: ");
                    String serialNumber = scanner.nextLine();
                    System.out.print("Enter MAC address: ");
                    String macAddress = scanner.nextLine();
                    System.out.print("Enter current IP address: ");
                    String currentIPAddress = scanner.nextLine();
                    System.out.print("Enter current location: ");
                    String currentLocation = scanner.nextLine();
                    Equipment equipment = new Equipment(name, manufacturer, modelNumber, serialNumber, macAddress,
                            currentIPAddress, "", currentLocation, "");
                    library.addEquipment(equipment);
                    break;
                case 2:
                    System.out.println("\n--- Find equipment by MAC address ---");
                    System.out.print("Enter MAC address: ");
                    String searchMAC = scanner.nextLine();
                    Equipment foundEquipment = library.findEquipmentByMACAddress(searchMAC);
                    if (foundEquipment != null) {
                        System.out.println("Found equipment: " + foundEquipment.getName());
                    } else {
                        System.out.println("Equipment not found.");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Update equipment IP address ---");
                    System.out.print("Enter MAC address: ");
                    String updateMAC = scanner.nextLine();
                    System.out.print("Enter new IP address: ");
                    String newIPAddress = scanner.nextLine();
                    library.updateEquipmentIPAddress(updateMAC, newIPAddress);
                    break;
                case 4:
                    System.out.println("\n--- Connect equipment to another equipment ---");
                    System.out.print("Enter MAC address of equipment 1: ");
                    String connectMAC1 = scanner.nextLine();
                    Equipment equipment1 = library.findEquipmentByMACAddress(connectMAC1);
                    System.out.print("Enter MAC address of equipment 2: ");
                    String connectMAC2 = scanner.nextLine();
                    Equipment equipment2 = library.findEquipmentByMACAddress(connectMAC2);
                    if (equipment1 != null && equipment2 != null) {
                        library.connectEquipment(equipment1, equipment2);
                    } else {
                        System.out.println("Equipment not found.");
                    }
                    break;
                case 5:
                    System.out.println("\n--- Disconnect equipment from another equipment ---");
                    System.out.print("Enter MAC address of equipment 1: ");
                    String disconnectMAC1 = scanner.nextLine();
                    Equipment equip1 = library.findEquipmentByMACAddress(disconnectMAC1);
                    System.out.print("Enter MAC address of equipment 2: ");
                    String disconnectMAC2 = scanner.nextLine();
                    Equipment equip2 = library.findEquipmentByMACAddress(disconnectMAC2);
                    if (equip1 != null && equip2 != null) {
                        library.disconnectEquipment(equip1, equip2);
                    } else {
                        System.out.println("Equipment not found.");
                    }
                    break;
                case 6:
                    System.out.println("\n--- Get last updated equipment ---");
                    Equipment lastUpdated = library.getLastUpdatedEquipment();
                    if (lastUpdated != null) {
                        System.out.println("Last updated equipment: " + lastUpdated.getName());
                    } else {
                        System.out.println("No equipment found.");
                    }
                    break;
                case 7:
                    System.out.println("\n--- Get last connected equipment ---");
                    Equipment lastConnected = library.getLastConnectedEquipment();
                    if (lastConnected != null) {
                        System.out.println("Last connected equipment: " + lastConnected.getName());
                    } else {
                        System.out.println("No equipment found.");
                    }
                    break;
                case 8:
                    System.out.println("\n--- Store data to file ---");
                    library.storeToFile("equipment_data.txt");
                    break;
                case 9:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
