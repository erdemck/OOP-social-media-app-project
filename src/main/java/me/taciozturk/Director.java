package me.taciozturk;

public class Director {
    private UserBuilder userBuilder;

    public Director(UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    public User build() {
        User user = new User();
        user.setName(userBuilder.getName());
        user.setAvatar(userBuilder.getAvatar());
        user.setEmail(userBuilder.getEmail());
        user.setHashedPassword(userBuilder.getHashedPassword());
        user.setSearchable(userBuilder.getSearchable());
        user.setId();
        return user;
    }

}
