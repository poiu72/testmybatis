package mybatis.controller;

import mybatis.model.ItemCustom;
import mybatis.service.ItemServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by jiaranran on 2016/7/1.
 */
@Controller
@RequestMapping("/itemController")
public class ItemController {
    @Autowired
    private ItemServiceI itemServiceI;

    @RequestMapping("/queryItem")
    public ModelAndView queryItem(){
        List<ItemCustom> list = itemServiceI.findItemList(null);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("items/itemList");
        modelAndView.addObject("list", list);
        return modelAndView;
    }
    @RequestMapping(value = "/editItem",method ={RequestMethod.POST,RequestMethod.GET} )
    public String editItem(Model model,@RequestParam(value="id",required = true,defaultValue = "")Integer item_id){
        ItemCustom itemCustom = itemServiceI.selectByPrimaryKey(item_id);
        model.addAttribute("itemCustom", itemCustom);
       /* ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("items/editItem");
        modelAndView.addObject("itemCustom", itemCustom);*/
        return "items/editItem";
    }
    @RequestMapping(value = "/editItemSubmit",method = {RequestMethod.POST})
    public String editItemSubmit(HttpServletRequest requet,Integer id,ItemCustom itemCustom){
        itemServiceI.updateByPrimaryKeySelective(id,itemCustom);
        return "forword:queryItem.action";
    }
}
