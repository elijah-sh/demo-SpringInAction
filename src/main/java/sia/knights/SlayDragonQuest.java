package sia.knights;

import java.io.PrintStream;

// 屠龙的任务
public class SlayDragonQuest implements Quest {

  private PrintStream stream;

  public SlayDragonQuest(PrintStream stream) {
    this.stream = stream;
  }

  public void embark() {
    // 踏上杀龙之旅
    stream.println("Embarking on quest to slay the dragon!");
  }

}
