package mybatis.service;


import mybatis.model.ItemsQueryVo ;
import mybatis.dao.UserMapper;
import mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mybatis.model.ItemsQueryVo;
import mybatis.model.ItemCustom ;
import mybatis.model.Items;
import java.util.*;
/**
 * Created by jiaranran on 2016/6/30.
 */
@Service("userService")
public class UserServiceImpl  implements UserServiceI{
    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }
    //	@Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public User getUserById(String id) {
        // TODO Auto-generated method stub
        System.out.println("getUserById start---");
        return userMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

}
