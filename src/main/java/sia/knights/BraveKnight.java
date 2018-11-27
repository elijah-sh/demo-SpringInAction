package sia.knights;

/**
 * 勇敢的骑士
 */
public class BraveKnight implements Knight {

  private Quest quest;

  public BraveKnight(Quest quest) {         //  quest 被注入进来
    this.quest = quest;
  }

  public void embarkOnQuest() {
    quest.embark();
  }

}
