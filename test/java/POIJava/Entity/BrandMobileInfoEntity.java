package POIJava.Entity;

/**
 * Created by simpletour_java on 2015/9/8.
 */
public class BrandMobileInfoEntity {
    private String name;
    private int age;
    private String idNo;
    private String mobile;
    private String password;


    public BrandMobileInfoEntity(String name, int age, String idNo, String mobile,String password) {
        this.name = name;
        this.age = age;
        this.idNo = idNo;
        this.mobile = mobile;
        this.password = password;
    }

    public BrandMobileInfoEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
