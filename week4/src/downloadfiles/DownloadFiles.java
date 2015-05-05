package downloadfiles;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadFiles {
    public static void download(String fileURL) throws IOException{
        String fileName=fileURL.substring(fileURL.lastIndexOf("/")+1,fileURL.length());
        URL url=new URL(fileURL);
        System.out.println(fileName);
        byte[] buf= new byte[1024];
        int n=0;
        try(InputStream in = new BufferedInputStream(url.openStream());ByteArrayOutputStream out = new ByteArrayOutputStream();FileOutputStream fos=new FileOutputStream(fileName);){
            while(-1!=(n=in.read(buf))){
                out.write(buf,0,n);
            }
            byte[] response= out.toByteArray();
            fos.write(response);
        }
    }
    public static void main(String[] args) {
        try {
            download("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
