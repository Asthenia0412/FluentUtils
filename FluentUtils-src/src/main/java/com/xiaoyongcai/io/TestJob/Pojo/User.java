package com.xiaoyongcai.io.TestJob.Pojo;

import java.util.List;
import java.util.Map;

public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private Boolean active;
    private List<String> roles;
    private Map<String, Object> preferences;

    // 构造方法
    public User() {}

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // getters 和 setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Boolean isActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public List<String> getRoles() { return roles; }
    public void setRoles(List<String> roles) { this.roles = roles; }

    public Map<String, Object> getPreferences() { return preferences; }

    // 修正setter方法，保持类型一致
    public void setPreferences(Map<String, Object> preferences) {
        this.preferences = preferences;
    }
}