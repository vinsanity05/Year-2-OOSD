package OOSD2Coursework;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import java.net.URL;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.StringJoiner;
import java.util.Timer;
import java.util.TimerTask;


import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.*;

public class Controller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addTeamLB.getItems().setAll(Main.teamList);
    }

    // ------------- All of this is used for the Admin page ----------------------

    @FXML
    private TextField AdminTeamNameTB; // This is the text box of the admin team name
    @FXML
    private TextField AdminPlayerNameTB; // This is the text box of the admin Player name
    @FXML
    ChoiceBox<Team> addTeamLB; // This is the choice box of the list of teams
    @FXML
    private  TextArea TeamStatReportField; // This is the text area where the team statistics are placed and will be generated 100 seconds every time

    @FXML
    private void addTeamButton(ActionEvent event)  // this button will make the user type the name of the team and will add it to the team
    {
        String add_team_button;
        add_team_button = AdminTeamNameTB.getText();
        System.out.println(add_team_button); // this will print out the team name on the output
        Team temporaryTeam = new Team(AdminTeamNameTB.getText()); //adds a temporary team
        Main.teamList.add(temporaryTeam); //adds the temporary name to the team list
        System.out.println(Main.teamList); // prints out the list of teams

        addTeamLB.getItems().setAll(Main.teamList); // get all the the teams and be stored in this list box
        timer();
    }

    @FXML
    private void addPlayerButton(ActionEvent event) // This button will make the the user to type the name of the player and will add the player to the team
    {
        Object TemporaryTeam = addTeamLB.getSelectionModel().getSelectedItem(); // this will get the the selected team from the choice box
        TemporaryTeam.toString();

        // the size of the team list will expand everytime a team gets added to the list
        int i = 0;
        while (i < Main.teamList.size()) {
            if (TemporaryTeam.toString().equals(Main.teamList.get(i).toString())) { //compared chosen object to all in the list to find the chosen team.
                Main.teamList.get(i).addPlayerToTeam(AdminPlayerNameTB.getText());
            }

            i++;
        }
        System.out.println(addTeamLB.getSelectionModel().getSelectedItem());
    }
    @FXML
    public void generateReportButton(ActionEvent event) {
        System.out.println("Generate Report"); // prints out generate report
        StringJoiner joiner = new StringJoiner("\n");
        //generates the team list size if the list is added and will added if user adds a new team/ increment by 1
        int i = 0;
        while (i < Main.teamList.size()) {
            joiner
                    .add("Team: " + Main.teamList.get(i).toString() + "  →  "
                            + "  Here are the Matches been Played:  " + Main.teamList.get(i).getMatchesPlayed()
                            + "  Here are the Matches that Won: " + Main.teamList.get(i).getMatchesWon()
                            + "  Here are the Sets that Won:" + Main.teamList.get(i).getsetsWon());

            i++;
        }

        TeamStatReportField.setText("\n" + joiner.toString()); // this will set the results to the text field
    }

    Timer timer = new Timer(); // this will generate every 100 seconds for the fixtures

    public void timer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> autoGenerate() //A lambda expression is a used in this code which takes in parameters and returns a value.
                );
            }
        }, 100000, 100000); //Every 100 seconds
    }

    public void autoGenerate() // this will auto generate the team statistics of the report of the matches played, won and sets won
    {
        System.out.println("Auto Generated Statistics report");
        StringJoiner joiner = new StringJoiner("\n");
        //generates the team list size if the list is added and will added if user adds a new team
        int i = 0;
        while (i < Main.teamList.size()) {
            joiner
                    .add("Team: " + Main.teamList.get(i).toString() + "  →  "
                            + "  Here are the Matches been Played:  " + Main.teamList.get(i).getMatchesPlayed()
                            + "  Here are the Matches that Won:  " + Main.teamList.get(i).getMatchesWon()
                            + "  Here are the Sets that Won: " + Main.teamList.get(i).getsetsWon());

            i++;
        }

        TeamStatReportField.setText("\n" + joiner.toString());
    }

    @FXML
    private void fixtureGenButton(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(" ");
        alert.setHeaderText("Do you want to continue?"); // sets the header text
        alert.setContentText(" By generating new fixtures, this will remove all pre-registered match information.");
        Optional<ButtonType> result = alert.showAndWait(); //alert

        if (result.get() != ButtonType.OK) {
            return;  // The user chose Cancel or closed it
        }
        Main.GenerateFixtures();
        System.out.println("Fixtures are manually generated: "); //prints out manually generate fixtures
        // fixtures list are added every time if user is added/ increment is added by 1
        int i = 0;
        while (i < Main.fixtureList.size()) {
            Main.fixtureList.get(i).viewFixture();
            i++;
        }
    }

    // ------------- All of this is used for the Score sheet page ----------------------


    @FXML
    ChoiceBox<Player> choiceHPlayer1; // choice box of home player 1
    @FXML
    ChoiceBox<Player> choiceHPlayer2; // choice box of home player 2
    @FXML
    ChoiceBox<Player> choiceAPlayer1; // choice box of Away player 1
    @FXML
    ChoiceBox<Player> choiceAPlayer2; // choice box of Away player 1
    @FXML
    private Label homeTeamLabel; // home team label
    @FXML
    private Label awayTeamLabel; // away team label
    @FXML
    Match CreateMatch;
    @FXML
    ChoiceBox homeChoice;
    @FXML
    GridPane DoubleSetScoresheetGridPane; // this is the Grid pane of the double set
    @FXML
    GridPane SingleSetsScoresheetGridPane; // this is the Grid pane of the Singles set
    @FXML
    Button PickTeamButton; //pick/choose team button

    // these are all the text fields to input the scores of the home and away team
    @FXML
    private TextField Home1vsAway1set1;
    @FXML
    private TextField Home1vsAway1set2;
    @FXML
    private TextField Home1vsAway1set3;
    @FXML
    private TextField Home1vsAway2set1;
    @FXML
    private TextField Home1vsAway2set2;
    @FXML
    private TextField Home1vsAway2set3;
    @FXML
    private TextField Home2vsAway1set1;
    @FXML
    private TextField Home2vsAway1set2;
    @FXML
    private TextField Home2vsAway1set3;
    @FXML
    private TextField Home2vsAway2set1;
    @FXML
    private TextField Home2vsAway2set2;
    @FXML
    private TextField Home2vsAway2set3;
    @FXML
    private TextField box_DoubleSet1;
    @FXML
    private TextField box_DoubleSet2;
    @FXML
    private TextField box_DoubleSet3;

    // this will create a new score sheet so the user will enter a new input on the home vs away teams
    @FXML
    private void newScoreSheetButton(ActionEvent event) {
        CreateMatch = null; //reset the match object
        CreateMatch = new Match();
        DoubleSetScoresheetGridPane.setDisable(false);
        SingleSetsScoresheetGridPane.setDisable(false);
        PickTeamButton.setDisable(false);
        Home1vsAway1set1.clear(); //clear Home1vsAway1 set 1
        Home1vsAway1set2.clear(); //clear Home1vsAway1 set 2
        Home1vsAway1set3.clear(); //clear Home1vsAway1 set 3
        Home1vsAway2set1.clear(); //clear Home1vsAway2 set 1
        Home1vsAway2set2.clear(); //clear Home1vsAway2 set 2
        Home1vsAway2set3.clear(); //clear Home1vsAway2 set 3
        Home2vsAway1set1.clear(); //clear Home2vsAway1 set 1
        Home2vsAway1set2.clear(); //clear Home2vsAway1 set 2
        Home2vsAway1set3.clear(); //clear Home2vsAway1 set 3
        Home2vsAway2set1.clear(); //clear Home2vsAway2 set 1
        Home2vsAway2set2.clear(); //clear Home2vsAway2 set 2
        Home2vsAway2set3.clear(); //clear Home2vsAway2 set 3
        box_DoubleSet1.clear(); //clear box Double Set 1
        box_DoubleSet2.clear(); //clear box  Double Set 2
        box_DoubleSet3.clear(); //clear box  Double Set 3

    }
    // this will modify the Scoresheet and will be saved for the user to change things.
    @FXML
    private void modifyScoresheetButton(ActionEvent event) {

        Dialog dialog = new Dialog<>();
        dialog.setTitle("Please choose Scoresheet");
        dialog.setHeaderText("Select the Scoresheet that you wish to modify:");
        dialog.setResizable(true);

        Label scoresheet = new Label("Scoresheet: ");
        ChoiceBox<Match> matchChoiceBox = new ChoiceBox<>(); // selects the match that they want to choose from the choice box
        matchChoiceBox.getItems().setAll(Main.matchList); // the match list is entered here in the match choice box

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        grid.add(scoresheet, 0, 0);
        grid.add(matchChoiceBox, 1, 0);

        dialog.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

        dialog.showAndWait();
        List<String> ValuepointsList = CreateMatch.getpointsfromeachteam();
        String home = "n/a", away = "n/a";
        List<Player> playerListHome = new ArrayList<>();
        List<Player> playerListAway = new ArrayList<>();

        int i = 0;
        while (i < Main.matchList.size()) {
            if (matchChoiceBox.getValue().toString().equals(Main.matchList.get(i).toString())) { //compared chosen object to all in the list to find the chosen team.
                ValuepointsList = Main.matchList.get(i).getpointsfromeachteam();
                home = Main.matchList.get(i).getTeamHome().toString();
                away = Main.matchList.get(i).getTeamAway().toString();
                playerListHome = Main.matchList.get(i).getTeamHome().getPlayers();
                playerListAway = Main.matchList.get(i).getTeamAway().getPlayers();
                choiceAPlayer1.setValue(Main.matchList.get(i).getAPlayer1());
                choiceAPlayer2.setValue(Main.matchList.get(i).getAPlayer2());
                choiceHPlayer1.setValue(Main.matchList.get(i).getHPlayer1());
                choiceHPlayer2.setValue(Main.matchList.get(i).getHPlayer2());
            }
            i++;
        }
        //get all the players from away/home team
        choiceAPlayer1.getItems().setAll(playerListAway);
        choiceAPlayer2.getItems().setAll(playerListAway);
        choiceHPlayer1.getItems().setAll(playerListHome);
        choiceHPlayer2.getItems().setAll(playerListHome);

        //this will set the text where the user picks the team and this will be displayed
        homeTeamLabel.setText(home);
        awayTeamLabel.setText(away);

        //this will get all the score values from the match class
        Home1vsAway1set1.setText(ValuepointsList.get(0));
        Home1vsAway1set2.setText(ValuepointsList.get(1));
        Home1vsAway1set3.setText(ValuepointsList.get(2));
        Home1vsAway2set1.setText(ValuepointsList.get(3));
        Home1vsAway2set2.setText(ValuepointsList.get(4));
        Home1vsAway2set3.setText(ValuepointsList.get(5));
        Home2vsAway1set1.setText(ValuepointsList.get(6));
        Home2vsAway1set2.setText(ValuepointsList.get(7));
        Home2vsAway1set3.setText(ValuepointsList.get(8));
        Home2vsAway2set1.setText(ValuepointsList.get(9));
        Home2vsAway2set2.setText(ValuepointsList.get(10));
        Home2vsAway2set3.setText(ValuepointsList.get(11));
        box_DoubleSet1.setText(ValuepointsList.get(12));
        box_DoubleSet2.setText(ValuepointsList.get(13));
        box_DoubleSet3.setText(ValuepointsList.get(14));

    }

    //this will save the score sheet by pressing the save scoresheet button
    @FXML
    private void saveScoreSheetButton(ActionEvent event) {
        boolean saved = false;
        PickTeamButton.setDisable(true);

        //this will get all the point/score values that was saved and add the score on the specific text box
        List<String> pointValues = new ArrayList<>();
        pointValues.add(Home1vsAway1set1.getText());
        pointValues.add(Home1vsAway1set2.getText());
        pointValues.add(Home1vsAway1set3.getText());
        pointValues.add(Home1vsAway2set1.getText());
        pointValues.add(Home1vsAway2set2.getText());
        pointValues.add(Home1vsAway2set3.getText());
        pointValues.add(Home2vsAway1set1.getText());
        pointValues.add(Home2vsAway1set2.getText());
        pointValues.add(Home2vsAway1set3.getText());
        pointValues.add(Home2vsAway2set1.getText());
        pointValues.add(Home2vsAway2set2.getText());
        pointValues.add(Home2vsAway2set3.getText());
        pointValues.add(box_DoubleSet1.getText());
        pointValues.add(box_DoubleSet2.getText());
        pointValues.add(box_DoubleSet3.getText());

        CreateMatch.setPoints(pointValues);
        CreateMatch.getpointsfromeachteam();
        CreateMatch.joinFixtures();
        CreateMatch.calculateTotal();
        int HPlayer = 0;
        while (HPlayer < CreateMatch.getTeamHome().getPlayers().size()) {
            if (CreateMatch.getTeamHome().getPlayers().get(HPlayer).toString().equals(choiceHPlayer1.getValue().toString())) {
                CreateMatch.setPlayers("home", 1, CreateMatch.getTeamHome().getPlayers().get(HPlayer));
            }
            if (CreateMatch.getTeamHome().getPlayers().get(HPlayer).toString().equals(choiceHPlayer2.getValue().toString())) {
                CreateMatch.setPlayers("home", 2, CreateMatch.getTeamHome().getPlayers().get(HPlayer));
            }
            HPlayer++;
        }
        int APlayer = 0;
        while (APlayer < CreateMatch.getTeamAway().getPlayers().size()) {
            if (CreateMatch.getTeamAway().getPlayers().get(APlayer).toString().equals(choiceAPlayer1.getValue().toString())) {
                CreateMatch.setPlayers("away", 1, CreateMatch.getTeamAway().getPlayers().get(APlayer));
            }
            if (CreateMatch.getTeamAway().getPlayers().get(APlayer).toString().equals(choiceAPlayer2.getValue().toString())) {
                CreateMatch.setPlayers("away", 2, CreateMatch.getTeamAway().getPlayers().get(APlayer));
            }
            APlayer++;
        }

        int i = 0;
        while (i < Main.matchList.size()) {
            System.out.println((Main.matchList.get(i).toString() + " " + CreateMatch.toString()));
            if (Main.matchList.get(i).toString().equals(CreateMatch.toString())) {
                Main.matchList.set(i, CreateMatch);
                saved = true;
                System.out.println("This is saving to existing scoresheet");
            }
            i++;
        }

        if (!saved) {
            System.out.println("A new scoresheet has been added");
            Main.matchList.add(CreateMatch);
            saved = true;
        }


        if (saved) {
            System.out.println("The Match of this game has been saved");
        }

    }

    // this is a button where the user can pick/choose the team they want for home vs away team.
    @FXML
    private void PickTeamButton(ActionEvent event) {
        Dialog dialog = new Dialog<>();
        dialog.setTitle("Team");
        dialog.setHeaderText("Please pick a home and away team:");
        dialog.setResizable(true);

        Label Home = new Label("Home: ");
        Label Away = new Label("Away: ");
        ChoiceBox<Team> homeChoice = new ChoiceBox<>();
        homeChoice.getItems().setAll(Main.teamList);
        ChoiceBox<Team> awayChoice = new ChoiceBox<>();
        awayChoice.getItems().setAll(Main.teamList);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        grid.add(Home, 0, 0);
        grid.add(homeChoice, 1, 0);
        grid.add(Away, 0, 1);
        grid.add(awayChoice, 1, 1);
        dialog.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

        dialog.showAndWait();

        int HomeChoice = 0;
        while (HomeChoice < Main.teamList.size()) {
            if (homeChoice.getValue().toString().equals(Main.teamList.get(HomeChoice).toString())) { //compared chosen object to all in the list to find the chosen team.
                CreateMatch.setTeamHome(Main.teamList.get(HomeChoice));
            }
            HomeChoice++;
        }
        int AwayChoice = 0;
        while (AwayChoice < Main.teamList.size()) {
            if (awayChoice.getValue().toString().equals(Main.teamList.get(AwayChoice).toString())) { //compared chosen object to all in the list to find the chosen team.
                CreateMatch.setTeamAway(Main.teamList.get(AwayChoice));
            }
            AwayChoice++;
        }

        //This will get all the information for each team and will set an Away/Home team from the user's pick
        homeTeamLabel.setText(CreateMatch.getTeamHome().toString());
        awayTeamLabel.setText(CreateMatch.getTeamAway().toString());
        choiceAPlayer1.getItems().setAll(CreateMatch.getTeamAway().getPlayers());
        choiceAPlayer2.getItems().setAll(CreateMatch.getTeamAway().getPlayers());
        choiceHPlayer1.getItems().setAll(CreateMatch.getTeamHome().getPlayers());
        choiceHPlayer2.getItems().setAll(CreateMatch.getTeamHome().getPlayers());

    }

    //this is to calculate all the scores from the sets of home vs away matches - this will be displayed on the viewer page
    @FXML
    private void CalculateScoresButton(ActionEvent event) {

        CreateMatch.getFixtures().homeTeam.expandMatchesPlayed();
        CreateMatch.getFixtures().awayTeam.expandMatchesPlayed();
        if (CreateMatch.getFixtures().CalculateWhoWon().equals(CreateMatch.getFixtures().homeTeam.toString())) {
            CreateMatch.getFixtures().homeTeam.expandMatchesWon();
            System.out.println("Home won this game");
        }
        if (CreateMatch.getFixtures().CalculateWhoWon().equals(CreateMatch.getFixtures().awayTeam.toString())) {
            CreateMatch.getFixtures().awayTeam.expandMatchesWon();
            System.out.println("Away won this game");

            // this will save the match when user pressed the save score sheet and ot will reset the sets won from Home/Away
            saveScoreSheetButton(event);
            CreateMatch.getTeamHome().resetwonSets();
            CreateMatch.getTeamAway().resetwonSets();
            CreateMatch.calculateTotal();
        }
    }

    // ------------- All of this is used for the Viewer page ----------------------

    @FXML
    private TextArea viewpageresultField; // this is where all the information is stored when pressed on the view buttons

    @FXML
    private void FixtureandresultsButton(ActionEvent event)  // this will view the fixtures when the User presses view result and fixtures button
    {
        StringJoiner joiner = new StringJoiner("\n");
        int RF = 0;
        while (RF < Main.fixtureList.size()) {
            joiner
                    .add(Main.fixtureList.get(RF).toString() + " Score:  "
                            + Main.fixtureList.get(RF).getHomeScore()
                            + "-"
                            + Main.fixtureList.get(RF).getAwayScore())
                    .add("The Winner of this game is: " + Main.fixtureList.get(RF).CalculateWhoWon()) // this will get the winner from the fixture list
                    .add("\n");
            RF++;
        }

        viewpageresultField.setText("\n" + joiner.toString());
    }

    @FXML
    private void teamStatisticsButton(ActionEvent event) // this will view the fixtures when the User presses view show all team stats
    {
        StringJoiner joiner = new StringJoiner("\n");
        int i = 0;
        while (i < Main.teamList.size()) {
            joiner
                    .add("Team: " + Main.teamList.get(i).toString() + "  →  "
                            + "  Here are the Matches been Played:   " + Main.teamList.get(i).getMatchesPlayed()
                            + "  Here are the Matches that Won: " + Main.teamList.get(i).getMatchesWon()
                            + "  Here are the Sets that Won: " + Main.teamList.get(i).getsetsWon());

            i++;
        }

        viewpageresultField.setText("\n" + joiner.toString());
    }



    @FXML
    private void RankingsofEachteamButton(ActionEvent event)  // this will show the team ranks when pressed on the button
    {
        List<Team> rankingList = Main.teamList;
        // this will compare the teams by the sets 1 and sets 2
        Comparator<Team> bySetsWon = (sets1, sets2) -> Integer.compare(sets2.getsetsWon(), sets1.getsetsWon());
        StringJoiner joiner = new StringJoiner("\n");
        rankingList.sort(bySetsWon); // this will sort out the list ranked by the sets won
        // team list is incremented by 1
        int team = 0;
        while (team < Main.teamList.size()) {
            joiner.add((team + 1)
                    + ".  Team: " + Main.teamList.get(team).toString()
                    + "  Sets won: " + Main.teamList.get(team).getsetsWon());
            team++;
        }
        viewpageresultField.setText("\n" + joiner.toString());

    }

    @FXML
    private void viewmatchScoresButton(ActionEvent event)  // this will set the matches scores and will let the user pick the match they wanna see
    {
        Dialog dialog = new Dialog<>();
        dialog.setTitle("Pick a Match");
        dialog.setHeaderText("Please choose a match result for which you'd like to see:");
        dialog.setResizable(true);

        Label match = new Label("Match: ");
        ChoiceBox<Match> matchChoiceBox = new ChoiceBox<>();
        matchChoiceBox.getItems().setAll(Main.matchList); // this will get all the matches that have been placed on the choice box

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        grid.add(match, 0, 0);
        grid.add(matchChoiceBox, 1, 0);

        dialog.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

        dialog.showAndWait();
        StringJoiner joiner = new StringJoiner("\n");
        StringJoiner joiner2 = new StringJoiner(" ");
        StringJoiner joiner3 = new StringJoiner(" ");
        StringJoiner joiner4 = new StringJoiner(" ");
        StringJoiner joiner5 = new StringJoiner(" ");
        StringJoiner joiner6 = new StringJoiner(" ");
        int i = 0;
        while (i < Main.matchList.size()) {
            if (matchChoiceBox.getValue().toString().equals(Main.matchList.get(i).toString())) {
                joiner.add("Match:  " + Main.matchList.get(i).toString())
                        .add(" ★ Here are the Single sets: ");
                List<String> set = Main.matchList.get(i).getSet(1);
                joiner2.add("1: ");
                joiner2.add(Main.matchList.get(i).getHPlayer1() + " against " + Main.matchList.get(i).getAPlayer1() + " : ");
                {
                    int sets = 0;
                    while (sets < 3) {
                        joiner2.add(set.get(sets));
                        sets++;
                    }
                }
                joiner.add(joiner2.toString());

                set = Main.matchList.get(i).getSet(2);
                joiner3.add("2: ");
                joiner3.add(Main.matchList.get(i).getHPlayer1() + " against " + Main.matchList.get(i).getAPlayer2() + " : ");
                {
                    int sets = 0;
                    while (sets < 3) {
                        joiner3.add(set.get(sets));
                        sets++;
                    }
                }
                joiner.add(joiner3.toString());

                set = Main.matchList.get(i).getSet(3);
                joiner4.add("3: ");
                joiner4.add(Main.matchList.get(i).getHPlayer2() + " against " + Main.matchList.get(i).getAPlayer1() + " : ");
                {
                    int sets = 0;
                    while (sets < 3) {
                        joiner4.add(set.get(sets));
                        sets++;
                    }
                }
                joiner.add(joiner4.toString());

                set = Main.matchList.get(i).getSet(4);
                joiner5.add("4: ");
                joiner5.add(Main.matchList.get(i).getHPlayer2() + " against " + Main.matchList.get(i).getAPlayer2() + " : ");
                {
                    int sets = 0;
                    while (sets < 3) {
                        joiner5.add(set.get(sets));
                        sets++;
                    }
                }
                joiner.add(joiner5.toString());

                joiner.add("  ★ Here are the Double Sets: ");
                set = Main.matchList.get(i).getSet(5);
                joiner6.add("Double set: ");
                joiner6.add("(" + Main.matchList.get(i).getHPlayer1() + " & " + Main.matchList.get(i).getHPlayer2() + ")"
                        + "  against  " + "(" + Main.matchList.get(i).getAPlayer1() + " and " + Main.matchList.get(i).getAPlayer2() + ")" + " : ");
                int sets = 0;
                while (sets < 3) {
                    joiner6.add(set.get(sets));
                    sets++;
                }
                joiner.add(joiner6.toString());
                joiner.add("The final result is: " + Main.matchList.get(i).getTeamHome().getsetsWon() + " : " + Main.matchList.get(i).getTeamAway().getsetsWon());

            }
            i++;
        }
        viewpageresultField.setText("\n" + joiner.toString());

    }
}