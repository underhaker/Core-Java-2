package webcrawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import sun.net.www.http.HttpClient;

public class WebCrawler {
    private static ArrayList<String> used = new ArrayList<>();
    // private static String used="";
    private static URL urlHome;
    private static boolean isUrlHome;

    private static String getContent(URI uri) throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        return responseString;
    }

    private static List<String> getAllLinks(String content) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }

    public static void webCrawler(URL url, String needle) throws ClientProtocolException, IOException,
            URISyntaxException {
        if (isUrlHome == false) {
            urlHome = url;
            isUrlHome = true;
        }
        String urlContent = getContent(url.toURI());
        used.add(url.toString());
        if (urlContent.contains(needle) == true) {
            System.out.println(url);
            System.exit(0);
        } else {
            List<String> links = getAllLinks(urlContent);
            for (int i = 0; i < links.size(); i++) {
                URL urlLink = new URL(url, links.get(i));
                if (used.contains(urlLink.toString()) == false
                        && urlLink.toString().contains(urlHome.getHost()) == true)
                    webCrawler(urlLink, needle);
            }
        }
        // }
    }

    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        URL url = new URL(args[0]);
        String needle = args[1];
        try {
            webCrawler(url, needle);
            // System.out.println(getContent(uri));
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
