package mybatis.controller;

import mybatis.model.ItemCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jiaranran on 2016/7/4.
 */
@Controller
public class jsonTest {
    @RequestMapping("/requestJson")
    public @ResponseBody ItemCustom requestJson(@RequestBody ItemCustom itemCustom){
        return itemCustom;
    }
    @RequestMapping("/responseJson")
    public @ResponseBody ItemCustom responseJson( ItemCustom itemCustom){
        return itemCustom;
    }
}
