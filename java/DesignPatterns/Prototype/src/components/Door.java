package components;

public class Door implements MapSite{
  Room room1;
  Room room2;
  boolean isOpened;

  public Door clone(){
    return new Door(this);
  }

  public Door(){
    
  }
  public Door(Door prototype){
    this.room1 = prototype.room1;
    this.room2 = prototype.room2;
  }

  public void init(Room r1, Room r2){
    this.room1 = r1;
    this.room2 = r2;
  }

  public void Enter(){
    
  }
}