package jtoaster;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;

public class JToaster {

        public static void notification() throws IOException, InterruptedException{
        Toaster toaster=new Toaster();
        toaster.setToasterWidth(900);
        toaster.setToasterHeight(600);
        URL url=new URL("http://oi60.tinypic.com/8vw6e8.jpg");
        Image img=ImageIO.read(url);
        toaster.setBackgroundImage(img);
        toaster.setStep(5);
        toaster.setStepTime(10);
        toaster.setDisplayTime(5*60*1000);
        while(true){
        toaster.showToaster("Get a little rest, will you?");
        Thread.sleep(45*60*1000);
        }
    }
    public static void main(String[] args) {
        try {
            notification();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
