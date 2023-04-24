1.递归实现1，1，2，3，5...第30位数
function diGui(n){
    if(n==1||n==2){
        return 1;
    }
    return diGui(n-1)+diGui(n-2);
}

2.服务端主动向客户端推送数据如何实现（socket）

3.线程安全的集合有哪些
有Vector、HashTable、Stack、ArrayBlockingQueue、ConcurrentHashMap、ConcurrentLinkedQueue等

4.concurrentHashMap在jdk1.8有哪些升级
从JDK1.7版本的ReentrantLock+Segment+HashEntry
到JDK1.8版本中synchronized+CAS+HashEntry+红黑树

5.redis的不同数据结构能实现哪种业务场景的功能
String:缓存、计数
List:异步队列、秒杀抢购场景（将库存商品缓存到类似MQ的队列中，list的pop操作是原子性的，所以即使有多个用户同时请求，也是依次pop，list空了pop抛出异常就代表商品卖完）
Hash:保存结构体信息(对象.属性)
Set:抽奖去重
ZSet:排行榜
Bitmap:布隆过滤器

6.List,Set,Queue,Map的特点及应用场景
List必须保持元素特定的顺序
Set不能有重复元素
Queue保持一个队列(先进先出)的顺序
Map一组成对的"键值对"对象

7.编写单例
private Singleton(){};
private Static final volatile Singleton singleton = null;
public static Singleton getSingleton(){
    if(singleton == null){
        Synchronized(Singleton.class){
            if(singleton == null){
                singleton = new Singleton();
            }
        }
    }
    return singleton;
}

8.sql实现行列转换
https://www.jb51.net/article/254682.htm

9.常用的linux命令