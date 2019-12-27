package components;

import java.util.ArrayList;

public class Maze{
  ArrayList<Room> rooms = new ArrayList<Room>();

  public Maze(){

  }

  public void addRoom(Room r){
    rooms.add(r);
  }

  public Room getRoom(int roomNo){
    for(Room r : rooms)
      if(r.getRoomNo() == roomNo)
        return r;
    return null;
  }
}