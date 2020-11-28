package sample;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpenBrowserUrl {
    private final String url;

    public OpenBrowserUrl(String url) {
        this.url = url;


    }
    public void run(){
        try {
            // TODO add your handling code here:
            Desktop.getDesktop().browse(new URL(this.url).toURI());
        } catch (IOException ex) {
            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    }



