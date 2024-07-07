import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import controllers.Controller;
import framework.ScenicApplication;
import framework.ScenicLoader;
import framework.ScenicStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Model;
import services.CredentialService;
import views.BaseView;
import views.TestingView;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

/**
 * Entrypoint class
 *
 *  <p>SafeLake is an app made in JavaFX to showcase lake pollution data</p>
 * @author Tamim, Maya
 * */
public class SafeLake extends ScenicApplication {
    /**
     * Main function
     *
     * <p>Creates the needed MVC elements and runs them as needed</p>
     * @param args The run arguments, are unused
     * */
    public static void run(String[] args) {
        launch(args);
    }


    @Override
    public void scenicStart(ScenicStage stage) {
        try {
            ScenicLoader.setFxmlFilePath("/fxml/");
            String[] pages = {"Home", "Map", "Sources", "About"};
            for (String page : pages) {
                ScenicLoader scenicLoader = new ScenicLoader(page);
                stage.addScene(scenicLoader);
            }
            stage.setScene("Home");
            stage.setTitle("SafeLake");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
