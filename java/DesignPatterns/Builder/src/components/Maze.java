package components;

import java.util.ArrayList;

public class Maze{
  private ArrayList<Room> rooms = new ArrayList<Room>();

  public Maze(){

  }

  public void addRoom(Room r){
    rooms.add(r);
  }

  public Room getRoom(int roomNo){
    for(Room room : rooms)
      if(room.getRoomNo() == roomNo)
        return room;
    return null;
  }
}