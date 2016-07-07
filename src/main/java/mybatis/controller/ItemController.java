package mybatis.controller;

import mybatis.controller.validation.validGroup1;
import mybatis.exception.CustomException;
import mybatis.model.ItemCustom;
import mybatis.model.ItemsQueryVo;
import mybatis.service.ItemServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by jiaranran on 2016/7/1.
 */
@Controller
@RequestMapping("/itemController")
public class ItemController {
    @Autowired
    private ItemServiceI itemServiceI;

    @RequestMapping(value = "/queryItem",method ={RequestMethod.POST,RequestMethod.GET} )
    public ModelAndView queryItem(ItemsQueryVo itemsQueryVo)throws Exception{
        List<ItemCustom> list = itemServiceI.findItemList(itemsQueryVo);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("items/itemList");
        modelAndView.addObject("list", list);
        return modelAndView;
    }
    @RequestMapping(value = "/editItem",method ={RequestMethod.POST,RequestMethod.GET} )
    public String editItem(Model model,
                           @RequestParam(value="id",required = true,defaultValue = "")Integer item_id)
                            throws Exception{
        ItemCustom itemCustom = itemServiceI.selectByPrimaryKey(item_id);
        if(itemCustom==null){
            throw new CustomException("修改的商品信息不存在");
        }
        model.addAttribute("items", itemCustom);
       /* ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("items/editItem");
        modelAndView.addObject("itemCustom", itemCustom);*/
        return "items/editItem";
    }
    @RequestMapping("/itemView/{id}")
    public @ResponseBody ItemCustom itemView(@PathVariable("id") Integer id)
                                            throws Exception{
        ItemCustom itemCustom = itemServiceI.selectByPrimaryKey(id);
        return itemCustom;
    }
    /*使用model.addAttribute("items",itemCustom)进行回显;可以不用 @ModelAttribute("items")*/
    @RequestMapping(value = "/editItemSubmit",method ={RequestMethod.POST})
    public String editItemSubmit(Model model,
                                 HttpServletRequest requet,
                                 Integer id,
                                 @ModelAttribute("items") @Validated(value= {validGroup1.class}) ItemCustom itemCustom,
                                 BindingResult bindingResult,
                                 MultipartFile item_pic) throws IOException{
        if(bindingResult.hasErrors()){
           List<ObjectError> allErros= bindingResult.getAllErrors();
            for (ObjectError objectError:allErros) {
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("allErros",allErros);
            model.addAttribute("items",itemCustom);
            return "items/editItem";
        }
        String name=item_pic.getOriginalFilename();
        if(item_pic!=null && name!=null && name.length()>0){
            String pic_name= UUID.randomUUID()+name.substring(name.lastIndexOf("."));
            String pic_path="D:\\deployee\\upload\\temp";
            String new_name=pic_path+pic_name;
            File file=new File(new_name);
            item_pic.transferTo(file);
            itemCustom.setPic(pic_name);
        }
        itemServiceI.updateByPrimaryKeySelective(id,itemCustom);
        return "forword:queryItem.do";
    }
    @RequestMapping(value = "/deleteItem",method = {RequestMethod.POST})
    public String editItemSubmit(Integer[] item_id)throws Exception{
        for (int i = 0; i < item_id.length; i++) {
            itemServiceI.deleteByPrimaryKeySelective(item_id[i]);
        }
        return "forword:queryItem.do";
    }
    @RequestMapping(value = "/editItemQuery",method ={RequestMethod.POST,RequestMethod.GET} )
    public ModelAndView editItemQuery(ItemsQueryVo itemsQueryVo)throws Exception{
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
    @ModelAttribute("itemTypes")
    public Map<String,String> getItemTypes(){
        Map<String,String> itemTypes=new HashMap<String,String>();
        itemTypes.put("101","数码");
        itemTypes.put("102","母婴");
        return itemTypes;
    }
}
