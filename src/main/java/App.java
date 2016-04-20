import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import java.util.Random;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main ( String[] args ) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      HashMap model = new HashMap();
      String player = request.queryParams("player");
      String computer = App.computerChooses();
      String winner = App.checkWinner(player, computer);
      model.put("player", player);
      model.put("computer", computer);
      model.put("winner", winner);
      model.put("template", "templates/results.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/twoPlayerHome", (request, response) -> {
      String playerOne = "";
      HashMap model = new HashMap();
      model.put("template", "templates/twoPlayerHome.vtl");
      model.put("playerOne", playerOne);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/playerTwoSelect", (request, response) -> {
      HashMap model = new HashMap();
      String playerTwo = "";
      String playerOne = "";
      playerOne = request.queryParams("playerOne");
      model.put("template", "templates/playerTwoSelect.vtl");
      model.put("playerTwo", playerTwo);
      model.put("playerOne", playerOne);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/twoPlayerResults", (request, response) -> {
      HashMap model = new HashMap();
      String playerOne = "";
      String playerTwo = "";
      playerOne = request.queryParams("playerOne");
      playerTwo = request.queryParams("playerTwo");
      String winner = App.checkWinner(playerOne, playerTwo);
      model.put("playerOne", playerOne);
      model.put("playerTwo", playerTwo);
      model.put("winner", winner);
      model.put("template", "templates/twoPlayerResults.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

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

  public static String computerChooses() {
    Random myRandomGenerator = new Random();
    String computerChoice = "Rock";

    Integer computerChoiceInteger = myRandomGenerator.nextInt(3);

    if (computerChoiceInteger == 0) {
      computerChoice = "Scissors";
    } else if (computerChoiceInteger == 1) {
      computerChoice = "Paper";
    }
    return computerChoice;
  }
  }
