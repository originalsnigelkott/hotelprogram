package com.company;

public class Room {
    private int noOfBeds;
    private int roomNo;

    public Room(int roomNo) {
        this.roomNo = roomNo;
        noOfBeds = 2;
    }

    @Override
    public String toString() {
        String output = String.format("" +
                "Roomno: %d\n" +
                "Noofbeds: %d\n" +
                "----------",
                roomNo, noOfBeds);
        return output;
    }
}
