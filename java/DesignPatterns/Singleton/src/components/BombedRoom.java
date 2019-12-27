package components;

/**
 * BombRoom
 */
public class BombedRoom extends Room {
  protected boolean haveBomb = true;

  public BombedRoom(int roomNo){
    super(roomNo);
  }
}