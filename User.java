import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String password;
    private String fullName;
    private String phone;
    private String studentId;
    private String college;

    public User(String email, String password, String fullName, String phone, String studentId, String college) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.studentId = studentId;
        this.college = college;
    }

    // getters
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }
    public String getStudentId() { return studentId; }
    public String getCollege() { return college; }
}
