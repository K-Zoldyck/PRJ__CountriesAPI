
package com.models;
import com.DTO.RequestConfig;

public class DBconnection {
    private static DBconnection countries = null;
    
    private DBconnection() {}
    
    public static DBconnection getConnection() {
        if ( DBconnection.countries != null )
            return DBconnection.countries;
        return new DBconnection();
    }
    
    public String getFilteredCountries(RequestConfig configs) {
        return configs.toString();
    }
}
