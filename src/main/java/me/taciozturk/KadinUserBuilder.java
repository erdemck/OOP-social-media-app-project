package me.taciozturk;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class KadinUserBuilder extends UserBuilder {

    public KadinUserBuilder(String name, String email, String password) throws NoSuchAlgorithmException {
        super(name, email, password);
        this.setAvatar("src/main/resources/assets/avatars/woman-2.png");
    }


}

