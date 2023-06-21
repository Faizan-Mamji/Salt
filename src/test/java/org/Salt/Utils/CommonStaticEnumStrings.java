package org.Salt.Utils;

public enum CommonStaticEnumStrings {

    title_HomePage("Hello Default Locale, Selendroid-test-app!"),
    chrome_Page_Text("Hello, can you please tell me your name?"),
    name("Faizan Farooq"),
    prefered_Car("Mercedes"),
    prefered_Car_Volvo("Volvo"),
    register_Name("Mr. Burns"),
    register_Programming_Language("Ruby"),
    register_Email("test@abc.com"),
    register_Password("123456"),
    register_Message("Welcome to register a new User"),
    toast_Message("Hello selendroid toast!"),
    configPath("src/test/Resources/Config.properties"),

    apkLocation("Android_Apk/selendroid-test-app.apk");

    public String description;

    CommonStaticEnumStrings(String desc) {
        this.description = desc;
    }

    public String getCommonStrings() {
        return description;
    }
}
