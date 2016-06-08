package annotator;

/**
 * Created by simpletour_Jenkin on 2016/6/7.
 */
public class UserRequest {

    @SunOfBeach(validateType = {SunOfBeach.Type.notNull})
    private Long id;

    @SunOfBeach(validateType = {SunOfBeach.Type.notNull,SunOfBeach.Type.id})
    private String idNo;

    private Type idType = Type.id;

    @SunOfBeach(validateType = {SunOfBeach.Type.notNull})
    private String name;

    private String mobile;

    public enum Type{
        id("身份证"),
        passport("护照");

        private String name;

        Type(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Type getIdType() {
        return idType;
    }

    public void setIdType(Type idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
