package management;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class SoundManager {
    private static SoundManager instance;
    private String[] musicList;
    private MediaPlayer mediaPlayer;
    private boolean loop = false;

    public SoundManager(boolean loop){
        musicList = new String[10];
        this.loop = loop;
        musicList[0] = "../2d-monopoly/src/vendor/sound/mainmenu.mp3";
        musicList[1] = "../2d-monopoly/src/vendor/sound/gamemenu.mp3";
        musicList[2] = "../2d-monopoly/src/vendor/sound/dice.mp3";
        musicList[3] = "../2d-monopoly/src/vendor/sound/money.mp3";
    }

    public static void deleteInstance(){
        instance = null;
    }

    public static SoundManager getInstance(){
        if(instance == null)
            instance = new SoundManager(true);
        return instance;
    }

    public void music(int whichMusic){
        //String music = musicList[whichMusic];
        //Media h = new Media(Paths.get(music).toUri().toString());
        //mediaPlayer = new MediaPlayer(h);
        //if(loop)
        //    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        //mediaPlayer.play();
    }

    public void stopMusic(){
        //mediaPlayer.stop();
    }

    public void pauseMusic(){
        //mediaPlayer.pause();
    }

    public void continueMusic(){
        //mediaPlayer.play();
    }

    public MediaPlayer getMediaPlayer(){
        return mediaPlayer;
    }
}
