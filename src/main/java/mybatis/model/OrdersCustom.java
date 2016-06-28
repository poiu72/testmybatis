package mybatis.model;

/**
 * Created by jiaranran on 2016/6/28.
 */
public class OrdersCustom extends Orders {
    private String username;
    private String sex;
    private String adress;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
