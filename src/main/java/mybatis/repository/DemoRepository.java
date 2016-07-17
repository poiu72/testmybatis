package mybatis.repository;

import mybatis.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jiaranran on 2016/7/13.
 */
public interface DemoRepository extends CrudRepository<UserEntity,String> {
    List<UserEntity> findByUsername(String name);
}
