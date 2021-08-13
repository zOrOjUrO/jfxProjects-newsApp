package sample.controllers;

import javafx.scene.image.Image;
import sample.Main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsRecords {

    static int topCycle;
    static ArrayList<String> topTitles;
    static ArrayList<String> topLinks;
    static ArrayList<String> topSummary;
    static ArrayList<Image> topPictures;

    static int searchCycle;
    static String searchTerm;
    static ArrayList<String> searchTitles;
    static ArrayList<String> searchLinks;
    static ArrayList<String> searchSummary;
    static ArrayList<Image> searchPictures;

    static int techCycle;
    static ArrayList<String> techTitles;
    static ArrayList<String> techLinks;
    static ArrayList<String> techSummary;
    static ArrayList<Image> techPictures;

    static int sportCycle;
    static ArrayList<String> sportTitles;
    static ArrayList<String> sportLinks;
    static ArrayList<String> sportSummary;
    static ArrayList<Image> sportPictures;

    static int travelCycle;
    static ArrayList<String> travelTitles;
    static ArrayList<String> travelLinks;
    static ArrayList<String> travelSummary;
    static ArrayList<Image> travelPictures;

    static int scienceCycle;
    static ArrayList<String> scienceTitles;
    static ArrayList<String> scienceLinks;
    static ArrayList<String> scienceSummary;
    static ArrayList<Image> sciencePictures;

    static String currentTopic;
    static int currentSelectedIndex;

    static final String API_KEY = "bd3de8ed95msh38e84a05aa68ab4p1daa04jsn3946f8db5b61"; //API KEY

    NewsRecords(){
        topCycle = 1;
        topTitles = new ArrayList<>();
        topLinks = new ArrayList<>();
        topSummary = new ArrayList<>();
        topPictures = new ArrayList<>();

        searchCycle = 1;
        searchTerm = "";
        searchTitles = new ArrayList<>();
        searchLinks = new ArrayList<>();
        searchSummary = new ArrayList<>();
        searchPictures = new ArrayList<>();

        techCycle = 1;
        techTitles = new ArrayList<>();
        techLinks = new ArrayList<>();
        techSummary = new ArrayList<>();
        techPictures = new ArrayList<>();

        sportCycle = 1;
        sportTitles = new ArrayList<>();
        sportLinks = new ArrayList<>();
        sportSummary = new ArrayList<>();
        sportPictures = new ArrayList<>();

        travelCycle = 1;
        travelTitles = new ArrayList<>();
        travelLinks = new ArrayList<>();
        travelSummary = new ArrayList<>();
        travelPictures = new ArrayList<>();

        scienceCycle = 1;
        scienceTitles = new ArrayList<>();
        scienceLinks = new ArrayList<>();
        scienceSummary = new ArrayList<>();
        sciencePictures = new ArrayList<>();

        currentSelectedIndex = 0;
        currentTopic = "top";
    }

    private static void showTopicContent(String topic){
        if("top".equalsIgnoreCase(topic)) {
            System.out.println("\n\tTOP STORIES\n\t");
            for (int i = 0; i < 5; i++) {
                try {
                    if (!topTitles.get(i).isEmpty())
                        System.out.println("\n\nTitle: " + topTitles.get(i));
                    if (!topSummary.get(i).isEmpty())
                        System.out.println("\nSummary: " + topSummary.get(i));
                    if (!topLinks.get(i).isEmpty())
                        System.out.println("\nLink: " + topLinks.get(i));
                    if (!topPictures.get(i).getUrl().isEmpty())
                        System.out.println("\nImage: " + topPictures.get(i).getUrl() + "\n");
                } catch (Exception ignored) {
                }
            }
        }
        else if("search".equalsIgnoreCase(topic)){
            System.out.println("\n\tSEARCH STORIES\n\t");
            for (int i = 0; i < 5; i++) {
                try {
                    if (!searchTitles.get(i).isEmpty())
                        System.out.println("\n\nTitle: " + searchTitles.get(i));
                    if (!searchSummary.get(i).isEmpty())
                        System.out.println("\nSummary: " + searchSummary.get(i));
                    if (!searchLinks.get(i).isEmpty())
                        System.out.println("\nLink: " + searchLinks.get(i));
                    if (!searchPictures.get(i).getUrl().isEmpty())
                        System.out.println("\nImage: " + searchPictures.get(i).getUrl() + "\n");
                } catch (Exception ignored) {
                }
            }
        }
        else if("tech".equalsIgnoreCase(topic)){
            System.out.println("\n\tTECH STORIES\n\t");
            for (int i = 0; i < 5; i++) {
                try {
                    if (!techTitles.get(i).isEmpty())
                        System.out.println("\n\nTitle: " + techTitles.get(i));
                    if (!techSummary.get(i).isEmpty())
                        System.out.println("\nSummary: " + techSummary.get(i));
                    if (!techLinks.get(i).isEmpty())
                        System.out.println("\nLink: " + techLinks.get(i));
                    if (!techPictures.get(i).getUrl().isEmpty())
                        System.out.println("\nImage: " + techPictures.get(i).getUrl() + "\n");
                } catch (Exception ignored) {
                }
            }
        }
        else if("sport".equalsIgnoreCase(topic)){
            System.out.println("\n\tSPORT STORIES\n\t");
            for (int i = 0; i < 5; i++) {
                try {
                    if (!sportTitles.get(i).isEmpty())
                        System.out.println("\n\nTitle: " + sportTitles.get(i));
                    if (!sportSummary.get(i).isEmpty())
                        System.out.println("\nSummary: " + sportSummary.get(i));
                    if (!sportLinks.get(i).isEmpty())
                        System.out.println("\nLink: " + sportLinks.get(i));
                    if (!sportPictures.get(i).getUrl().isEmpty())
                        System.out.println("\nImage: " + sportPictures.get(i).getUrl() + "\n");
                } catch (Exception ignored) {
                }
            }
        }
        else if("travel".equalsIgnoreCase(topic)){
            System.out.println("\n\tTRAVEL STORIES\n\t");
            for (int i = 0; i < 5; i++) {
                try {
                    if (!travelTitles.get(i).isEmpty())
                        System.out.println("\n\nTitle: " + travelTitles.get(i));
                    if (!travelSummary.get(i).isEmpty())
                        System.out.println("\nSummary: " + travelSummary.get(i));
                    if (!travelLinks.get(i).isEmpty())
                        System.out.println("\nLink: " + travelLinks.get(i));
                    if (!travelPictures.get(i).getUrl().isEmpty())
                        System.out.println("\nImage: " + travelPictures.get(i).getUrl() + "\n");
                } catch (Exception ignored) {
                }
            }
        }
        else if("science".equalsIgnoreCase(topic)){
            System.out.println("\n\tSCIENCE STORIES\n\t");
            for (int i = 0; i < 5; i++) {
                try {
                    if (!scienceTitles.get(i).isEmpty())
                        System.out.println("\n\nTitle: " + scienceTitles.get(i));
                    if (!scienceSummary.get(i).isEmpty())
                        System.out.println("\nSummary: " + scienceSummary.get(i));
                    if (!scienceLinks.get(i).isEmpty())
                        System.out.println("\nLink: " + scienceLinks.get(i));
                    if (!sciencePictures.get(i).getUrl().isEmpty())
                        System.out.println("\nImage: " + sciencePictures.get(i).getUrl() + "\n");
                } catch (Exception ignored) {
                }
            }
        }
    }

    private static void clearTopicData(String topic){
        if(topic.equalsIgnoreCase("tech")){
            techTitles.clear();
            techSummary.clear();
            techPictures.clear();
            techLinks.clear();
        }
        else if(topic.equalsIgnoreCase("sport")) {
            sportTitles.clear();
            sportLinks.clear();
            sportSummary.clear();
            sportPictures.clear();
        }
        else if(topic.equalsIgnoreCase("travel")) {
            travelTitles.clear();
            travelPictures.clear();
            travelSummary.clear();
            travelLinks.clear();
        }
        else if(topic.equalsIgnoreCase("science")){
            scienceTitles.clear();
            scienceSummary.clear();
            sciencePictures.clear();
            scienceLinks.clear();
        }
    }

    private static String getURL(String url){
        URL url1 = null;
        try {
             url1 = new URL(url);
        } catch (MalformedURLException e) {
            //e.printStackTrace();
        }
        if(url1 == null)
            return "";
        return url1.toString();
    }

    private static void getTopContentFromBody(HttpResponse<String> item, String content, int numberOfItems){
        if(content.equalsIgnoreCase("title"))
            topTitles.clear();
        else if(content.equalsIgnoreCase("summary"))
            topSummary.clear();
        else if(content.equalsIgnoreCase("media"))
            topPictures.clear();
        else
            topLinks.clear();
        int kStart = 0;
        for (int i = 0; i < numberOfItems*topCycle; i++) {
            int startIndex = -1;
            int endIndex = -1;
            try {
                startIndex = item.body().indexOf("\""+content+"\":\"", kStart) + ("\""+content+"\":\"").length();
                endIndex = item.body().indexOf("\"", startIndex);
                kStart = endIndex+1;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (startIndex != -1) {
                if(content.equalsIgnoreCase("title"))
                    topTitles.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
                else if(content.equalsIgnoreCase("summary"))
                    topSummary.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
                else if(content.equalsIgnoreCase("media")){
                    String url = getURL(item.body().substring(startIndex, endIndex)).toString();
                    if(!url.isEmpty()) topPictures.add(i%numberOfItems, new Image(url));
                    else
                        topPictures.add(i%numberOfItems, new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/defaultStoryImage.png"))));
                }
                else
                    topLinks.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
            } else
                System.out.println("No Matches Found");
        }
    }

    private static void getSearchContentFromBody(HttpResponse<String> item, String content, int numberOfItems){
        if(content.equalsIgnoreCase("title"))
            searchTitles.clear();
        else if(content.equalsIgnoreCase("summary"))
            searchSummary.clear();
        else if(content.equalsIgnoreCase("media"))
            searchPictures.clear();
        else
            searchLinks.clear();
        int kStart = 0;
        for (int i = 0; i < numberOfItems*searchCycle; i++) {
            int startIndex = -1;
            int endIndex = -1;
            try {
                startIndex = item.body().indexOf("\""+content+"\":\"", kStart) + ("\""+content+"\":\"").length();
                endIndex = item.body().indexOf("\"", startIndex);
                kStart = endIndex+1;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (startIndex != -1) {
                if(content.equalsIgnoreCase("title"))
                    searchTitles.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
                else if(content.equalsIgnoreCase("summary"))
                    searchSummary.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
                else if(content.equalsIgnoreCase("media")) {
                    String url = getURL(item.body().substring(startIndex, endIndex)).toString();
                    if(!url.isEmpty()) searchPictures.add(i%numberOfItems, new Image(url));
                    else{
                        String mediaRegex = "([^\\s]+(\\.(?i)(jpe?g|png|gif|bmp)))";
                        String temp = item.body().substring(startIndex, endIndex);
                        if ((temp.matches(mediaRegex)))
                            searchPictures.add(i%numberOfItems, new Image(temp));
                        else{
                            if(temp.contains(".jpg") || temp.contains(".jpeg")
                                    || temp.contains(".png") || temp.contains("/image")
                                    || temp.contains(".gif"))
                                searchPictures.add(i%numberOfItems, new Image(temp));
                            else
                                searchPictures.add(i%numberOfItems, new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/defaultStoryImage.png"))));
                        }
                    }
                }
                else
                    searchLinks.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
            } else
                System.out.println("No Matches Found");
        }
    }

    private static void getTechField(HttpResponse<String> item, int numberOfItems, String field){
        int kStart = 0;
        for (int i = 0; i < numberOfItems*techCycle; i++) {
            int startIndex = -1;
            int endIndex = -1;
            try {
                startIndex = item.body().indexOf("\""+field+"\":\"", kStart) + ("\""+field+"\":\"").length();
                endIndex = item.body().indexOf("\"", startIndex);
                kStart = endIndex+1;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (startIndex != -1) {
                if(field.equalsIgnoreCase("title"))
                    techTitles.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
                else if(field.equalsIgnoreCase("summary"))
                    techSummary.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
                else if(field.equalsIgnoreCase("media")) {
                    String url = getURL(item.body().substring(startIndex, endIndex)).toString();
                    if (!url.isEmpty())
                        techPictures.add(i % numberOfItems, new Image(url));
                    else
                        techPictures.add(i%numberOfItems, new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/defaultStoryImage.png"))));
                }
                else
                    techLinks.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
            } else
                System.out.println("No Matches Found");
        }
    }

    private static void getSportField(HttpResponse<String> item, int numberOfItems, String field) {
        int kStart = 0;
        for (int i = 0; i < numberOfItems*sportCycle; i++) {
            int startIndex = -1;
            int endIndex = -1;
            try {
                startIndex = item.body().indexOf("\""+field+"\":\"", kStart) + ("\""+field+"\":\"").length();
                endIndex = item.body().indexOf("\"", startIndex);
                kStart = endIndex+1;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (startIndex != -1) {
                if(field.equalsIgnoreCase("title"))
                    sportTitles.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
                else if(field.equalsIgnoreCase("summary"))
                    sportSummary.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
                else if(field.equalsIgnoreCase("media")) {
                    String url = getURL(item.body().substring(startIndex, endIndex)).toString();
                    if (!url.isEmpty())
                        sportPictures.add(i % numberOfItems, new Image(url));
                    else
                        sportPictures.add(i%numberOfItems, new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/defaultStoryImage.png"))));
                }
                else
                    sportLinks.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
            } else
                System.out.println("No Matches Found");
        }
    }

    private static void getTravelField(HttpResponse<String> item, int numberOfItems, String field) {
        int kStart = 0;
        for (int i = 0; i < numberOfItems*travelCycle; i++) {
            int startIndex = -1;
            int endIndex = -1;
            try {
                startIndex = item.body().indexOf("\""+field+"\":\"", kStart) + ("\""+field+"\":\"").length();
                endIndex = item.body().indexOf("\"", startIndex);
                kStart = endIndex+1;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (startIndex != -1) {
                if(field.equalsIgnoreCase("title"))
                    travelTitles.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
                else if(field.equalsIgnoreCase("summary"))
                    travelSummary.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
                else if(field.equalsIgnoreCase("media")) {
                    String url = getURL(item.body().substring(startIndex, endIndex)).toString();
                    if (!url.isEmpty())
                        travelPictures.add(i % numberOfItems, new Image(url));
                    else
                        travelPictures.add(i%numberOfItems, new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/defaultStoryImage.png"))));
                }
                else
                    travelLinks.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
            } else
                System.out.println("No Matches Found");
        }
    }

    private static void getScienceField(HttpResponse<String> item, int numberOfItems, String field) {
        int kStart = 0;
        for (int i = 0; i < numberOfItems*scienceCycle; i++) {
            int startIndex = -1;
            int endIndex = -1;
            try {
                startIndex = item.body().indexOf("\""+field+"\":\"", kStart) + ("\""+field+"\":\"").length();
                endIndex = item.body().indexOf("\"", startIndex);
                kStart = endIndex+1;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (startIndex != -1) {
                if(field.equalsIgnoreCase("title"))
                    scienceTitles.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
                else if(field.equalsIgnoreCase("summary"))
                    scienceSummary.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
                else if(field.equalsIgnoreCase("media")) {
                    String url = getURL(item.body().substring(startIndex, endIndex)).toString();
                    if (!url.isEmpty())
                        sciencePictures.add(i % numberOfItems, new Image(url));
                    else
                        sciencePictures.add(i%numberOfItems, new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/defaultStoryImage.png"))));
                }
                else
                    scienceLinks.add(i%numberOfItems, item.body().substring(startIndex, endIndex));
            } else
                System.out.println("No Matches Found");
        }
    }

    private static void getTopicContentFromBody(HttpResponse<String> item, String topic, int numberOfItems){

        clearTopicData(topic);
        if ("tech".equalsIgnoreCase(topic)) {
            getTechField(item, numberOfItems, "title");
            getTechField(item, numberOfItems, "summary");
            getTechField(item, numberOfItems, "media");
            getTechField(item, numberOfItems, "links");
        }
        else if("sport".equalsIgnoreCase(topic)){
            getSportField(item, numberOfItems, "title");
            getSportField(item, numberOfItems, "summary");
            getSportField(item, numberOfItems, "media");
            getSportField(item, numberOfItems, "links");
        }
        else if("travel".equalsIgnoreCase(topic)){
            getTravelField(item, numberOfItems, "title");
            getTravelField(item, numberOfItems, "summary");
            getTravelField(item, numberOfItems, "media");
            getTravelField(item, numberOfItems, "links");
        }
        else if("science".equalsIgnoreCase(topic)){
            getScienceField(item, numberOfItems, "title");
            getScienceField(item, numberOfItems, "summary");
            getScienceField(item, numberOfItems, "media");
            getScienceField(item, numberOfItems, "links");
        }
        else if("top".equalsIgnoreCase(topic)){
            getTopContentFromBody(item, "title", numberOfItems); //get 5 titles
            getTopContentFromBody(item, "summary", numberOfItems); //get 5 summary
            getTopContentFromBody(item, "media", numberOfItems); //get 5 media
            getTopContentFromBody(item, "link", numberOfItems); //get 5 links
        }
        else if("search".equalsIgnoreCase(topic)){
            getSearchContentFromBody(item, "title", numberOfItems);
            getSearchContentFromBody(item, "summary", numberOfItems);
            getSearchContentFromBody(item, "media", numberOfItems);
            getSearchContentFromBody(item, "link", numberOfItems);
        }
    }


    public static void fetchTopStories() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://newscatcher.p.rapidapi.com/v1/latest_headlines?lang=en&media=True"))
                .header("x-rapidapi-key", API_KEY)
                .header("x-rapidapi-host", "newscatcher.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        Thread thread = new Thread(() -> {
            HttpResponse<String> response = null;
            try {
                response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            getTopicContentFromBody(response, "top", 5);
            showTopicContent("top");
        }, "TopNewsThread");
        thread.start();
    }

    private static void searchStoryByTerm(String searchPhrase) throws IOException, InterruptedException {
        if(!searchPhrase.isEmpty()) {
            searchTerm = searchPhrase.strip();
            HttpRequest.Builder builder = HttpRequest.newBuilder();
            StringBuilder apiCallBuilder = new StringBuilder();
            apiCallBuilder.append("https://free-news.p.rapidapi.com/v1/search?q=");
            for (String key : searchPhrase.split(" ")) apiCallBuilder.append(key).append("%20");
            builder.uri(URI.create(apiCallBuilder.append("&lang=en").toString()));
            builder.header("x-rapidapi-key", API_KEY);
            builder.header("x-rapidapi-host", "free-news.p.rapidapi.com");
            builder.method("GET", HttpRequest.BodyPublishers.noBody());
            HttpRequest request = builder.build();

            Thread thread = new Thread(() -> {
                HttpResponse<String> item = null;
                try {
                    item = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                getTopicContentFromBody(item, "search", 5);
                showTopicContent("search");
            },"SearchThread");
            thread.start();

        }
    }

    public static void fetchTechStories() throws IOException, InterruptedException{
        String topic = "tech";

        HttpRequest.Builder builder = HttpRequest.newBuilder();
        StringBuilder apiCallBuilder = new StringBuilder();
        apiCallBuilder.append("https://newscatcher.p.rapidapi.com/v1/latest_headlines?lang=en&media=True&topic=").append(topic);
        builder.uri(URI.create(apiCallBuilder.append("&lang=en").toString()));
        builder.header("x-rapidapi-key", API_KEY);
        builder.header("x-rapidapi-host", "newscatcher.p.rapidapi.com");
        builder.method("GET", HttpRequest.BodyPublishers.noBody());
        HttpRequest request = builder.build();

        Thread thread = new Thread(() -> {
            HttpResponse<String> item = null;
            try {
                item = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            getTopicContentFromBody(item, topic, 5);
            showTopicContent("tech");
        },"TechNewsThread");
        thread.start();

    }

    public static void fetchSportStories() throws IOException, InterruptedException{
        String topic = "sport";

        HttpRequest.Builder builder = HttpRequest.newBuilder();
        StringBuilder apiCallBuilder = new StringBuilder();
        apiCallBuilder.append("https://newscatcher.p.rapidapi.com/v1/latest_headlines?lang=en&media=True&topic=").append(topic);
        builder.uri(URI.create(apiCallBuilder.append("&lang=en").toString()));
        builder.header("x-rapidapi-key", API_KEY);
        builder.header("x-rapidapi-host", "newscatcher.p.rapidapi.com");
        builder.method("GET", HttpRequest.BodyPublishers.noBody());
        HttpRequest request = builder.build();

        Thread thread = new Thread(() -> {
            HttpResponse<String> item = null;
            try {
                item = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            getTopicContentFromBody(item, topic, 5);
            showTopicContent("sport");
        },"SportsNewsThread");
        thread.start();
    }

    public static void fetchTravelStories() throws IOException, InterruptedException{
        String topic = "travel";

        HttpRequest.Builder builder = HttpRequest.newBuilder();
        StringBuilder apiCallBuilder = new StringBuilder();
        apiCallBuilder.append("https://newscatcher.p.rapidapi.com/v1/latest_headlines?lang=en&media=True&topic=").append(topic);
        builder.uri(URI.create(apiCallBuilder.append("&lang=en").toString()));
        builder.header("x-rapidapi-key", API_KEY);
        builder.header("x-rapidapi-host", "newscatcher.p.rapidapi.com");
        builder.method("GET", HttpRequest.BodyPublishers.noBody());
        HttpRequest request = builder.build();

        Thread thread = new Thread(() -> {
            HttpResponse<String> item = null;
            try {
                item = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            getTopicContentFromBody(item, topic, 5);
            showTopicContent("travel");
        },"TravelNewsThread");
        thread.start();
    }

    public static void fetchScienceStories() throws IOException, InterruptedException{
        String topic = "science";

        HttpRequest.Builder builder = HttpRequest.newBuilder();
        StringBuilder apiCallBuilder = new StringBuilder();
        apiCallBuilder.append("https://newscatcher.p.rapidapi.com/v1/latest_headlines?lang=en&media=True&topic=").append(topic);
        builder.uri(URI.create(apiCallBuilder.append("&lang=en").toString()));
        builder.header("x-rapidapi-key", API_KEY);
        builder.header("x-rapidapi-host", "newscatcher.p.rapidapi.com");
        builder.method("GET", HttpRequest.BodyPublishers.noBody());
        HttpRequest request = builder.build();

        Thread thread = new Thread(() -> {
            HttpResponse<String> item = null;
            try {
                item = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            getTopicContentFromBody(item, topic, 5);
            showTopicContent("science");
        },"ScienceNewsThread");
        thread.start();
    }

    public static void fetchNext(String topic) throws IOException, InterruptedException {
        if(topic.equalsIgnoreCase("tech")){
            techCycle++;
            fetchTechStories();
        }
        else if(topic.equalsIgnoreCase("sport")) {
            sportCycle++;
            fetchSportStories();
        }
        else if(topic.equalsIgnoreCase("travel")) {
            travelCycle++;
            fetchTravelStories();
        }
        else if(topic.equalsIgnoreCase("science")){
            scienceCycle++;
            fetchScienceStories();
        }
        else if(topic.equalsIgnoreCase("top")){
            topCycle++;
            fetchTopStories();
        }
        else if(topic.equalsIgnoreCase("search")){
            searchCycle++;
            searchStoryByTerm(searchTerm);
        }
    }

    public static void fetchSearch(String searchTerm){
        try {
            searchStoryByTerm(searchTerm);
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public void fetchAllStories() throws IOException, InterruptedException {
        fetchTopStories();
        fetchTechStories();
        fetchTravelStories();
        fetchSportStories();
        fetchScienceStories();
    }

    public static double getRecordsSize(){
        return (
                topTitles.size()+techTitles.size()+sportTitles.size()+travelTitles.size()+scienceTitles.size()
        );
    }
}
