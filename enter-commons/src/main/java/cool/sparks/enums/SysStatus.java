package cool.sparks.enums;

public enum SysStatus {
    USER_DISABLE("1","停用"),
    USER_DELETED("1","删除");

    private final String code;
    private final String info;

    SysStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }
    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
