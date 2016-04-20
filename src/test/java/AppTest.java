import org.fluentlenium.adapter.FluentTest;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Enter your play!");
  }

  @Test
  public void scissorSubmission() {
    goTo("http://localhost:4567/");
    click("option", withText("Scissors"));
    submit("#onePlayerButton");
    assertThat(pageSource()).contains("You Chose...", "Scissors");
  }

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
