import java.io.*;
import java.util.*;

public class UserStore {
    private static final String STORE_FILENAME = "users.db";
    private static UserStore instance = new UserStore();

    private Map<String, User> users = new HashMap<>();

    private UserStore() {
        loadFromDisk();
    }

    public static UserStore getInstance() {
        return instance;
    }

    // Add user. Returns false if email already exists.
    public synchronized boolean addUser(User user) {
        String email = user.getEmail().toLowerCase();
        if (users.containsKey(email)) return false;
        users.put(email, user);
        saveToDisk();
        return true;
    }

    public synchronized User getUserByEmail(String email) {
        if (email == null) return null;
        return users.get(email.toLowerCase());
    }

    @SuppressWarnings("unchecked")
    private synchronized void loadFromDisk() {
        File f = new File(STORE_FILENAME);
        if (!f.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                users = (Map<String, User>) obj;
            }
        } catch (Exception e) {
            System.err.println("Could not load users from disk: " + e.getMessage());
        }
    }

    private synchronized void saveToDisk() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STORE_FILENAME))) {
            oos.writeObject(users);
        } catch (Exception e) {
            System.err.println("Could not save users to disk: " + e.getMessage());
        }
    }
}
