package mybatis.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiaranran on 2016/7/4.
 */
public class CustomExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        CustomException customException=null;
        if(e instanceof CustomException){
            customException=(CustomException)e;
        }else {
            customException=new CustomException("未知错误");
        }
        String message= customException.getMessage();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("message",message);
        return modelAndView;
    }
}
