package enums;

public enum PageHeaderEnum {

    HOMEPAGE_HEADER("Welcome to the Internet"),
    LOGIN_PAGE("Login"),
    SECURE_AREA("Secure_Area");

    String headerText;

    private PageHeaderEnum(String HeaderText){

        this.headerText=HeaderText;
    }

    public String getHeaderText(){
        return headerText;
    }

}
