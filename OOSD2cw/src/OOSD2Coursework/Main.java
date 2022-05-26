package OOSD2Coursework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent FXMLRoot = FXMLLoader.load(getClass().getResource("ScenebuilderUI.fxml")); // this will load up the UI
        Scene Scene = new Scene(FXMLRoot);
        primaryStage.setScene(Scene);
        primaryStage.show();
        primaryStage.setTitle("Table Tennis Management System"); // title
    }

    //this will store all the teams, fixtures,matches into an array
    public static List<Team> teamList = new ArrayList<>();
    public static List<Fixtures> fixtureList = new ArrayList<>();
    public static List<Match> matchList = new ArrayList<>();


    public static void main(String[] args) {
        launch(args);

    }

    // this will generate the fixtures
    public static void GenerateFixtures() {
        fixtureList.clear(); // this will clear the fixtures list
        // this will increment the team size of list if added by user and the fixtures will be incremented
        int i = 0;
        while (i < Main.teamList.size()) {
            int TempF = 0;
            while (TempF < Main.teamList.size()) {
                if (i != TempF) {
                    Fixtures tempFixture = new Fixtures(Main.teamList.get(i), Main.teamList.get(TempF));
                    fixtureList.add(tempFixture);
                }
                TempF++;
            }
            i++;
        }
    }

}
