package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class storyController implements Initializable {

    public Label blitzIcon;
    public ImageView closeButton;
    public ImageView backButton;
    public Label storyCard;
    public Label storyTitle;
    public Label storySummary;
    public Label storyInfo;
    public ImageView storyImage;

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

    @FXML
    public void closeApp(MouseEvent mouseEvent){
        if(exitConfirmation()){
            Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
            stage.close();
            System.out.println("App Closed");
        }
    }

    public void returnToHome(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(Main.class.getResource("screens/homeScreen.fxml")));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if ("tech".equalsIgnoreCase(NewsRecords.currentTopic)) {
            storyImage.setImage(NewsRecords.techPictures.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.techPictures.size()-1)));
            storyTitle.setText(NewsRecords.techTitles.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.techTitles.size()-1)));
            storySummary.setText(NewsRecords.techSummary.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.techSummary.size()-1)));
            storyInfo.setText(NewsRecords.techLinks.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.techLinks.size()-1)));
        }
        else if("sport".equalsIgnoreCase(NewsRecords.currentTopic)){
            storyImage.setImage(NewsRecords.sportPictures.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.sportPictures.size()-1)));
            storyTitle.setText(NewsRecords.sportTitles.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.sportTitles.size()-1)));
            storySummary.setText(NewsRecords.sportSummary.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.sportSummary.size()-1)));
            storyInfo.setText(NewsRecords.sportLinks.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.sportLinks.size()-1)));
        }
        else if("travel".equalsIgnoreCase(NewsRecords.currentTopic)){
            storyImage.setImage(NewsRecords.travelPictures.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.travelPictures.size()-1)));
            storyTitle.setText(NewsRecords.travelTitles.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.travelTitles.size()-1)));
            storySummary.setText(NewsRecords.travelSummary.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.travelSummary.size()-1)));
            storyInfo.setText(NewsRecords.travelLinks.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.travelLinks.size()-1)));
        }
        else if("science".equalsIgnoreCase(NewsRecords.currentTopic)){
            storyImage.setImage(NewsRecords.sciencePictures.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.sciencePictures.size()-1)));
            storyTitle.setText(NewsRecords.scienceTitles.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.scienceTitles.size()-1)));
            storySummary.setText(NewsRecords.scienceSummary.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.scienceSummary.size()-1)));
            storyInfo.setText(NewsRecords.scienceLinks.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.scienceLinks.size()-1)));
        }
        else if("top".equalsIgnoreCase(NewsRecords.currentTopic)){
            storyImage.setImage(NewsRecords.topPictures.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.topPictures.size()-1)));
            storyTitle.setText(NewsRecords.topTitles.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.topTitles.size()-1)));
            storySummary.setText(NewsRecords.topSummary.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.topSummary.size()-1)));
            storyInfo.setText(NewsRecords.topLinks.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.topLinks.size()-1)));
        }
        else if("search".equalsIgnoreCase(NewsRecords.currentTopic)){
            storyImage.setImage(NewsRecords.searchPictures.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.searchPictures.size()-1)));
            storyTitle.setText(NewsRecords.searchTitles.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.searchTitles.size()-1)));
            storySummary.setText(NewsRecords.searchSummary.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.searchSummary.size()-1)));
            storyInfo.setText(NewsRecords.searchLinks.get(
                    Math.min(NewsRecords.currentSelectedIndex, NewsRecords.searchLinks.size()-1)));
        }
    }
}
