
package com.DTO;
public class RequestConfig {
    private String name = null;
    private String region = null;
    private String pattern = null;
    private String langs = null;
    private int limit = 10;
    
    public RequestConfig(String name, String zone,String pattern,String langs, int limit) {
        this.name = name;
        this.region = zone;
        this.pattern = pattern;
        this.langs = langs;
        this.limit = limit;
    }
    
    
    @Override
    public String toString() {
        return String.format("countrie,name: %s,  region: %s, pattern: %s, langs: %s, limit: %d",
                this.name,this.region,this.pattern,this.langs,this.limit
        );
    }
}
