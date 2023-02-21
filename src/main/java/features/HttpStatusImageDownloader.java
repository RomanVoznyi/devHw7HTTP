package features;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import java.io.*;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws HttpStatusException {
        HttpStatusChecker checker = new HttpStatusChecker();
        String path = ".\\src\\main\\java\\images\\cat";

        try {
            String url = checker.getStatusImage(code);
            byte[] image = Jsoup.connect(url).ignoreContentType(true).execute().bodyAsBytes();

            FileOutputStream out = new FileOutputStream(path + code + ".jpeg");
            out.write(image);
            out.close();

        } catch (HttpStatusException ex) {
            throw new HttpStatusException("Such picture does not exist", 404, ex.getUrl());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
