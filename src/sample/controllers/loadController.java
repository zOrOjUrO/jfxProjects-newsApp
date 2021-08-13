package sample.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Main;

import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class loadController implements Initializable{
    public ImageView playButton;
    @FXML
    private ProgressBar loadBar;
    public AnchorPane rootPane;

    private final NewsRecords stories = new NewsRecords();
    private Thread fetch(){
        return new Thread(() -> {
            try {
                stories.fetchAllStories();
            } catch (IOException | InterruptedException exception) {
                exception.printStackTrace();
            }
        }, "NewsFetchThread");
    }

    public void switchToMainScreen(MouseEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(Main.class.getResource("screens/homeScreen.fxml")));
        //homeScreenController home = loader.getController();
        //home.__init(stories);
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fetch().start();
        double size = 25000.0;
        final double[] i = {5000.0};
        new Thread(() -> {
            while (i[0] <= size) {
                    final double step = i[0];
                    i[0] = i[0] + 100;
                    Platform.runLater(() -> loadBar.setProgress( step / size ));
                    //System.out.printf("Complete: %02.2f%n", i * 10);
                    try {
                        Thread.sleep(60);
                        if(i[0] == size){
                            loadBar.setVisible(false);
                            playButton.setVisible(true);
                        }
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
        }).start();
        NewsRecords.currentTopic = "top";
    }
}
