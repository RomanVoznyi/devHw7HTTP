package features;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws HttpStatusException {
        String url = "https://http.cat/" + code;

        try {
            Jsoup.connect("https://http.cat/" + code).ignoreContentType(true).get();
            return url;
        } catch (HttpStatusException ex) {
            throw new HttpStatusException("Such picture does not exist", 404, url);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
