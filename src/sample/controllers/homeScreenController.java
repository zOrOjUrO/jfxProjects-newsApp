package sample.controllers;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import java.net.URL;


public class homeScreenController implements Initializable{

    public Label storyHead1;
    public Label storyBrief1;
    public ImageView storyImage1;
    public ImageView storyImage2;
    public Label storyHead2;
    public Label storyBrief2;
    public ImageView storyImage3;
    public Label storyHead3;
    public Label storyBrief3;
    public ImageView storyImage4;
    public Label storyHead4;
    public Label storyBrief4;
    public ImageView storyImage5;
    public Label storyBrief5;
    public Label storyHead5;
    public TextField searchBar;
    public Button topNews;
    public Button techNews;
    public Button sportsNews;
    public Button travelNews;
    public Button scienceNews;


    private Parent root;
    private Stage stage;
    private Scene scene;

    public ArrayList<Label> storyHeads;
    public ArrayList<Label> storyBriefs;
    public ArrayList<ImageView> storyMedia;


    //private NewsRecords newsRecords;

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

    /*
    public void __init(NewsRecords newsRecords){
        this.newsRecords = newsRecords;
    }
     */

    private void highlightCurrentTopicButton(String topic){
        topNews.setStyle("-fx-background-color: rgba(241, 90, 36, 0.15);\n" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.0), 10, 0, 0, 0)");
        techNews.setStyle("-fx-background-color: rgba(241, 90, 36, 0.15);\n" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.0), 10, 0, 0, 0)");
        travelNews.setStyle("-fx-background-color: rgba(241, 90, 36, 0.15);\n" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.0), 10, 0, 0, 0)");
        sportsNews.setStyle("-fx-background-color: rgba(241, 90, 36, 0.15);\n" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.0), 10, 0, 0, 0)");
        scienceNews.setStyle("-fx-background-color: rgba(241, 90, 36, 0.15);\n" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.0), 10, 0, 0, 0)");
        if ("tech".equalsIgnoreCase(topic)){
            techNews.setStyle("-fx-background-color: rgba(241, 90, 36, 0.25);\n" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 0)");
        }
        else if("sport".equalsIgnoreCase(topic)){
            sportsNews.setStyle("-fx-background-color: rgba(241, 90, 36, 0.25);\n" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 0)");
        }
        else if("travel".equalsIgnoreCase(topic)){
            travelNews.setStyle("-fx-background-color: rgba(241, 90, 36, 0.25);\n" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 0)");
        }
        else if("science".equalsIgnoreCase(topic)){
            scienceNews.setStyle("-fx-background-color: rgba(241, 90, 36, 0.25);\n" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 0)");
        }
        else if("top".equalsIgnoreCase(topic)){
            topNews.setStyle("-fx-background-color: rgba(241, 90, 36, 0.25);\n" +
                    "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 0)");
        }
        else if("search".equalsIgnoreCase(topic)){
            //nothing
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        storyHeads = new ArrayList<Label>(List.of(storyHead1, storyHead2,storyHead3,storyHead4,storyHead5));
        storyBriefs = new ArrayList<Label>(List.of(storyBrief1, storyBrief2,storyBrief3,storyBrief4,storyBrief5));
        storyMedia = new ArrayList<ImageView>(List.of(storyImage1, storyImage2,storyImage3,storyImage4,storyImage5));

        setStoryHeads(NewsRecords.currentTopic);
        setStoryBriefs(NewsRecords.currentTopic);
        setStoryMedia(NewsRecords.currentTopic);
        highlightCurrentTopicButton(NewsRecords.currentTopic);

    }

    private void setStoryHeads(String topic) throws IndexOutOfBoundsException{
        if(topic.equalsIgnoreCase("top")){
            int i = 0;
            int size = NewsRecords.topTitles.size();
            for (Label head: storyHeads)
                if(i < size)head.setText(NewsRecords.topTitles.get(i++));
        }
        else if(topic.equalsIgnoreCase("tech")){
            int i = 0;
            int size =NewsRecords.techTitles.size();
            for (Label head: storyHeads)
                if(i < size)head.setText(NewsRecords.techTitles.get(i++));
        }
        else if(topic.equalsIgnoreCase("travel")){
            int i = 0;
            int size = NewsRecords.travelTitles.size();
            for (Label head: storyHeads)
                if(i < size)head.setText(NewsRecords.travelTitles.get(i++));
        }
        else if(topic.equalsIgnoreCase("science")){
            int i = 0;
            int size = NewsRecords.scienceTitles.size();
            for (Label head: storyHeads)
                if(i < size)head.setText(NewsRecords.scienceTitles.get(i++));
        }
        else if(topic.equalsIgnoreCase("sport")){
            int i = 0;
            int size = NewsRecords.sportTitles.size();
            for (Label head: storyHeads)
                if(i < size)head.setText(NewsRecords.sportTitles.get(i++));
        }
        else if(topic.equalsIgnoreCase("search")){
            int i = 0;
            int size = NewsRecords.searchTitles.size();
            for (Label head: storyHeads)
                if(i < size)head.setText(NewsRecords.searchTitles.get(i++));
        }
    }

    private void setStoryBriefs(String topic) throws IndexOutOfBoundsException{
        if(topic.equalsIgnoreCase("top")){
            int i = 0;
            int size = NewsRecords.topSummary.size();
            for (Label head: storyBriefs)
                if(i < size) head.setText(NewsRecords.topSummary.get(i++));
        }
        else if(topic.equalsIgnoreCase("tech")){
            int i = 0;
            int size = NewsRecords.techSummary.size();
            for (Label head: storyBriefs)
                if(i < size) head.setText(NewsRecords.techSummary.get(i++));
        }
        else if(topic.equalsIgnoreCase("travel")){
            int i = 0;
            int size = NewsRecords.travelSummary.size();
            for (Label head: storyBriefs)
                if(i < size)head.setText(NewsRecords.travelSummary.get(i++));
        }
        else if(topic.equalsIgnoreCase("science")){
            int i = 0;
            int size = NewsRecords.scienceSummary.size();
            for (Label head: storyBriefs)
               if(i < size) head.setText(NewsRecords.scienceSummary.get(i++));
        }
        else if(topic.equalsIgnoreCase("sport")){
            int i = 0;
            int size = NewsRecords.sportSummary.size();
            for (Label head: storyBriefs)
                if(i < size) head.setText(NewsRecords.sportSummary.get(i++));
        }
        else if(topic.equalsIgnoreCase("search")){
            int i = 0;
            int size = NewsRecords.searchSummary.size();
            for (Label head: storyBriefs)
                if(i < size) head.setText(NewsRecords.searchSummary.get(i++));
        }
    }

    private void setStoryMedia(String topic) throws IndexOutOfBoundsException{
        //String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"; //toValidate URL
        //String mediaRegex = "([^\\s]+(\\.(?i)(jpe?g|png|gif|bmp)))";
        if(topic.equalsIgnoreCase("top")){
            int i = 0;
            int size = NewsRecords.topPictures.size();
            for (ImageView frame: storyMedia){
                if( i < size //&&
                        //(NewsRecords.topPictures.get(i).getUrl().matches(regex)
                         //       || NewsRecords.topPictures.get(i).getUrl().matches(mediaRegex))
                        )
                    frame.setImage(NewsRecords.topPictures.get(i++));
            }
        }
        else if(topic.equalsIgnoreCase("tech")){
            int i = 0;
            int size =NewsRecords.techPictures.size();
            for (ImageView frame: storyMedia){
                if(i < size
                        //&& (NewsRecords.techPictures.get(i).getUrl().matches(regex)
                        //|| NewsRecords.techPictures.get(i).getUrl().matches(mediaRegex))
                        )
                    frame.setImage(NewsRecords.techPictures.get(i++));
            }
        }
        else if(topic.equalsIgnoreCase("travel")){
            int i = 0;
            int size = NewsRecords.travelPictures.size();
            for (ImageView frame: storyMedia){
                if(i < size
                        //&& (NewsRecords.travelPictures.get(i).getUrl().matches(regex)
                        //|| NewsRecords.travelPictures.get(i).getUrl().matches(mediaRegex))
                    )
                    frame.setImage(NewsRecords.travelPictures.get(i++));
            }
        }
        else if(topic.equalsIgnoreCase("science")){
            int i = 0;
            int size = NewsRecords.sciencePictures.size();
            for (ImageView frame: storyMedia){
                if(i < size
                        //&& (NewsRecords.sciencePictures.get(i).getUrl().matches(regex)
                        //|| NewsRecords.sciencePictures.get(i).getUrl().matches(mediaRegex))
                    )
                    frame.setImage(NewsRecords.sciencePictures.get(i++));
            }
        }
        else if(topic.equalsIgnoreCase("sport")){
            int i = 0;
            int size =NewsRecords.sportPictures.size();
            for (ImageView frame: storyMedia){
                if(i < size
                        //&& (NewsRecords.sportPictures.get(i).getUrl().matches(regex)
                        //|| NewsRecords.sportPictures.get(i).getUrl().matches(mediaRegex))
                    )
                    frame.setImage(NewsRecords.sportPictures.get(i++));
            }
        }
        else if(topic.equalsIgnoreCase("search")){
            int i = 0;
            int size = NewsRecords.searchPictures.size();
            System.out.println("\n\nSize: "+size);
            for (ImageView frame: storyMedia){
                if(i < size) {
                    /*
                    System.out.println(NewsRecords.searchPictures.get(i).getUrl() +
                            "\n" + NewsRecords.searchPictures.get(i).getUrl().matches(regex));
                    if (NewsRecords.searchPictures.get(i).getUrl().matches(regex)
                            || NewsRecords.searchPictures.get(i).getUrl().matches(mediaRegex))

                     */
                        frame.setImage(NewsRecords.searchPictures.get(i++));
                }
            }
        }
    }

    public void showTopNews(MouseEvent mouseEvent) {
        NewsRecords.currentTopic = "top";
        setStoryHeads("top");
        setStoryBriefs("top");
        setStoryMedia("top");
        highlightCurrentTopicButton(NewsRecords.currentTopic);

    }

    public void showTechNews(MouseEvent mouseEvent) {
        NewsRecords.currentTopic = "tech";
        setStoryHeads("tech");
        setStoryBriefs("tech");
        setStoryMedia("tech");
        highlightCurrentTopicButton(NewsRecords.currentTopic);
    }

    public void showSportsNews(MouseEvent mouseEvent) {
        NewsRecords.currentTopic = "sport";
        setStoryHeads("sport");
        setStoryBriefs("sport");
        setStoryMedia("sport");
        highlightCurrentTopicButton(NewsRecords.currentTopic);
    }

    public void showTravelNews(MouseEvent mouseEvent) {
        NewsRecords.currentTopic = "travel";
        setStoryHeads("travel");
        setStoryBriefs("travel");
        setStoryMedia("travel");
        highlightCurrentTopicButton(NewsRecords.currentTopic);
    }

    public void showScienceNews(MouseEvent mouseEvent) {
        NewsRecords.currentTopic = "science";
        setStoryHeads("science");
        setStoryBriefs("science");
        setStoryMedia("science");
        highlightCurrentTopicButton(NewsRecords.currentTopic);
    }

    public void showSearch(MouseEvent mouseEvent) {
        NewsRecords.currentTopic = "search";
        if(searchBar.getText().isEmpty()) return;
        long then = System.currentTimeMillis();

        NewsRecords.fetchSearch(searchBar.getText());

        while((System.currentTimeMillis() - then) <= 3000.0);

        setStoryHeads("search");
        setStoryBriefs("search");
        setStoryMedia("search");
        highlightCurrentTopicButton(NewsRecords.currentTopic);
    }

    public void fetchMore(MouseEvent mouseEvent) {
        System.out.println("Fetch More: "+NewsRecords.currentTopic);
        try {
            NewsRecords.fetchNext(NewsRecords.currentTopic);
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
        long then = System.currentTimeMillis();
        while((System.currentTimeMillis() - then) <= 3500.0);
        if ("tech".equalsIgnoreCase(NewsRecords.currentTopic))
            showTechNews(mouseEvent);
        else if("sport".equalsIgnoreCase(NewsRecords.currentTopic))
            showSportsNews(mouseEvent);
        else if("travel".equalsIgnoreCase(NewsRecords.currentTopic))
            showTravelNews(mouseEvent);
        else if("science".equalsIgnoreCase(NewsRecords.currentTopic))
            showScienceNews(mouseEvent);
        else if("top".equalsIgnoreCase(NewsRecords.currentTopic))
            showTopNews(mouseEvent);
        else if("search".equalsIgnoreCase(NewsRecords.currentTopic))
            showSearch(mouseEvent);
    }

    public void switchToDetailScreen(MouseEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(Main.class.getResource("screens/storyDetailScreen.fxml")));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showStory1(MouseEvent mouseEvent) throws IOException {
        //NewsRecords.currentTopic = currentTopic;
        NewsRecords.currentSelectedIndex = 0;
        switchToDetailScreen(mouseEvent);
    }

    public void showStory2(MouseEvent mouseEvent) throws IOException {
        //NewsRecords.currentTopic = currentTopic;
        NewsRecords.currentSelectedIndex = 1;
        switchToDetailScreen(mouseEvent);
    }

    public void showStory3(MouseEvent mouseEvent) throws IOException {
        //NewsRecords.currentTopic = currentTopic;
        NewsRecords.currentSelectedIndex = 2;
        switchToDetailScreen(mouseEvent);
    }

    public void showStory4(MouseEvent mouseEvent) throws IOException {
        //NewsRecords.currentTopic = currentTopic;
        NewsRecords.currentSelectedIndex = 3;
        switchToDetailScreen(mouseEvent);
    }

    public void showStory5(MouseEvent mouseEvent) throws IOException {
        //NewsRecords.currentTopic = currentTopic;
        NewsRecords.currentSelectedIndex = 4;
        switchToDetailScreen(mouseEvent);
    }
}

