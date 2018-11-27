package sia.knights;

/***
 *   拯救美少女的骑士
 */
public class DamselRescuingKnight implements Knight {

  /**
   * 寻找拯救美少女
   */
  private RescueDamselQuest quest;

  public DamselRescuingKnight() {
    this.quest = new RescueDamselQuest();
  }

  public void embarkOnQuest() {
    quest.embark();
  }

}
