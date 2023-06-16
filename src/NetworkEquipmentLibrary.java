import java.io.*;
import java.util.*;

public class NetworkEquipmentLibrary {
    private List<Equipment> equipmentList;

    public NetworkEquipmentLibrary() {
        equipmentList = new ArrayList<>();
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 9) {
                    String name = data[0].trim();
                    String manufacturer = data[1].trim();
                    String modelNumber = data[2].trim();
                    String serialNumber = data[3].trim();
                    String macAddress = data[4].trim();
                    String currentIPAddress = data[5].trim();
                    String previousIPAddress = data[6].trim();
                    String currentLocation = data[7].trim();
                    String previousLocation = data[8].trim();
                    Equipment equipment = new Equipment(name, manufacturer, modelNumber, serialNumber, macAddress,
                            currentIPAddress, previousIPAddress, currentLocation, previousLocation);
                    equipmentList.add(equipment);
                }
            }
            System.out.println("Data loaded successfully from file.");
        } catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }

    public void storeToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Equipment equipment : equipmentList) {
                String line = equipment.getName() + "," + equipment.getManufacturer() + "," +
                        equipment.getModelNumber() + "," + equipment.getSerialNumber() + "," +
                        equipment.getMacAddress() + "," + equipment.getCurrentIPAddress() + "," +
                        equipment.getPreviousIPAddress() + "," + equipment.getCurrentLocation() + "," +
                        equipment.getPreviousLocation();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data stored successfully to file.");
        } catch (IOException e) {
            System.out.println("Error storing data to file: " + e.getMessage());
        }
    }

    public void addEquipment(Equipment equipment) {
        equipmentList.add(equipment);
        System.out.println("Equipment added successfully.");
    }

    public Equipment findEquipmentByMACAddress(String macAddress) {
        for (Equipment equipment : equipmentList) {
            if (equipment.getMacAddress().equals(macAddress)) {
                return equipment;
            }
        }
        return null;
    }

    public void updateEquipmentIPAddress(String macAddress, String newIPAddress) {
        Equipment equipment = findEquipmentByMACAddress(macAddress);
        if (equipment != null) {
            equipment.setPreviousIPAddress(equipment.getCurrentIPAddress());
            equipment.setCurrentIPAddress(newIPAddress);
            System.out.println("Equipment IP address updated successfully.");
        } else {
            System.out.println("Equipment not found.");
        }
    }

    //public void connectEquipment (Equipment equipment1,Equipment equipment2)
    //{

      //  equipment1.getConnections().add(equipment2);
        //equipment2.getConnections().add(equipment1);
          //      System.out.println("Equipment Connected Successfully");
    //}

    public void connectEquipment (Equipment equipment1,Equipment equipment2)
    {

        equipment1.getConnections().add(equipment2);
        equipment2.getConnections().add(equipment1);
        System.out.println("Equipment Connected Successfully");

    }

    public void disconnectEquipment(Equipment equipment1, Equipment equipment2) {
       equipment1.getConnections().remove(equipment2);
        equipment2.getConnections().remove(equipment1);
        System.out.println("Equipment disconnected successfully.");
    }

    public Equipment getLastUpdatedEquipment() {
        if (equipmentList.isEmpty()) {
            return null;
        }
        return equipmentList.get(equipmentList.size() - 1);
    }

    public Equipment getLastConnectedEquipment() {
        if (equipmentList.isEmpty()) {
            return null;
        }
        for (int i = equipmentList.size() - 1; i >= 0; i--) {
            if (!equipmentList.get(i).getConnections().isEmpty()) {
                return equipmentList.get(i);
            }
        }
        return null;
    }
}
