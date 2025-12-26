public class FinalStaticObjectDemo {
    // static变量：属于类，所有实例共享
    private static int objectCount = 0;
    
    // final变量：常量，只能赋值一次
    private final String name;
    
    // 普通实例变量
    private int age;
    
    // static代码块：类加载时执行，只执行一次
    static {
        System.out.println("Static block executed");
        objectCount = 100; // 初始化static变量
    }
    
    // 普通代码块：每次创建对象时执行
    {
        System.out.println("Instance block executed");
        age = 18; // 初始化实例变量
    }
    
    // 构造方法
    public FinalStaticObjectDemo(String name) {
        this.name = name;
        objectCount++;
        System.out.println("Constructor executed");
    }
    
    // static方法：属于类，可直接通过类名调用
    public static int getObjectCount() {
        return objectCount;
    }
    
    // final方法：不能被重写
    public final void printName() {
        System.out.println("Name: " + name);
    }
    
    // 重写Object类的toString()方法
    @Override
    public String toString() {
        return "FinalStaticObjectDemo{name='" + name + "', age=" + age + "}";
    }
    
    // 重写Object类的equals()方法
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FinalStaticObjectDemo that = (FinalStaticObjectDemo) obj;
        return name.equals(that.name);
    }
    
    // 重写Object类的hashCode()方法
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    
    public static void main(String[] args) {
        // 通过类名直接调用static方法
        System.out.println("Initial object count: " + FinalStaticObjectDemo.getObjectCount());
        
        // 创建对象
        FinalStaticObjectDemo obj1 = new FinalStaticObjectDemo("Alice");
        FinalStaticObjectDemo obj2 = new FinalStaticObjectDemo("Bob");
        FinalStaticObjectDemo obj3 = new FinalStaticObjectDemo("Alice");
        
        // 调用final方法
        obj1.printName();
        
        // 调用重写的toString()方法
        System.out.println(obj1);
        System.out.println(obj2);
        
        // 测试equals()方法
        System.out.println("obj1 equals obj2: " + obj1.equals(obj2));
        System.out.println("obj1 equals obj3: " + obj1.equals(obj3));
        
        // 测试hashCode()方法
        System.out.println("obj1 hashCode: " + obj1.hashCode());
        System.out.println("obj2 hashCode: " + obj2.hashCode());
        System.out.println("obj3 hashCode: " + obj3.hashCode());
        
        // 再次查看static变量
        System.out.println("Final object count: " + FinalStaticObjectDemo.getObjectCount());
        System.out.println("obj1 object count: " + obj1.getObjectCount());
        System.out.println("obj2 object count: " + obj2.getObjectCount());
    }
}