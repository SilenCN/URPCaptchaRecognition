package cn.silen_dev;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by silen on 16-12-11.
 */
public class DownloadCaptcha {
    public static int JPG_NUMBER=0;
    public void download(int size) throws IOException {
        for (int i = 0; i < size; i++) {
            new DownloadCaptcha().download("http://115.24.160.162/validateCodeAction.do?random=0.5770691348483092");
        }
    }
    private void download(String path) throws IOException {
        URL url = new URL(path);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setConnectTimeout(2000);
        if (httpURLConnection.getResponseCode() == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            File file=new File("captcha/data/" +(JPG_NUMBER++)+ ".jpg");
            System.out.println(file.getAbsolutePath());
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(file);
            int byteInt = 0;
            while ((byteInt = inputStream.read()) != -1)
                outputStream.write(byteInt);
            inputStream.close();
            outputStream.close();
        }
        httpURLConnection.disconnect();
    }
}
