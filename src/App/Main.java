package App;
	
import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(@SuppressWarnings("exports") Stage primaryStage) {
		try {
			Parent root = setFXML("Main.fxml");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Parent setFXML(String fxml) throws IOException{
		FXMLLoader root = new FXMLLoader(Main.class.getResource("/"+fxml));
		return root.load();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
