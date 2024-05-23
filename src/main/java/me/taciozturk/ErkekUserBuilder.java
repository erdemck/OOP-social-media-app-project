package me.taciozturk;

import java.security.NoSuchAlgorithmException;

public class ErkekUserBuilder extends UserBuilder {

    public ErkekUserBuilder(String name, String email, String password) throws NoSuchAlgorithmException {
        super(name, email, password);
        this.setAvatar("src/main/resources/assets/avatars/man-3-3d.jpg");
    }

}