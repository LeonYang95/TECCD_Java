package util;

import ccd.PropsLoader;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Iterator;
import java.util.Set;

public class RedisUtil {
    private static JedisPool jedisPool = null;

    /**
     * 初始化Redis连接池
     */
    static {
        String ADDR = PropsLoader.getProperty("redis.addr");
        int PORT = Integer.valueOf(PropsLoader.getProperty("redis.port"));
        int MAX_ACTIVE = Integer.valueOf(PropsLoader.getProperty("redis.max_active"));
        int MAX_IDLE = Integer.valueOf(PropsLoader.getProperty("redis.max_idle"));
        int MAX_WAIT = Integer.valueOf(PropsLoader.getProperty("redis.max_wait"));
        boolean TEST_ON_BORROW = Boolean.valueOf(PropsLoader.getProperty("redis.test_on_borrow"));
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResourceObject(jedis);
        }
    }

    //初始化工作, 打开redis服务,清空之前数据
    public static void init(){
        openDB();
        clearDB();
        flushAll();
    }

    //开启redis服务
    public static void openDB(){
        final Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(PropsLoader.getProperty("redis.path"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //清空key-value数据库
    public static void clearDB(){
        getJedis().flushDB();
    }

    public static void flushAll(){
        getJedis().flushAll();
    }

    //查看redis数据库中当前数据
    public static void checkSet(){
        Set<String> keys = getJedis().keys("*");
        System.out.println(keys.size());
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }
}