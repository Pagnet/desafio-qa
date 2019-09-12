package br.com.blue.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesFactory {

    public static Properties properties = new Properties();

    public static Properties getProp() {
        try {
            if(PropertiesFactory.properties.isEmpty()){
                InputStream file = PropertiesFactory.class.getResourceAsStream("/propriedades.properties");
                PropertiesFactory.properties.load(file);
                return PropertiesFactory.properties;
            }
            else {
                return PropertiesFactory.properties;
            }
        }
        catch(IOException ex){
            throw new RuntimeException(ex);
        }
    }

}
