# Java春招学习记录

## 会话基本信息
- **日期**：2025-12-28
- **时长**：约2小时
- **主题**：Java运算符与流程控制
- **学习方式**：苏格拉底式对话 + 学习记录整理

## 学习内容
今日学习的主要内容：
17. switch语句的使用
18. break、continue、return的区别
19. 位运算的使用
20. 自增自减运算
21. float表示小数
22. 数据准确性的保证
23. Integer缓存机制
24. new Integer(10) == new Integer(10)的比较
25. String转Integer的原理
26. Object类的常用方法
27. equals和hashCode方法
28. clone方法
29. toString方法
30. wait/notify方法
31. getClass方法
32. finalize方法

## 苏格拉底式对话摘要
记录今天与Trae的主要对话内容：

### switch语句的使用
- Trae：switch语句能否用在byte/long/String类型上？
- 我：Java 5以前switch(expr)中，expr只能是byte、short、char、int。从Java 5开始，Java中引入了枚举类型，expr也可以是enum类型。从Java 7开始，expr还可以是字符串，但是long整型在目前所有的版本中都是不可以的。
- Trae：那你觉得switch语句有什么优点？
- 我：switch语句的优点是代码更清晰，可读性更好；在多个条件判断时，switch比if-else链更简洁；switch语句在编译时可以进行优化，比如使用跳转表，提高执行效率。

### break、continue、return的区别
- Trae：break、continue、return的区别及作用？
- 我：break跳出整个循环，不再执行循环；continue跳出本次循环，继续执行下次循环；return程序返回，不再执行下面的代码。
- Trae：那你觉得在什么情况下应该使用break，什么情况下应该使用continue？
- 我：当需要完全退出循环时，使用break；当需要跳过本次循环，继续执行下次循环时，使用continue。break用于满足某个条件后不再需要继续循环的情况；continue用于满足某个条件后跳过本次循环的剩余代码。

### 位运算的使用
- Trae：用效率最高的方法计算2乘以8？
- 我：2 << 3。位运算，数字的二进制位左移三位相当于乘以2的三次方。
- Trae：那你觉得位运算有什么应用场景？
- 我：位运算的应用场景包括：快速乘除法运算，比如左移相当于乘以2的n次方，右移相当于除以2的n次方；权限控制，比如用位运算表示权限；数据压缩，比如用位运算将多个布尔值压缩到一个整数中。

### 自增自减运算
- Trae：说说自增自减运算？
- 我：在写代码的过程中，常见的一种情况是需要某个整数类型变量增加1或减少1，Java提供了一种特殊的运算符，用于这种表达式，叫做自增运算符（++）和自减运算符（--）。++和--运算符可以放在变量之前，也可以放在变量之后。当运算符放在变量之前时(前缀)，先自增/减，再赋值；当运算符放在变量之后时(后缀)，先赋值，再自增/减。
- Trae：那你觉得前缀和后缀有什么区别？
- 我：前缀是先自增/减，再赋值；后缀是先赋值，再自增/减。比如，当b = ++a时，先自增（自己增加1），再赋值（赋值给b）；当b = a++时，先赋值(赋值给b)，再自增（自己增加1）。也就是，++a输出的是a+1的值，a++输出的是a值。用一句口诀就是："符号在前就先加/减，符号在后就后加/减"。

### float表示小数
- Trae：float是怎么表示小数的？
- 我：float类型的小数在计算机中是通过IEEE 754标准的单精度浮点数格式来表示的。S：符号位，0代表正数，1代表负数；M：尾数部分，用于表示数值的精度；R：基数，十进制中的基数是10，二进制中的基数是2；E：指数部分，例如10^-1中的-1就是指数。这种表示方法可以将非常大或非常小的数值用有限的位数表示出来，但这也意味着可能会有精度上的损失。
- Trae：那你觉得使用float时需要注意什么？
- 我：使用float时需要注意，由于精度的限制，进行数学运算时可能会遇到舍入误差，特别是连续运算累积误差可能会变得显著。对于需要高精度计算的场景（如金融计算），可能需要考虑使用BigDecimal类来避免这种误差。

### 数据准确性的保证
- Trae：讲一下数据准确性高是怎么保证的？
- 我：在金融计算中，保证数据准确性有两种方案，一种使用BigDecimal，一种将浮点数转换为整数int进行计算。肯定不能使用float和double类型，它们无法避免浮点数运算中常见的精度问题，因为这些数据类型采用二进制浮点数来表示，无法准确地表示，例如0.1。在处理小额支付或计算时，通过转换为较小的货币单位（如分），这样不仅提高了运算速度，还保证了计算的准确性。

### Integer缓存机制
- Trae：Integer a=127，Integer b=127；Integer c=128，Integer d=128；相等吗？
- 我：a和b相等，c和d不相等。这个问题涉及到Java的自动装箱机制以及Integer类的缓存机制。对于第一对：a和b是相等的。这是因为Java在自动装箱过程中，会使用Integer.valueOf()方法来创建Integer对象。Integer.valueOf()方法会针对数值在-128到127之间的Integer对象使用缓存。因此，a和b实际上引用了常量池中相同的Integer对象。对于第二对：c和d不相等。这是因为128超出了Integer缓存的范围(-128到127)。因此，自动装箱过程会为c和d创建两个不同的Integer对象，它们有不同的引用地址。
- Trae：那你觉得Integer缓存有什么作用？
- 我：Integer缓存的主要目的是优化性能和内存使用。对于小整数的频繁操作，使用缓存可以显著减少对象创建的数量。可以在运行的时候添加-Djava.lang.Integer.IntegerCache.high=1000来调整缓存池的最大值。

### new Integer(10) == new Integer(10)的比较
- Trae：new Integer(10) == new Integer(10)相等吗？
- 我：在Java中，使用new Integer(10) == new Integer(10)进行比较时，结果是false。这是因为new关键字会在堆上为每个Integer对象分配新的内存空间，所以这里创建了两个不同的Integer对象，它们有不同的内存地址。当使用==运算符比较这两个对象时，实际上比较的是它们的内存地址，而不是它们的值，因此即使两个对象代表相同的数值（10），结果也是false。
- Trae：那你觉得应该用什么来比较Integer对象？
- 我：应该使用equals方法来比较Integer对象的数值是否相等，而不是==运算符。使用equals方法时，c和d的比较结果为true，因为equals比较的是对象的数值，而不是引用地址。

### String转Integer的原理
- Trae：String怎么转成Integer的？原理？
- 我：String转成Integer，主要有两个方法：Integer.parseInt(String s)和Integer.valueOf(String s)。不管哪一种，最终还是会调用Integer类内中的parseInt(String s, int radix)方法。这个方法的核心是一个简单的字符串遍历计算，不过计算方式有点反常规，是用负的值累减。
- Trae：那你觉得parseInt和valueOf有什么区别？
- 我：parseInt返回基本数据类型int，valueOf返回包装类型Integer。如果只是需要数值，使用parseInt；如果需要Integer对象，使用valueOf。valueOf内部会调用parseInt，然后可能使用缓存。

### Object类的常用方法
- Trae：Object类的常用方法？
- 我：在Java中，经常提到一个词"万物皆对象"，其中的"万物"指的是Java中的所有类，而这些类都是Object类的子类。Object主要提供了11个方法，大致可以分为六类：对象比较、对象拷贝、对象转字符串、多线程调度、反射、垃圾回收。
- Trae：那你觉得Object类为什么这么重要？
- 我：Object类是Java中所有类的基类，所以Object类中的方法所有对象都有。理解Object类的方法对于理解Java的面向对象特性、多线程、反射等都非常重要。

### equals和hashCode方法
- Trae：object有哪些方法？hashcode和equals为什么需要一起重写？不重写会导致哪些问题？
- 我：hashCode方法用于返回对象的哈希码。按照约定，相等的对象必须具有相等的哈希码。如果重写了equals方法，就应该重写hashCode方法。equals方法用于比较2个对象的内存地址是否相等。如果比较的是两个对象的值是否相等，就要重写该方法。不重写hashCode会导致在使用HashMap等集合时出现重复元素，影响集合的正确性。
- Trae：那你觉得什么时候会用到重写hashcode的场景？
- 我：在使用HashMap、HashSet等基于哈希的集合时，需要重写hashCode方法。如果自定义类作为HashMap的键，必须重写equals和hashCode方法。

### clone方法
- Trae：clone方法有什么作用？
- 我：clone方法是native方法，返回此对象的一个副本。默认实现只做浅拷贝，且类必须实现Cloneable接口。Object本身没有实现Cloneable接口，所以在不重写clone方法的情况下直接调用该方法会发生CloneNotSupportedException异常。
- Trae：那你觉得浅拷贝和深拷贝有什么区别？
- 我：浅拷贝只复制对象本身，不复制对象引用的其他对象；深拷贝会递归复制对象引用的所有对象。浅拷贝可能导致修改拷贝对象时影响原对象，深拷贝则不会。

### toString方法
- Trae：toString方法有什么作用？
- 我：toString方法返回对象的字符串表示。默认实现返回类名@哈希码的十六进制表示，但通常会被重写以返回更有意义的信息。比如一个Person类，我们可以重写toString方法，返回一个有意义的字符串。
- Trae：那你觉得重写toString方法有什么好处？
- 我：重写toString方法的好处是方便调试和日志输出，可以直观地看到对象的内容；提高代码的可读性，方便打印对象信息。

### wait/notify方法
- Trae：wait/notify方法有什么作用？
- 我：每个对象都可以调用Object的wait/notify方法来实现等待/通知机制。wait方法会导致当前线程等待，直到另一个线程调用此对象的notify()方法或notifyAll()方法。notify方法唤醒在此对象监视器上等待的单个线程。如果有多个线程等待，选择一个线程被唤醒。notifyAll方法唤醒在此对象监视器上等待的所有线程。
- Trae：那你觉得wait/notify有什么应用场景？
- 我：wait/notify的应用场景包括：生产者消费者模型，生产者生产数据后通知消费者，消费者没有数据时等待；线程间通信，一个线程等待另一个线程的通知。

### getClass方法
- Trae：getClass方法有什么作用？
- 我：getClass方法用于获取对象的类信息，如类名。比如，通过getClass().getName()可以获取对象的完整类名。
- Trae：那你觉得getClass方法有什么应用场景？
- 我：getClass方法的应用场景包括：反射，通过Class对象获取类的信息；类型判断，通过instanceof和getClass结合判断对象类型；日志输出，输出对象的类名。

### finalize方法
- Trae：finalize方法有什么作用？
- 我：finalize方法用于清理资源，当垃圾回收器决定回收对象占用的内存时调用此方法。但Java不推荐使用，因为它不可预测且容易导致问题，Java 9开始已被弃用。
- Trae：那你觉得为什么不推荐使用finalize方法？
- 我：不推荐使用finalize方法是因为它的执行时间不确定，可能永远不会执行；性能开销大，会延长对象的生命周期；可能导致资源泄漏，因为finalize方法执行失败时，资源可能不会被释放。应该使用try-with-resources或try-finally来显式释放资源。

## 学习收获
今日学习的主要收获：
1. 掌握了switch语句的使用和限制
2. 理解了break、continue、return的区别和应用场景
3. 学会了使用位运算提高运算效率
4. 深入理解了自增自减运算的前缀和后缀区别
5. 理解了float表示小数的IEEE 754标准
6. 掌握了保证数据准确性的方法
7. 深入理解了Integer缓存机制和原理
8. 掌握了new Integer(10) == new Integer(10)的比较问题
9. 理解了String转Integer的原理
10. 掌握了Object类的常用方法和分类
11. 理解了equals和hashCode方法的关系和重写规则
12. 掌握了clone方法的使用和浅拷贝深拷贝的区别
13. 学会了重写toString方法的好处
14. 理解了wait/notify方法的原理和应用场景
15. 掌握了getClass方法的使用
16. 理解了finalize方法的作用和不推荐使用的原因

## 遇到的问题
今日学习中遇到的主要问题：
1. switch语句在什么情况下比if-else更高效？
2. 位运算的优先级和结合性如何记忆？
3. Integer缓存的范围为什么是-128到127？
4. 浅拷贝和深拷贝如何实现？
5. wait/notify方法为什么必须在synchronized块中使用？

## 解决方案
针对上述问题的解决方案：
1. switch语句在多个条件判断时比if-else更高效，因为编译器可以使用跳转表优化；在条件较少时，if-else可能更清晰。
2. 位运算的优先级较低，建议使用括号明确运算顺序；记忆位运算的结合性，可以通过实际代码练习加深理解。
3. Integer缓存的范围-128到127是基于实践统计得出的，这个范围内的整数使用频率最高；可以通过JVM参数调整缓存范围。
4. 浅拷贝只需要实现Cloneable接口并重写clone方法；深拷贝需要在clone方法中手动复制所有引用对象，或者使用序列化反序列化。
5. wait/notify方法必须在synchronized块中使用，因为它们依赖于对象的监视器锁；只有获取了对象的监视器锁，才能调用wait/notify方法。

---

**记录人**：学习者  
**完成时间**：2025-12-28 22:00:00