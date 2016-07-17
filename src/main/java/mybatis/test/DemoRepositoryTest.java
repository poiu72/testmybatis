package mybatis.test;

import mybatis.aspect.JpaAuditor;
import mybatis.model.UserEntity;
import mybatis.repository.DemoRepository;
import mybatis.service.DemoService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by jiaranran on 2016/7/14.
 */
public class DemoRepositoryTest extends TestSupport{
    @Resource
    private DemoRepository demoRepository;
    @Resource
    private DemoService demoService;
    @Resource
    private JpaAuditor jpaAuditor;
    /*@Resource
    private HelloAapect helloAapect;*/
    @Test
    public void testFindAll() throws Exception {
//        helloAapect.cutSayHello();
        Iterable<UserEntity> list  = demoRepository.findAll();
        for (UserEntity userEntity:list) {
            System.out.println(userEntity.getUsername());
        }
    }
    @Test
    public void testFindByName() throws Exception {
//        helloAapect.cutSayHello();
        Iterable<UserEntity> list  = demoRepository.findByUsername("1");
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername("bendan");
        jpaAuditor.setUser(new UserEntity());
        demoRepository.save(userEntity);
        for (UserEntity user:list) {
            System.out.println(user.getAddress());
        }
    }
    @Test
    public void testFindByName2() throws Exception {
//        helloAapect.cutSayHello();
        Iterable<UserEntity> list  = demoService.findByUsername("test");
        for (UserEntity userEntity:list) {
            System.out.println(userEntity.getAddress());
        }
    }
}
