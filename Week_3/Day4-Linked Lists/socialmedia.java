package DataStructures.LinkedLists;

import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head = null;

    // Add a user
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    // Find user by ID
    private User getUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection (bi-directional)
    public void addFriend(int userId1, int userId2) {
        User u1 = getUserById(userId1);
        User u2 = getUserById(userId2);
        if (u1 == null || u2 == null || userId1 == userId2) return;

        if (!u1.friendIds.contains(userId2)) u1.friendIds.add(userId2);
        if (!u2.friendIds.contains(userId1)) u2.friendIds.add(userId1);
    }

    // Remove friend connection (bi-directional)
    public void removeFriend(int userId1, int userId2) {
        User u1 = getUserById(userId1);
        User u2 = getUserById(userId2);
        if (u1 != null && u2 != null) {
            u1.friendIds.remove((Integer) userId2);
            u2.friendIds.remove((Integer) userId1);
        }
    }

    // Display all friends of a user
    public void displayFriends(int userId) {
        User user = getUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println(user.name + "'s Friends:");
        for (int fid : user.friendIds) {
            User friend = getUserById(fid);
            if (friend != null) {
                System.out.println(" - " + friend.name + " (ID: " + friend.userId + ")");
            }
        }
    }

    // Count number of friends
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }

    // Search user by ID
    public void searchUserById(int userId) {
        User user = getUserById(userId);
        if (user != null) {
            System.out.println("User Found: " + user.name + ", Age: " + user.age);
        } else {
            System.out.println("User not found.");
        }
    }

    // Search user by Name
    public void searchUserByName(String name) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: ID " + temp.userId + ", Age: " + temp.age);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No user with name " + name);
    }

    // Find mutual friends
    public void findMutualFriends(int userId1, int userId2) {
        User u1 = getUserById(userId1);
        User u2 = getUserById(userId2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        Set<Integer> mutual = new HashSet<>(u1.friendIds);
        mutual.retainAll(u2.friendIds);

        System.out.println("Mutual Friends:");
        for (int id : mutual) {
            User friend = getUserById(id);
            if (friend != null) {
                System.out.println(" - " + friend.name + " (ID: " + friend.userId + ")");
            }
        }
        if (mutual.isEmpty()) {
            System.out.println("No mutual friends.");
        }
    }

    // Display all users
    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}
