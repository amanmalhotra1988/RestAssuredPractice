package com.xyz.petstore.pojo;

import java.util.LinkedHashMap;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("jsonschema2pojo")
public class Category {

    private int id;
    private String name;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    
    public Category(){
    	
    }

    public Category( int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}