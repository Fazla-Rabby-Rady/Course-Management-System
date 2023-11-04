package cse.web.model;

public class product {
    private String name;
    private String password;
    private String id;

    public product() {
    }

    public product(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getId() {
        return id;
    }

    public void setId(String password) {
        this.id = password;
    }
}
