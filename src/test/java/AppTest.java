import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

  @Test
  public void checkWinner_rockBeatsScissors_rockWins() {
    App testGame = new App();
    assertEquals("Rock Wins!", testGame.checkWinner("Scissors", "Rock"));
  }

  @Test
  public void checkWinner_paperBeatsRock_paperWins() {
    App testGame = new App();
    assertEquals("Paper Wins!", testGame.checkWinner("Paper", "Rock"));
  }

  @Test
  public void checkWinner_scissorsBeatsPaper_scissorsWins() {
    App testGame = new App();
    assertEquals("Scissors Wins!", testGame.checkWinner("Scissors", "Paper"));
  }

  @Test
  public void checkWinner_reversedPlaysWin_secondPlayWins() {
    App testGame = new App();
    assertEquals("Scissors Wins!", testGame.checkWinner("Paper", "Scissors"));
  }

  @Test
  public void checkWinner_bothInputsAreEqual_tie() {
    App testGame = new App();
    assertEquals("Tie!", testGame.checkWinner("Scissors", "Scissors"));
  }

  @Test
  public void computerChooses_shouldBeAString_true() {
    App testGame = new App();
    String computerChoice = testGame.computerChooses();
    assertEquals(true, computerChoice instanceof String);
  }
}
