module FXML {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.base;
	
	opens App to javafx.graphics, javafx.fxml, javafx.base;
	exports App;
}
