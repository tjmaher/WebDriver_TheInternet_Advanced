package enums;

public enum UserEnum {

    TOM_SMITH("tomsmith","SuperSecretPassword!");

    String userName;
    String password;

    private UserEnum(String UserName, String Password){
        this.userName=UserName;
        this.password=Password;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }
}
