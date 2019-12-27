package components;

/**
 * EnchantedRoom
 */
public class EnchantedRoom extends Room {
  String castSpell;

  public EnchantedRoom(int roomNo, String castSpell) {
    super(roomNo);
    this.castSpell = castSpell;
  }
}