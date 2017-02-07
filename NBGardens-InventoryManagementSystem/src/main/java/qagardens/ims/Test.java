package qagardens.ims;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;

public class Test {
	public static void main(String[] args) {
		JsonObject object = Json.createObjectBuilder().
				add("stock", Json.createObjectBuilder().
					add("id", 1).
					add("name", "gnome").
					add("status", "PROCESSING").
					add("dateAdded", "").
					add("level", "0")).
				build();
		
		JsonParser parser = Json.createParser(new StringReader(object.toString()));
		while(parser.hasNext()){
			System.out.println(parser.next());
		}
	}
}
