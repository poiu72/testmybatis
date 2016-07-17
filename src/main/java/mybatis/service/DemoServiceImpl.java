package mybatis.service;

import mybatis.model.UserEntity;
import mybatis.repository.DemoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by jiaranran on 2016/7/14.
 */
@Service
public class DemoServiceImpl implements DemoService,UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Resource
    private DemoRepository demoRepository;
    @Override
    public List<UserEntity> findByUsername(String name) {
       String sql= "select u from UserEntity u where u.username=?1";
        Query query=em.createQuery(sql);
        query.setParameter(1,name);
       return query.getResultList();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       List<UserEntity> list = demoRepository.findByUsername(username);
        return list.get(0);
    }
}
