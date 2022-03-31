package com.rest.dto;
import java.awt.Image;
import java.awt.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import twitter4j.MediaEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TweetsDemo2 {
public static void main(String[] args) {
/*final String CONSUMER_KEY = "5rcI37xurBl17PBezmHAJTcL3";
final String CONSUMER_SECRET = "BUtdYINYImznyLOa0Z0goXMQku96EqJzKA7GuSvy0u9XEBQKP2";
   final String ACCESS_TOKEN = "1082907901218443265-IQHmbQdtjrsge59NkZ5ug8hZaeRy6N";
final String ACCESS_TOKEN_SECRET = "qJcPbZ4mtL1kEzfgnkdQ1qFwEh00tewLjiigG4YXgsjc0";*/

TweetsDemo2 t = new TweetsDemo2();
try {
TweetsDemo2.searchTweets(getTwitterInstance(), "#maldives");
} catch (TwitterException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}


}

public static Twitter getTwitterInstance() {
   ConfigurationBuilder cb = new ConfigurationBuilder();
   cb.setDebugEnabled(true)
   .setOAuthConsumerKey("5rcI37xurBl17PBezmHAJTcL3")
   .setOAuthConsumerSecret("BUtdYINYImznyLOa0Z0goXMQku96EqJzKA7GuSvy0u9XEBQKP2")
   .setOAuthAccessToken("1082907901218443265-IQHmbQdtjrsge59NkZ5ug8hZaeRy6N")
   .setOAuthAccessTokenSecret( "qJcPbZ4mtL1kEzfgnkdQ1qFwEh00tewLjiigG4YXgsjc0");

   TwitterFactory tf = new TwitterFactory(cb.build());
   return tf.getInstance();
}

static void searchTweets(Twitter twitter, String searchTerm) throws TwitterException {
	

   Query query = new Query("source:" + searchTerm);
   //System.out.println(query.toString());
   QueryResult result = twitter.search(query);
   for (Status status : result.getTweets()) {
MediaEntity[] media = status.getMediaEntities();
ArrayList<MediaEntity> a = new ArrayList<MediaEntity>();

for(MediaEntity m : media){
	a.add(m);
}
System.out.println(a);


}
/*Image image = null;
try {
URL url = new URL(m.getMediaURL());
try {
image = ImageIO.read(url);
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
} catch (MalformedURLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} 
JFrame frame = new JFrame();
       frame.setSize(300, 300);
       JLabel label = new JLabel(new ImageIcon(image));
       frame.add(label);
       frame.setVisible(true);
}
}

   /*for (Status status : result.getTweets()) {
       System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
   }*/

}
}



