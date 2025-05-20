import java.util.regex.Pattern;

public class UserRegistration {

    public static void registerUser(String username, String email, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (email == null || !isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }


        System.out.println("User registered: " + username);
    }

    private static boolean isValidEmail(String email) {

        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }
}
