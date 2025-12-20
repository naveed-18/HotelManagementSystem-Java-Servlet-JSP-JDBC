package model;

import java.sql.Timestamp;

public class Reservation {

    private int id;
    private String name;
    private int room;
    private String phone;
    private Timestamp date;

    public Reservation(int id, String name, int room, String phone, Timestamp date) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.phone = phone;
        this.date = date;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getRoom() { return room; }
    public String getPhone() { return phone; }
    public Timestamp getDate() { return date; }
}
