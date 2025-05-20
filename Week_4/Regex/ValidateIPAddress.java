import java.util.Scanner;

public class ValidateIPAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an IPv4 address: ");
        String ip = scanner.nextLine();

        if (isValidIPv4(ip)) {
            System.out.println(ip + " is a valid IPv4 address.");
        } else {
            System.out.println(ip + " is NOT a valid IPv4 address.");
        }

        scanner.close();
    }

    public static boolean isValidIPv4(String ip) {
        String ipRegex = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}"
                       + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";

        return ip.matches(ipRegex);
    }
}
