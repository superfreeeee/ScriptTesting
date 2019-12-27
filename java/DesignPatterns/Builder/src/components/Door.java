package components;

public class Door implements MapSite{
  Room room1;
  Room room2;
  boolean isOpened;

  public Door(Room r1, Room r2){
    this.room1 = r1;
    this.room2 = r2;
  }

  public void Enter(){
    
  }
}