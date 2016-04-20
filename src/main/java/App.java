import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
// import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main ( String[] args ) {}



  public static String checkWinner(String firstPlay, String secondPlay) {
      String winningString = "Tie!";
      if (firstPlay.equals("Rock") && secondPlay.equals("Scissors")) {
        winningString = "Rock Wins!";
      }

    return winningString;
    }
  }
