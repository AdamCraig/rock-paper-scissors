import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

  @Test
  public void checkWinner_rockBeatsScissors_true() {
    App testGame = new App();
    assertEquals("Rock Wins!", testGame.checkWinner("Rock", "Scissors"));
  }
}
