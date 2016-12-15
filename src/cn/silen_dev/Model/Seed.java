package cn.silen_dev.Model;

import java.awt.image.BufferedImage;

/**
 * Created by silen on 16-12-11.
 */
public class Seed {
    private BufferedImage bufferedImage;
    private char value;

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
