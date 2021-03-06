package zsc.ordermealsys.common;

import java.util.concurrent.TimeUnit;
import org.slf4j.LoggerFactory;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import ch.qos.logback.classic.Logger;

public class TokenCache {
private static Logger logger=(Logger) LoggerFactory.getLogger(TokenCache.class);
	
	public static final String TOKEN_PREFIX	= "token_";
	
	//1000为缓存的初始化容量,maximumSize()函数是超过容量时使用LRU算法来移除缓存项
	private static LoadingCache<String,String> localCache=CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS)
				.build(new CacheLoader<String,String>(){
					//默认的数据加载实现，当调用get取值的时候，如果key没有对应的值，就调用这个方法进行加载
					@Override
					public String load(String s)throws Exception{
						return "null";
					}
				});
	public static void setKey(String key,String value){
		localCache.put(key, value);
	}
	public static String getKey(String key){
		String value=null;
		try{
			value=localCache.get(key);
			if("null".equals(value)){
				return null;
			}
			return value;
		}catch(Exception e){
			logger.error("localCache get error",e);
		}
		return null;
	}
}
