package mybatis.controller;

import mybatis.model.ItemCustom;
import mybatis.model.ItemsQueryVo;
import mybatis.service.ItemServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
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

    @RequestMapping(value = "/queryItem",method ={RequestMethod.POST,RequestMethod.GET} )
    public ModelAndView queryItem(ItemsQueryVo itemsQueryVo){
        List<ItemCustom> list = itemServiceI.findItemList(itemsQueryVo);
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
    @RequestMapping(value = "/editItemSubmit",method ={RequestMethod.POST})
    public String editItemSubmit(Model model,HttpServletRequest requet,Integer id,
                                 @Validated ItemCustom itemCustom,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
           List<ObjectError> allErros= bindingResult.getAllErrors();
            for (ObjectError objectError:allErros) {
                System.out.println(objectError.getDefaultMessage());
                return "items/editItem";
            }
            model.addAttribute("allErros",allErros);
        }
        itemServiceI.updateByPrimaryKeySelective(id,itemCustom);
        return "forword:queryItem.do";
    }
    @RequestMapping(value = "/deleteItem",method = {RequestMethod.POST})
    public String editItemSubmit(Integer[] item_id){
        for (int i = 0; i < item_id.length; i++) {
            itemServiceI.deleteByPrimaryKeySelective(item_id[i]);
        }
        return "forword:queryItem.do";
    }
    @RequestMapping(value = "/editItemQuery",method ={RequestMethod.POST,RequestMethod.GET} )
    public ModelAndView editItemQuery(ItemsQueryVo itemsQueryVo){
        List<ItemCustom> list = itemServiceI.findItemList(itemsQueryVo);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("items/editItemQuery");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

 /*   @RequestMapping(value = "/editQuerySubmit",method ={RequestMethod.POST})
    public String editItemSubmit(HttpServletRequest requet,Integer id,List<ItemsQueryVo> list){
        itemServiceI.updateByPrimaryKeySelective(id,itemCustom);
        return "forword:queryItem.do";
    }*/
}
