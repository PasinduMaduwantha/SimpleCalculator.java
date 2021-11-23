/*
 * DATE       : 23-11-2021
 * COURSE     : PROGRAMMING QUEST (CO2210)
 * TITLE      : QUEST 08 - SIMPLE CALCULATOR WITH GUI
 * AUTHOR     : MADHUWANTHA A.P.
 * INDEX NO   : 19/ENG/121
 */
package project.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            //make a root for FXMLLoader
            Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
            //set the size of the window
            primaryStage.setScene(new Scene(root, 400, 600));
            //set the title of the window
            primaryStage.setTitle("Calculator");
            primaryStage.show();    //show the window

        }
        catch (Exception e){
            System.out.println("Error! in Main.java");  //error message
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
