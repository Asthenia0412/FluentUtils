package com.xiaoyongcai.io.TestJob.Pojo;

import java.util.List;
import java.util.Map;

public class Product {
    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Boolean available;
    private List<String> tags;
    private Map<String, String> specifications;

    // getters 和 setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Boolean isAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public Map<String, String> getSpecifications() { return specifications; }
    public void setSpecifications(Map<String, String> specifications) {
        this.specifications = specifications;
    }
}