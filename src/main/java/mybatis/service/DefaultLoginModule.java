package mybatis.service;

import mybatis.model.UserEntity;
import mybatis.repository.DemoRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.Map;

/**
 * Created by jiaranran on 2016/7/15.
 */
public class DefaultLoginModule implements LoginModule {
    private Subject subject;
    private CallbackHandler callbackHandler;
    private  String username;
    private  String password;
    @Resource
    private DemoRepository demoRepository;
    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.subject=subject;
        this.callbackHandler=callbackHandler;
        NameCallback nameCallback=new NameCallback("prompt");
        PasswordCallback passwordCallback = new PasswordCallback("prompt", false);
        try {
            callbackHandler.handle(new Callback[]{nameCallback, passwordCallback});
            username=nameCallback.getName();
            password=new String(passwordCallback.getPassword());
        }catch (IOException e){
            e.printStackTrace();
        }catch (UnsupportedCallbackException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean login() throws LoginException {
        System.out.println(username+":"+password);
        UserEntity userEntity=demoRepository.findByUsername(username).get(0);
        if (userEntity.getPassword().equals(password)){
            UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(username,password);
            subject.getPrincipals().add(authentication);
            return true;
        }else {
            throw new LoginException("username is not match the password");
        }

    }

    @Override
    public boolean commit() throws LoginException {
        return false;
    }

    @Override
    public boolean abort() throws LoginException {
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        return false;
    }
}
