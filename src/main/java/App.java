import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
// import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main ( String[] args ) {}

  public static String checkWinner(String firstPlay, String secondPlay) {
    String winningString = "Tie!";
    if (firstPlay.equals("Rock") && secondPlay.equals("Scissors") || firstPlay.equals("Scissors") && secondPlay.equals("Rock")) {
      winningString = "Rock Wins!";
    } else if (firstPlay.equals("Paper") && secondPlay.equals("Scissors") || firstPlay.equals("Scissors") && secondPlay.equals("Paper")) {
      winningString = "Scissors Wins!";
    } else if (firstPlay.equals("Paper") && secondPlay.equals("Rock") || firstPlay.equals("Rock") && secondPlay.equals("Paper")) {
      winningString = "Paper Wins!";
    }
    return winningString;
    }
  }
