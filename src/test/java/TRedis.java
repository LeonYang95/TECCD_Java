import ccd.PropsLoader;
import org.junit.Test;
import util.RedisUtil;

public class TRedis {
    @Test
    public void testRedisSet(){
        RedisUtil.checkSet();
    }

    @Test
    public void testOpenDB(){
        final Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(PropsLoader.getProperty("redis.path"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInit(){
        RedisUtil.openDB();
        RedisUtil.clearDB();
        RedisUtil.flushAll();
    }

    @Test
    public void flushAll(){
        RedisUtil.flushAll();
    }


}
