package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMain {
    private final Stage reservaStage = new Stage();
    @FXML
    private Button YoutubeImageButton;

    @FXML
    private ImageView YoutubeImageView;

    @FXML
    private Button TwitterImageButton;

    @FXML
    private ImageView TwitterImageView;

    @FXML
    private Button rssImageButton;

    @FXML
    private ImageView rssImageView;

    @FXML
    private VBox ReservarButtonVBox;

    @FXML
    private Button ReservaButton;

    @FXML
    private VBox WebButtonVBox;

    @FXML
    private Button WebButton;

    @FXML
    private Button facebookImageView;

    @FXML
    private ImageView facebookButton;

    @FXML
    private Button facebookImageButton;

    @FXML
    private ImageView instagramImageView;

    @FXML
    private Button PinterestImageButton;

    @FXML
    private ImageView PinteresImageView;

    @FXML
    private HBox Palacio1Hbox;

    @FXML
    private ImageView Palacio1ImageView;

    @FXML
    private HBox Palacio2HBox;

    @FXML
    private ImageView Palacio2ImageView;
    @FXML
    private void twitterButtonClick(ActionEvent event)
    {new OpenBrowserUrl("https://twitter.com/turismoNavarra").run(); }
    @FXML
    private void facebookButtonClick(ActionEvent event)
    {new OpenBrowserUrl("https://www.facebook.com/visitnavarra").run(); }
    @FXML
    private void youtubeButtonClick(ActionEvent event)
    {new OpenBrowserUrl("https://www.youtube.com/visitnavarra").run(); }
    @FXML
    private void instagramButtonClick(ActionEvent event)
    {new OpenBrowserUrl("https://www.instagram.com/visitnavarra/").run(); }
    @FXML
    private void webButtonClick(ActionEvent event)
    {new OpenBrowserUrl("https://www.turismo.navarra.es/esp/organice-viaje/recurso/Patrimonio/3154/Palacio-de-los-Reyes-de-Navarra.html").run(); }
    @FXML
    private void rssButtonClick(ActionEvent event)
    {new OpenBrowserUrl("https://www.turismo.navarra.es/esp/fijos/rss").run(); }
    @FXML
    private void pinterestButtonClick(ActionEvent event)
    {new OpenBrowserUrl("https://www.pinterest.es/turismonavarra/").run(); }

    private void openWindowModal(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Second.fxml"));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("style1.css").toExternalForm());
            this.reservaStage.setScene(scene);
            this.reservaStage.initModality(Modality.APPLICATION_MODAL);

        }catch (IOException io){
            io.printStackTrace();
        }catch (IllegalStateException ea ){
            this.reservaStage.showAndWait();

        }
    }
    @FXML
    private void ReservaOnClick(ActionEvent event){
        openWindowModal();
        this.reservaStage.showAndWait();

    }

    }

