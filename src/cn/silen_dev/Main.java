package cn.silen_dev;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        new DownloadCaptcha().download(1000);
        File parentFile=new File("captcha/data");
        ImageUtils imageUtils=new ImageUtils();
        for (File file:parentFile.listFiles()){
            ImageIO.write(ImageIO.read(file),"jpg",new File(file.getParentFile().getParent()+"/out/"+imageUtils.recognize(file)+".jpg"));
            //imageUtils.whiteImage(imageUtils.spiltImage(imageUtils.removeBackgroudColor(file)),file);
        }
    }
}
