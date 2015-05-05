package testwebcrawler;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;

import webcrawler.WebCrawler;

public class TestWebCrawler {
    URL url;
    String needle;
    @Before
    public void init() throws IOException{
        
    }
    @Test
    public void testCase1() throws ClientProtocolException, IOException, URISyntaxException {
        url=new URL("http://ebusiness.free.bg");
        needle=new StringBuilder("Револвиращa").toString();
        WebCrawler.webCrawler(url, needle);
    }

}
