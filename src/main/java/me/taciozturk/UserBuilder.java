package me.taciozturk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public abstract class UserBuilder {

    private String name;
    private String email;
    private String hashedPassword;
    private ArrayList<Integer> connections;
    private ArrayList<Integer> groups;
    private Boolean searchable;
    private String avatar;
    private ArrayList<Post> posts;

    public UserBuilder(String name, String email, String password) throws NoSuchAlgorithmException {
        this.name = name;
        this.email = email;
        setPassword(password);
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    private void setPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes());

        // Byte dizisini hexadecimal stringe dönüştürme
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        this.hashedPassword = hexString.toString();
    }

    public UserBuilder setConnections(ArrayList<Integer> connections) {
        this.connections = connections;
        return this;
    }

    public UserBuilder setGroups(ArrayList<Integer> groups) {
        this.groups = groups;
        return this;
    }

    public UserBuilder setSearchable(Boolean searchable) {
        this.searchable = searchable;
        return this;
    }

    public UserBuilder setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public UserBuilder setPosts(ArrayList<Post> posts) {
        this.posts = posts;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public ArrayList<Integer> getConnections() {
        return connections;
    }

    public ArrayList<Integer> getGroups() {
        return groups;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public String getAvatar() {
        return avatar;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }
}
