public class DataTypeDemo {
    public static void main(String[] args) {
        // 1. 基本数据类型的声明与初始化
        byte b = 10;
        short s = 200;
        int i = 30000;
        long l = 4000000000L; // 注意L后缀
        float f = 3.14f; // 注意f后缀
        double d = 3.1415926;
        char c = 'A';
        boolean bool = true;
        
        System.out.println("基本数据类型:");
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + bool);
        
        // 2. 自动装箱与拆箱
        System.out.println("\n自动装箱与拆箱:");
        Integer integer = 100; // 自动装箱
        int intValue = integer; // 自动拆箱
        System.out.println("自动装箱: " + integer.getClass());
        System.out.println("自动拆箱: " + intValue);
        
        // 3. 包装类缓存机制
        System.out.println("\n包装类缓存机制:");
        Integer aInteger = 100;
        Integer bInteger = 100;
        System.out.println("aInteger == bInteger (100): " + (aInteger == bInteger)); // true
        
        Integer cInteger = 200;
        Integer dInteger = 200;
        System.out.println("cInteger == dInteger (200): " + (cInteger == dInteger)); // false
        
        // 4. 数据类型转换
        System.out.println("\n数据类型转换:");
        int intNum = 100;
        long longNum = intNum; // 隐式转换
        System.out.println("int -> long: " + longNum);
        
        long largeLong = 2147483648L;
        int intFromLong = (int) largeLong; // 显式转换，溢出
        System.out.println("long -> int (溢出): " + intFromLong);
        
        // 5. 使用Math.toIntExact()安全转换
        try {
            int safeInt = Math.toIntExact(largeLong);
            System.out.println("安全转换: " + safeInt);
        } catch (ArithmeticException e) {
            System.out.println("安全转换失败: " + e.getMessage());
        }
    }
}