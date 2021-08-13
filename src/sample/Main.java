package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    private boolean exitConfirmation(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CLOSE BLITZ");
        alert.setHeaderText("You are about to close the app!");
        alert.setContentText("Are You sure you want to close the app?");

        if(alert.showAndWait().get() == ButtonType.OK){
            return true;
        }
        return false;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("BLITZ NEWS");
        //Scene scene = new Scene(FXMLLoader.load(getClass().getResource("screens/homeScreen.fxml")));
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("screens/loadScreen.fxml"))));
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/appIcon@64.png")));
        primaryStage.setResizable(false);
        //primaryStage.setFullScreen(true);
        primaryStage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            if(exitConfirmation()) primaryStage.close();});
        System.out.println("App Started");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}