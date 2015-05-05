package sna;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hsqldb.types.Charset;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * Servlet implementation class SimpleNewsAgregator
 */
@WebServlet("/")
public class SimpleNewsAgregator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleNewsAgregator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String message;
        try {
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
            message = getRSSFeed(new URL("http://www.sportal.bg/uploads/rss_category_8.xml"));
            request.setAttribute("message",message);
            request.getRequestDispatcher("/WEB-INF/show.jsp").forward(request, response);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FeedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	
	}
	public static String getRSSFeed(URL url) throws IOException, IllegalArgumentException, FeedException{
	    HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();
	    SyndFeedInput input = new SyndFeedInput();
	    SyndFeed feed = input.build(new XmlReader(httpcon));
//	    feed.setEncoding("UTF-8");
	    List entries = feed.getEntries();
        Iterator itEntries = entries.iterator();
        String title,link,text,txtImg,txtText;
        String message="";
        while (itEntries.hasNext()) {
            SyndEntry entry = (SyndEntry) itEntries.next();
            title=new StringBuilder(entry.getTitle()).toString();
            link=new StringBuilder("<p><a href=\""+entry.getLink()+"\"> " + title + "</a></p>").toString();
            text=new StringBuilder(entry.getDescription().getValue()).toString();
            txtImg=new StringBuilder("<p>" + text.substring(0, text.indexOf("/>")+2) + "</p>").toString();
            txtText=new StringBuilder("<p>" + text.substring(text.lastIndexOf("/>")+2, text.length()) + "</p>").toString();
            message +=new StringBuilder(String.format("%s%n%s%n%s%n",link,txtImg,txtText)).toString();
        }
        return message;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
    

}
