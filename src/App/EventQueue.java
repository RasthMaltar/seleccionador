package App;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class EventQueue implements Initializable{
	
	private Media media;
	private MediaPlayer mediaPlayer;
	private File archivo;
	private File[] musica;
	private int n;
	private FadeTransition Fade;
	
	private List<File> ruta;
	@FXML
	private Button connect;
	@FXML
	private ImageView Imagen;
	@FXML
	private ChoiceBox<String> Empresa;
	@FXML
	private Label genero;
	@FXML
	private ChoiceBox<String> Marca;
	@FXML
	private Button NextSong;
	@FXML
	private Button Mute;
	public Image imagen;
	
	
	public void Prendido(ActionEvent e) {
		String empresa = Empresa.getValue() == null ? "Empresa no seleccionada" : Empresa.getValue();
		String marca = Marca.getValue() == null ? "???" : Marca.getValue();
		genero.setText(empresa+", "+marca);
		prueba();
		Fade.play();
	}

	public void setMarca(ActionEvent e) {
		if(!Marca.getItems().isEmpty()) {
			Marca.getItems().clear();
		}
		if(Empresa.getValue() != null) {
			switch (Empresa.getValue()) {
			case "Toyota":
				Marca.getItems().addAll(Cars.Toyota);
				break;
			case "Mazda":
				Marca.getItems().addAll(Cars.Mazda);
				break;
			case "Ford":
				Marca.getItems().addAll(Cars.Ford);
				break;
			case "Dodge":
				Marca.getItems().addAll(Cars.Dodge);
				break;
			}
		}
	}
	
	public void setImage(String url, boolean verificacion) {
		if(verificacion) {
		imagen = new Image(getClass().getResourceAsStream("/"+url+".png"));
		} else {
			imagen = new Image(getClass().getResourceAsStream("/Question.png"));
		}
		Imagen.setImage(imagen);
	}
	
	public void prueba() {
		if(Empresa.getValue() != null) {
		List<String> hola = Cars.Empresario.get(Empresa.getValue());
		// Prueba
		boolean xd = hola.contains(Marca.getValue());
		setImage(Empresa.getValue()+" "+Marca.getValue(), xd);
		}
	}
	
	public void Mute() {
		if(!mediaPlayer.isMute()) {
			mediaPlayer.setMute(true);
		} else {
			mediaPlayer.setMute(false);
		}
	}
	
	public void NextSong() {
		if(n < ruta.size() - 1) {
			mediaPlayer.stop();
			n++;
			media = new Media(ruta.get(n).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaPlayer.play();
		} else {
			mediaPlayer.stop();
			n = 0;
			media = new Media(ruta.get(n).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaPlayer.play();
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Fade = new FadeTransition();
		Fade.setNode(Imagen);
		Fade.setFromValue(0);
		Fade.setInterpolator(Interpolator.EASE_OUT);
		Fade.setDuration(Duration.millis(500));
		Fade.setToValue(1);
		
		ruta = new ArrayList<>();
		archivo = new File("Archivo");
		musica = archivo.listFiles();
		
		for(File f : musica) {
			ruta.add(f);
			System.out.println(f);
		}
		
		media = new Media(ruta.get(n).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setVolume(0.5);
		Empresa.getItems().addAll(Cars.Empresa);
		Empresa.setOnAction(this::setMarca);
		Marca.setOnAction(this::Prendido);
	}
}
