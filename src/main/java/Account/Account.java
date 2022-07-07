package Account;

public class Account {
    private  int id;
    private String user;
    private String pass;
    private int issell;
    private int isadmin;

    public Account() {
    }

    public Account(int id, String user, String pass, int issell, int isadmin) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.issell = issell;
        this.isadmin = isadmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIssell() {
        return issell;
    }

    public void setIssell(int issell) {
        this.issell = issell;
    }

    public int getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(int isadmin) {
        this.isadmin = isadmin;
    }
}
