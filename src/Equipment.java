import java.io.*;
import java.util.*;
class Equipment {
    private String name;
    private String manufacturer;
    private String modelNumber;
    private String serialNumber;
    private String macAddress;
    private String currentIPAddress;
    private String previousIPAddress;
    private String currentLocation;
    private String previousLocation;
    private List<Equipment> connections;

    public Equipment(String name, String manufacturer, String modelNumber, String serialNumber, String macAddress,
                     String currentIPAddress, String previousIPAddress, String currentLocation, String previousLocation) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.modelNumber = modelNumber;
        this.serialNumber = serialNumber;
        this.macAddress = macAddress;
        this.currentIPAddress = currentIPAddress;
        this.previousIPAddress = previousIPAddress;
        this.currentLocation = currentLocation;
        this.previousLocation = previousLocation;
        this.connections = new ArrayList<>();
    }

    // Getters and setters for the Equipment class

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getCurrentIPAddress() {
        return currentIPAddress;
    }

    public void setCurrentIPAddress(String currentIPAddress) {
        this.currentIPAddress = currentIPAddress;
    }

    public String getPreviousIPAddress() {
        return previousIPAddress;
    }

    public void setPreviousIPAddress(String previousIPAddress) {
        this.previousIPAddress = previousIPAddress;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getPreviousLocation() {
        return previousLocation;
    }

    public void setPreviousLocation(String previousLocation) {
        this.previousLocation = previousLocation;
    }

    public List<Equipment> getConnections() {
        return connections;
    }

    public void setConnections(List<Equipment> connections) {
        this.connections = connections;
    }
}
