package components;

import enums.Direction;

public class Room implements MapSite{
  private int roomNo;
  private MapSite[] sides = new MapSite[4];

  public Room clone(){
    return new Room(this);
  }

  public Room(){

  }

  public Room(Room prototype){
    this.roomNo = prototype.roomNo;
  }

  public void init(int roomNo){
    this.roomNo = roomNo;
  }
  
  public void Enter(){
    
  }

  public void setSide(Direction direction, MapSite mapsite){
    switch(direction){
      case North: sides[0] = mapsite; break; 
      case South: sides[1] = mapsite; break; 
      case East: sides[2] = mapsite; break; 
      case West: sides[3] = mapsite; break; 
    }
  }
  
  public MapSite getSide(Direction direction){
    switch(direction){
      case North: return sides[0]; 
      case South: return sides[1]; 
      case East: return sides[2]; 
      case West: return sides[3];
    }
    return null;
  }

  public int getRoomNo(){
    return roomNo;
  }
}