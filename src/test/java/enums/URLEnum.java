package enums;

public enum URLEnum {

    BASE_URL("https://the-internet.herokuapp.com"),
    LOGIN("/login"),
    SECURE_AREA("/secure");

    String url;

    private URLEnum(String URL){

        this.url=URL;
    }

    public String getURL(){
        return url;
    }

}
