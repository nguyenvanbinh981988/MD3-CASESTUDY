package Model;

public class Admin {
    private int id;
    private String name;
    private String position;
    private String passWord;

    public Admin(String name, String position,String passWord) {
        this.name = name;
        this.position = position;
        this.passWord=passWord;
    }

    public Admin(int id, String name, String position,String passWord) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.passWord= passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
