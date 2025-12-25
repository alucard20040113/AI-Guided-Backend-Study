# Java核心知识点体系（春招面试高频考点）

## 一、Java基础与面向对象

### 1. Java语法基础
- **数据类型**：8种基本数据类型与引用类型的区别；自动装箱与拆箱
- **运算符**：&&和&、||和|的区别；++i与i++的区别
- **流程控制**：条件语句、循环语句、switch-case的使用；Java12+的switch表达式
- **数组**：一维数组与二维数组的声明与初始化；数组的常用操作

### 2. 面向对象特性
- **封装**：访问控制修饰符（public、protected、default、private）的作用范围
- **继承**：extends关键字的使用；方法重写与重载的区别；super关键字的作用
- **多态**：向上转型与向下转型；接口与抽象类的区别；方法的动态绑定
- **final关键字**：修饰类、方法、变量的不同含义
- **static关键字**：静态变量、静态方法、静态代码块的特点与使用场景

### 3. 核心类库
- **String类**：不可变性原理；String、StringBuffer、StringBuilder的区别与使用场景
- **Object类**：equals()与hashCode()方法的关系；toString()方法的重写
- **包装类**：基本数据类型与包装类的转换；缓存机制（如Integer.valueOf()）
- **日期时间类**：Java8之前的Date、Calendar；Java8的LocalDate、LocalTime、LocalDateTime

## 二、集合框架

### 1. 集合框架体系
- **Collection接口**：List、Set的共同方法
- **Map接口**：键值对存储结构
- **Collections工具类**：常用方法（排序、查找、线程安全转换等）

### 2. 常用集合实现类
- **ArrayList**：底层实现（动态数组）；扩容机制；线程安全性
- **LinkedList**：底层实现（双向链表）；与ArrayList的性能对比
- **HashMap**：底层实现（JDK7的数组+链表；JDK8的数组+链表+红黑树）；哈希冲突解决；扩容机制；线程安全性
- **LinkedHashMap**：有序性原理；LRU缓存实现
- **TreeMap**：底层实现（红黑树）；排序规则
- **HashSet**：底层实现（HashMap）；去重原理
- **ConcurrentHashMap**：线程安全实现（JDK7的分段锁；JDK8的CAS+Synchronized）

## 三、Java高级特性

### 1. IO流
- **IO流体系**：字节流与字符流的区别；节点流与处理流的关系
- **常用IO类**：FileInputStream/FileOutputStream；BufferedReader/BufferedWriter；ObjectInputStream/ObjectOutputStream（序列化）
- **NIO**：Channel、Buffer、Selector的基本概念；与传统IO的区别

### 2. 异常处理
- **异常体系**：Throwable、Error、Exception的关系；受检异常与非受检异常的区别
- **异常处理机制**：try-catch-finally；throw与throws关键字
- **最佳实践**：不要捕获Throwable；避免空的catch块；资源自动关闭（try-with-resources）

### 3. 反射机制
- **反射的原理**：Class类的获取方式；类的加载与初始化
- **反射的应用**：动态创建对象；调用方法；访问字段；获取注解信息
- **反射的优缺点**：灵活性与性能开销

### 4. 注解
- **内置注解**：@Override、@Deprecated、@SuppressWarnings
- **元注解**：@Target、@Retention、@Documented、@Inherited
- **自定义注解**：注解的定义与使用

### 5. Java8新特性
- **Lambda表达式**：语法格式；函数式接口的要求
- **Stream API**：创建流；中间操作；终端操作；并行流
- **Optional类**：解决空指针异常的优雅方式
- **接口默认方法与静态方法**

## 四、并发编程

### 1. 线程基础
- **进程与线程的区别**：资源分配与调度
- **线程的创建方式**：继承Thread类；实现Runnable接口；实现Callable接口（Future）
- **线程生命周期**：新建、就绪、运行、阻塞、死亡
- **线程的状态转换**：sleep()、wait()、notify()、notifyAll()、join()、yield()的区别

### 2. 同步与锁机制
- **synchronized关键字**：修饰方法、代码块；锁的升级（偏向锁、轻量级锁、重量级锁）
- **ReentrantLock**：与synchronized的区别；公平锁与非公平锁
- **volatile关键字**：可见性、禁止指令重排；不能保证原子性的原因
- **ThreadLocal**：原理与使用场景；内存泄漏问题

### 3. 并发工具类
- **CountDownLatch**：倒计时门闩；使用场景
- **CyclicBarrier**：循环屏障；与CountDownLatch的区别
- **Semaphore**：信号量；限流场景的应用
- **Exchanger**：线程间数据交换

### 4. 线程池
- **ThreadPoolExecutor**：核心参数（corePoolSize、maximumPoolSize、keepAliveTime、workQueue等）；拒绝策略
- **线程池的工作原理**：任务提交流程
- **Executors工具类**：创建不同类型的线程池；不推荐使用的原因
- **线程池的监控**：线程池状态；任务执行情况

### 5. 并发安全集合
- **CopyOnWriteArrayList/CopyOnWriteArraySet**：读写分离原理；适用场景
- **ConcurrentHashMap**：线程安全实现；与Hashtable的区别
- **BlockingQueue**：ArrayBlockingQueue、LinkedBlockingQueue、PriorityBlockingQueue等的使用场景

## 五、JVM基础

### 1. 类加载机制
- **类加载过程**：加载、链接（验证、准备、解析）、初始化
- **类加载器**：ClassLoader的分类（Bootstrap、Extension、Application）；双亲委派模型；自定义类加载器
- **类的初始化时机**：主动使用与被动使用的区别

### 2. JVM内存结构
- **运行时数据区域**：程序计数器、虚拟机栈、本地方法栈、堆、方法区（元空间）
- **堆内存划分**：年轻代（Eden、Survivor）、老年代；对象的分配与晋升
- **栈帧结构**：局部变量表、操作数栈、动态链接、方法出口

### 3. 垃圾回收
- **垃圾判定算法**：引用计数法；可达性分析
- **引用类型**：强引用、软引用、弱引用、虚引用
- **垃圾回收算法**：标记-清除、标记-整理、复制算法；分代收集策略
- **垃圾回收器**：Serial、ParNew、CMS、G1等的特点与适用场景
- **GC日志分析**：GC类型、内存变化、停顿时间
- **JVM调优**：常用参数（堆大小、新生代比例、GC器选择等）

## 六、Spring全家桶

### 1. Spring Core
- **IOC容器**：控制反转与依赖注入；BeanFactory与ApplicationContext的区别
- **Bean的生命周期**：实例化、属性赋值、初始化、销毁
- **AOP**：面向切面编程的原理；AspectJ的使用；通知类型（Before、After、Around等）
- **事务管理**：声明式事务与编程式事务；事务传播行为；隔离级别

### 2. Spring Boot
- **自动配置原理**：@SpringBootApplication；@EnableAutoConfiguration；spring.factories
- **Starter机制**：常用starter的作用
- **配置管理**：application.properties/application.yml；Profile的使用
- **Actuator**：监控与管理

### 3. Spring MVC
- **MVC架构**：Model、View、Controller的职责
- **请求处理流程**：DispatcherServlet的作用；HandlerMapping、HandlerAdapter、ViewResolver
- **参数绑定**：@RequestParam、@PathVariable、@RequestBody等注解的使用
- **拦截器**：HandlerInterceptor的实现与配置

## 七、数据库与缓存

### 1. MySQL基础
- **SQL语句**：DDL、DML、DQL、DCL
- **索引**：索引的类型（B+树、哈希索引）；索引的设计原则；最左前缀原则
- **事务**：ACID特性；事务隔离级别（读未提交、读已提交、可重复读、串行化）；脏读、不可重复读、幻读
- **SQL优化**：慢查询日志；EXPLAIN分析；优化策略

### 2. Redis
- **数据结构**：String、List、Set、Hash、ZSet的常用命令与使用场景
- **持久化**：RDB与AOF的区别与配置
- **缓存问题**：缓存穿透、缓存击穿、缓存雪崩的解决方案
- **分布式锁**：基于Redis的实现
- **Redis集群**：主从复制；哨兵模式；Cluster集群

## 八、设计模式

### 1. 创建型模式
- **单例模式**：懒汉式、饿汉式、双重检查锁定、静态内部类、枚举类的实现；线程安全性
- **工厂模式**：简单工厂、工厂方法、抽象工厂的区别与使用场景
- **建造者模式**：与工厂模式的区别；链式调用的实现

### 2. 结构型模式
- **代理模式**：静态代理、动态代理（JDK动态代理、CGLIB代理）的区别与使用场景
- **装饰器模式**：与继承的区别；IO流中的应用
- **适配器模式**：类适配器、对象适配器的区别

### 3. 行为型模式
- **观察者模式**：发布-订阅模型的实现
- **策略模式**：算法的封装与切换
- **模板方法模式**：固定算法骨架，允许子类重写特定步骤

## 九、分布式与微服务

### 1. 分布式基础
- **CAP定理**：一致性、可用性、分区容错性的权衡
- **BASE理论**：基本可用、软状态、最终一致性
- **分布式事务**：2PC、TCC、可靠消息最终一致性、最大努力通知

### 2. 微服务架构
- **服务注册与发现**：Eureka、Nacos的基本概念
- **服务调用**：RESTTemplate、Feign的使用
- **负载均衡**：Ribbon的基本原理
- **熔断降级**：Hystrix的使用

## 十、其他重要知识点

### 1. 网络编程
- **Socket编程**：TCP/IP的基本概念；Socket的创建与通信
- **HTTP协议**：请求方法（GET、POST、PUT、DELETE等）；状态码；请求头与响应头

### 2. 安全
- **加密算法**：对称加密（AES）、非对称加密（RSA）、哈希算法（MD5、SHA）
- **认证与授权**：JWT的使用；Spring Security的基本概念

### 3. 性能优化
- **代码优化**：时间复杂度分析；空间复杂度分析
- **系统优化**：数据库优化、缓存优化、并发优化

# 面试重点提示

1. **底层原理**：不仅要知道"是什么"，更要理解"为什么"和"怎么做"
2. **对比分析**：例如ArrayList与LinkedList的区别、HashMap与ConcurrentHashMap的区别等
3. **实践经验**：结合项目实际，说明如何应用所学知识解决问题
4. **调优能力**：JVM调优、SQL优化、并发优化的实际经验
5. **学习能力**：近期学习的新技术、阅读的技术书籍或博客

# 复习建议

1. **重点突破**：优先掌握面试高频考点（如HashMap、并发编程、JVM）
2. **动手实践**：通过代码实现加深理解（如集合的底层实现、多线程编程）
3. **总结归纳**：将知识点整理成思维导图或笔记
4. **模拟面试**：多做面试题，模拟面试场景，提高表达能力
