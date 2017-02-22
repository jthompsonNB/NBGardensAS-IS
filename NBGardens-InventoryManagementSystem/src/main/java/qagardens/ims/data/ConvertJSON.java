package qagardens.ims.data;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import com.google.gson.Gson;
import com.qac.util.logging.Loggable;

import qagardens.ims.service.entities.Stock;

/**
 * 
 * @author James Thompson
 */
@Loggable
@Stateless
public class ConvertJSON {
	@Inject private Logger logger;

	/**
	 * Converts the provided entity into a JSON object. 
	 * If the Entity Contains another entity or a list of entities it will recursively call itself to add each one to the JSON Object.
	 * 
	 * @param entity - The Entity to convert
	 * @return
	 */
	public JsonObject buildJsonObject(Object entity) {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		for(Field f : entity.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if(f.getType().toString().contains("List")) {
					logger.fine("Converting a Java List into JSON");
					JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
					METHOD:for(Method m : entity.getClass().getDeclaredMethods()) {
						if(m.getName().toLowerCase().endsWith(f.getName()) && m.getName().startsWith("get")) {
							List<Object> objects = (List<Object>) m.invoke(entity);
							for(Object object : objects)
								arrayBuilder.add(buildJsonObject(object));
							break METHOD;
						}
					}
					builder.add(f.getName(), arrayBuilder);
				} else {
					if(f.getType().isPrimitive() || f.getType().isEnum() || f.getType().toString().contains("java")) {
						logger.fine("Converting a primitive/enum/Standard Java Library Class into a JSON Key/Value pair");
						builder.add(f.getName(), getFieldValue(f, entity));
					}else {
						logger.fine("Converting another Object into JSON");
						METHOD:for(Method m : entity.getClass().getDeclaredMethods()) {
							if(m.getName().toLowerCase().endsWith(f.getName()) && m.getName().startsWith("get")) {
								builder.add(f.getName(), buildJsonObject(m.invoke(entity)));
								break METHOD;
							}
						}
					}
				}
			} catch(IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
				logger.severe("Failed to access field " + f.getName());
				e.printStackTrace();
			}
		}
		return builder.build();
	}

	private String getFieldValue(Field f, Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for(Method m : object.getClass().getDeclaredMethods())
			if(m.getName().toLowerCase().endsWith(f.getName()) && m.getName().startsWith("get"))
				return m.invoke(object).toString();
		return null;
	}
	
	public String convertStock(Stock stock){
		return new Gson().toJson(stock);
		
	}
	
	public Stock convertStock(String jsonObject) {
		return new Gson().fromJson(jsonObject, Stock.class);
	}
}