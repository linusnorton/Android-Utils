package norton.android.util.comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Wrapper for the org.apache.http comms classes, returns a String inside of 
 * an endless amount of objects.
 */
public class HttpComms {
	private DefaultHttpClient client;
	
	public HttpComms() {
		client = new DefaultHttpClient();               
	}
	
	public String get(String url) throws ClientProtocolException, IOException {
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);  
		
		return this.getText(response);
	}

	private String getText(HttpResponse response) throws IOException {
        InputStreamReader isr = new InputStreamReader(response.getEntity().getContent());
        Reader in = new BufferedReader(isr);

        StringBuffer buf = new StringBuffer();
        int ch;
        while ((ch = in.read()) > -1) {
            buf.append((char)ch);
        }
        in.close();
        return buf.toString();
    }
	
}
