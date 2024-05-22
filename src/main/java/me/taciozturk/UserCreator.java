package me.taciozturk;

import me.taciozturk.Authentication.Register;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Scanner;

public class UserCreator {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Register register = new Register("src/main/java/me/taciozturk/users.json");
        /*
        for (int i = 0; i < 10; i++) {
            User user = createRandomUser();
            register.register(user);
        }
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your Name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter your Email: ");
        String email = scanner.nextLine();
        System.out.println("Please enter your Password: ");
        String password = scanner.nextLine();


        User userBuilder = new UserBuilder(name, email,password)
                .build();

        register.register(userBuilder);
    }



    private static User createRandomUser() throws NoSuchAlgorithmException {
        String[] names = {"Erdem Karadag", "John Doe", "Alice Smith", "Bob Johnson", "Emma Brown", "David Wilson", "Sarah Garcia", "Michael Martinez", "Jennifer Davis", "Chris Rodriguez"};
        String[] emails = {"erdem@example.com", "john@example.com", "alice@example.com", "bob@example.com", "emma@example.com", "david@example.com", "sarah@example.com", "michael@example.com", "jennifer@example.com", "chris@example.com"};

        int randomIndex = (int) (Math.random() * names.length);

        String name = names[randomIndex];
        String email = emails[randomIndex];
        StringBuilder password = new StringBuilder();
        password.append(name);
        password.append(1);
        String pass = password.toString();
        User user = new UserBuilder(name, email, pass)
                .setAvatar("src/main/resources/assets/avatars/man-1-3d.jpg")
                .setSearchable(true)
                .build();
        Post post = new Post(user.getName(),user.getId(),new Date());
        user.addPost(post);

        return user;
    }
}
