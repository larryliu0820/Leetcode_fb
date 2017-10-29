import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Larry Liu on 10/28/2017.
 * 535. Encode and Decode TinyURL
 */
public class p535 {
    Map<String, String> long2Short = new HashMap<>();
    Map<String, String> short2Long = new HashMap<>();
    Random rand = new Random();
    char[] base62 = "abvdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    String prefix = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder encoded = new StringBuilder();
        if (!long2Short.containsKey(longUrl)) {
            for (int i = 0; i < 6; i++) encoded.append(base62[rand.nextInt(62)]);
            if (short2Long.containsKey(encoded.toString())) return encode(longUrl);
            else {
                long2Short.put(longUrl, encoded.toString());
                short2Long.put(encoded.toString(), longUrl);
            }
        }
        return prefix + long2Short.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String encoded = shortUrl.split(prefix)[1];
        return short2Long.get(encoded);
    }
}
