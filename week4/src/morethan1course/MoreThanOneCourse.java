package morethan1course;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class MoreThanOneCourse {
    private static String getContent(URI uri) throws ClientProtocolException, IOException{
        CloseableHttpClient client=HttpClients.createDefault();
        HttpGet httpGet= new HttpGet(uri);
        CloseableHttpResponse response= client.execute(httpGet);
            HttpEntity entity=response.getEntity();
            String responseString = EntityUtils.toString(entity,"UTF-8");
            httpGet.releaseConnection();
            return responseString;
    }
    public static void printVisits() throws URISyntaxException, ClientProtocolException, IOException, JSONException{
        URI uri=new URI("https://hackbulgaria.com/api/students/");
        String content=getContent(uri);
        JSONArray jar = new JSONArray(content);
        JSONObject j;
        JSONArray jar1;
        int counter=0;
        for(int i=0; i<jar.length(); i++){
            j=jar.getJSONObject(i);
            jar1=j.getJSONArray("courses");
            if(jar1.length()>1){
                System.out.print(++counter + "." + j.getString("name") + ":");
                JSONObject jc;
                for(int k=0; k<jar1.length(); k++){
                    jc=new JSONObject(jar1.getString(k));
                    System.out.print(jc.getString("name"));
                    if(k!=jar1.length()-1)System.out.print(", ");
                }
                System.out.println();
            }
        }
    }
    public static void printCheckins() throws URISyntaxException, ClientProtocolException, IOException, JSONException{
        URI uri=new URI("https://hackbulgaria.com/api/checkins/");
        String content = getContent(uri);
        JSONArray jar = new JSONArray(content);
        JSONObject j;
        Map<String,Integer> hm=new HashMap<String,Integer>();
        Set<String> hs=new HashSet<String>();
        for(int i=0; i<jar.length(); i++){
            j=jar.getJSONObject(i);
            hs.add(j.getString("student_name"));
        }
        for(String student: hs){
            int counter=0;
            for(int i=0; i<jar.length(); i++){
                j=jar.getJSONObject(i);
                if(student.equals(j.getString("student_name")))counter++;
            }
            hm.put(student, counter);
        }
        ValueComparator vc= new ValueComparator(hm);
        TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(vc);
        sortedMap.putAll(hm);
        int count=0;
        for(Map.Entry<String,Integer> entry : sortedMap.entrySet()){
            System.out.println(++count + "." + entry.getKey() + ":" + entry.getValue());
        }
    }
    public static void main(String[] args){
                try {
                    printCheckins();
                    //printVisits();
                } catch (ClientProtocolException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
    }
}

