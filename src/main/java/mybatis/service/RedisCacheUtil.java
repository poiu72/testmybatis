package mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2016/4/7.
 */
@Service
public class RedisCacheUtil<T> {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 缓存基本的对象，Integer、String、实体类等
     * @param key 缓存的键值
     * @param value 缓存的值
     * @return  缓存的对象
     */
    public <T> ValueOperations<String,T> setCacheObject(String key,T value)
    {

        ValueOperations<String,T> operation = redisTemplate.opsForValue();
        operation.set(key,value);

        return operation;
    }

    /**
     * 获得缓存的基本对象。
     * @param key  缓存键值
//     * @param operation
     * @return   缓存键值对应的数据
     */
    public <T> T getCacheObject(String key /* ,ValueOperations<String,T> operation */ )
    {
        ValueOperations<String,T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 缓存List数据
     * @param key  缓存的键值
     * @param dataList 待缓存的List数据
     * @return   缓存的对象
     */
    public <T> ListOperations<String, T> rightPushAllList(String key, List<T> dataList)
    {
        ListOperations listOperation = redisTemplate.opsForList();
        listOperation.rightPushAll(key, dataList);

        return listOperation;
    }

    /**
     * 缓存List数据 先删除缓存
     * @param key  缓存的键值
     * @param dataList 待缓存的List数据
     * @return   缓存的对象
     */
    public <T> ListOperations<String, T> rightPushAllDeleteBefore(String key, List<T> dataList)
    {
        redisTemplate.delete(key);
        ListOperations listOperation = redisTemplate.opsForList();
        listOperation.rightPushAll(key, dataList);

        return listOperation;
    }

    /**
     * 获得缓存的list对象
     * @param key 缓存的键值
     * @return  缓存键值对应的数据
     */
    public <T> List<T> getCacheList(String key)
    {
        List<T> dataList = new ArrayList<T>();
        ListOperations<String,T> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);

        for(int i = 0 ; i < size ; i ++)
        {
            dataList.add((T) listOperation.index(key, i));
        }

        return dataList;
    }

    /**
     * 缓存Set
     * @param key  缓存键值
     * @param dataSet 缓存的数据
     * @return   缓存数据的对象
     */
    public <T> BoundSetOperations<String,T> setCacheSet(String key,Set<T> dataSet)
    {
        BoundSetOperations<String,T> setOperation = redisTemplate.boundSetOps(key);
  /*T[] t = (T[]) dataSet.toArray();
    setOperation.add(t);*/
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
//        zSetOperations.zCard();
//        redisTemplate.set;
        Iterator<T> it = dataSet.iterator();
        while(it.hasNext())
        {
            setOperation.add(it.next());
        }

        return setOperation;
    }

    /**
     * 获得缓存的set
     * @param key
//     * @param operation
     * @return
     */
    public Set<T> getCacheSet(String key /*,BoundSetOperations<String,T> operation */)
    {
        Set<T> dataSet = new HashSet<T>();
        BoundSetOperations<String,T> operation = redisTemplate.boundSetOps(key);

        Long size = operation.size();
        for(int i = 0 ; i < size ; i++)
        {
            dataSet.add(operation.pop());
        }
        return dataSet;
    }

    /**
     * 缓存Map
     * @param key
     * @param dataMap
     * @return
     */
    public <T> HashOperations<String,String,T> setCacheMap(String key,Map<String,T> dataMap)
    {

        HashOperations hashOperations = redisTemplate.opsForHash();
        if(null != dataMap)
        {

            for (Map.Entry<String, T> entry : dataMap.entrySet()) {

    /*System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); */
                hashOperations.put(key,entry.getKey(),entry.getValue());
            }

        }

        return hashOperations;
    }

    /**
     * 获得缓存的Map
     * @param key
//     * @param hashOperation
     * @return
     */
    public <T> Map<String,T> getCacheMap(String key/*,HashOperations<String,String,T> hashOperation*/)
    {
        Map<String, T> map = redisTemplate.opsForHash().entries(key);
        /*Map<String, T> map = hashOperation.entries(key);*/
        return map;
    }







    /**
     * 缓存Map
     * @param key
     * @param dataMap
     * @return
     */
    public <T> HashOperations<String,Integer,T> setCacheIntegerMap(String key,Map<Integer,T> dataMap)
    {
        HashOperations hashOperations = redisTemplate.opsForHash();
        if(null != dataMap)
        {

            for (Map.Entry<Integer, T> entry : dataMap.entrySet()) {

    /*System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); */
                hashOperations.put(key,entry.getKey(),entry.getValue());
            }

        }

        return hashOperations;
    }

    /**
     * 获得缓存的Map
     * @param key
//     * @param hashOperation
     * @return
     */
    public <T> Map<Integer,T> getCacheIntegerMap(String key/*,HashOperations<String,String,T> hashOperation*/)
    {
        Map<Integer, T> map = redisTemplate.opsForHash().entries(key);
  /*Map<String, T> map = hashOperation.entries(key);*/
        return map;
    }

    /**
     * 设置key过期时间
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public boolean expire(Object key, final long timeout, final TimeUnit unit){

        return redisTemplate.expire(key , timeout, unit);
    }

    /**
     * 获取键的过期时间
     * @param key
     * @param unit
     * @return
     */
    public Long getExpire(Object key, final TimeUnit unit){

        return redisTemplate.getExpire(key, unit);
    }
    /**
     * 删除key
     * @param key
     */
    public void deleteKey(Object key){
        redisTemplate.delete(key);
    }

    /**
     * 批量删除key
     * @param keys
     */
    public void deleteKeys(Collection keys){
        redisTemplate.delete(keys);
    }

    /**
     * 根据正则获取所有key
     * @param pattern
     * @return
     */
    public Set getKeysByReg(Object pattern){
        return redisTemplate.keys(pattern);
    }
}
