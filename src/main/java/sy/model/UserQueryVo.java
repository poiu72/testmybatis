package sy.model;

import java.util.List;

/**
 * Created by jiaranran on 2016/6/28.
 */
public class UserQueryVo {
    private List<Integer> idlist;
    private UserCustom userCustom;

    public List<Integer> getIdlist() {
        return idlist;
    }

    public void setIdlist(List<Integer> idlist) {
        this.idlist = idlist;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
