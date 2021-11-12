package recriutment;

public class CurrentUser {

    private String Email;
    private String Password;
    private String type;

    private static CurrentUser user;

    private CurrentUser(){

    }

    public static CurrentUser getInstance()
    {
        if ( user == null )
        {
            user = new CurrentUser();
        }
        return user;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
