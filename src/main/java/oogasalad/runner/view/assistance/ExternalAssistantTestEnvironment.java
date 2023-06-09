package oogasalad.runner.view.assistance;

import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import oogasalad.runner.view.assistance.chat_gpt.ChatGPTExternalAssistant;

/**
 * The ExternalAssistantTestEnvironment class is used for testing the functionality of the
 * ChatGPTExternalAssistant class which is responsible for providing assistance to the user in a
 * card game.
 * <p>
 * This class creates a GUI with a button that, when clicked, prompts the user to enter a query
 * which is then passed to the ChatGPTExternalAssistant. The response generated by the
 * ChatGPTExternalAssistant is then displayed to the user in an alert dialog.
 *
 * @author Ted
 */
public class ExternalAssistantTestEnvironment extends Application {

  private final Stage stage;
  private final Group root;
  private final Scene scene;
  private final ExternalAssistant externalAssistant;
  private final String filePathToCurrentGameJson = "src/main/java/oogasalad/Game/View/ExternalAssistance/GPT_35_Turbo_Assistant/ExternalAssistantJsonPlaceHolderPath.json";

  public ExternalAssistantTestEnvironment() {
    stage = new Stage();
    root = new Group();

    // Use ChatGPTExternalAssistant instead of BasicExternalAssistant
    externalAssistant = new ChatGPTExternalAssistant(filePathToCurrentGameJson);

    Button askForHelp = new Button("Ask For Help");
    askForHelp.setTranslateX(700);
    askForHelp.setTranslateY(750);
    askForHelp.setOnAction(e -> askForHelpHandler());

    root.getChildren()
        .addAll(askForHelp);

    scene = new Scene(root, 800, 800);
    scene.setFill(Color.GREEN);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  private void askForHelpHandler() {
    TextInputDialog textInputDialog = new TextInputDialog();
    textInputDialog.setContentText("How can I help you?");
    textInputDialog.setHeaderText("External Assistant");
    Optional<String> result = textInputDialog.showAndWait();
    if (result.isPresent()) {
      String response = externalAssistant.provideAdvice(result.get());
      showResponse(result.get(), response);
    }
  }

  private void showResponse(String prompt, String response) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setHeaderText("Here's what I found:");
    alert.setContentText(String.format("You asked: %s\nMy response: %s", prompt, response));
    alert.show();
  }

  @Override
  public void start(Stage primaryStage) {
  }

}
