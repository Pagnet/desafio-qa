package base.dataproviderbase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JsonReader 
{
	
	public static Object[][] getdata(String JSON_path, String typeData) throws JsonIOException, JsonSyntaxException, FileNotFoundException
	{ 
		JsonParser jsonParser =  new JsonParser();
		JsonObject jsonObj = jsonParser.parse(new FileReader(JSON_path)).getAsJsonObject();
        JsonArray array = (JsonArray) jsonObj.get(typeData);
        
        return searchJsonElemnet(array);
	}

	public static Object[][] searchJsonElemnet(JsonArray jsonArray) throws NullPointerException 
	{
		
        int k = 0;
        int i = 0;
        int j = 0;
        
        for (@SuppressWarnings("unused") Map.Entry<String, JsonElement> e : jsonArray.get(0).getAsJsonObject().entrySet()) 
        	k++;
        
		Object[][] matrix = new Object[jsonArray.size()][k];
        for (JsonElement jsonElement : jsonArray) 
        {
        	
             for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) 
             {
            	 matrix[i][j] = entry.getValue().toString().replace("\"","");
                 j++;   
            }
            i++;
            j = 0;
        }
        
        return matrix;
	}

}