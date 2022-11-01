package application;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sonidos {

    File fondo = new File("intro.wav");
    String sfondo = "file:///"+fondo.getAbsolutePath();

    MediaPlayer mediaplayer;

    public void sonidofondo() {
        sfondo = sfondo.replace("\\", "//");
        Media musicFile =  new Media (sfondo);

        mediaplayer = new MediaPlayer(musicFile);
        mediaplayer.play();
    }

}