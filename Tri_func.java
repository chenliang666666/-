import java.util.Scanner;

/**
 * 使用java实现三角函数的计算
 * 因为不能使用java自带的三角函数包，所以采用泰勒公式计算正余弦函数
 * @author 康
 */

 public class Tri_func{
    public static void main(final String[] args) {
        System.out.print("请输入一个值：");
        // 从键盘上获取输入数字
        final Scanner sc = new Scanner(System.in);
        double dou_num = sc.nextDouble();
        // 将dou_num转换成-2PI到2PI之间的角度
        dou_num = dou_num % (2 * Math.PI);

        // 实例化Calculator对象
        final Calculator cal = new Calculator(dou_num);

        System.out.println("<---------------开始计算正弦值--------------->");
        System.out.println("java自带函数中正弦值：" + Math.sin(dou_num));
        System.out.println("正弦值为：" + cal.my_sin(dou_num));
        System.out.println("误差=" + (Math.sin(dou_num) - cal.my_sin(dou_num)));
        System.out.println("<---------------开始计算余弦值--------------->");
        System.out.println("java自带函数中余弦值：" + Math.cos(dou_num));
        System.out.println("余弦值为：" + cal.my_cos(dou_num));

        System.out.println("<---------------开始计算正切值--------------->");
        System.out.println("java自带函数中正切值：" + Math.tan(dou_num));
        System.out.println("正切值为：" + cal.my_tan(dou_num));
    }
}

// 定义一个计算泰勒公式的类
class Calculator {
    double x;

    // 构造函数
    public Calculator(final double x) {
        this.x = x;
    }


    // // 使用递归求阶乘
    // public int fact(final int num) {
    //     if (num == 1 || num == 0) {
    //         return num;
    //     } else {
    //         return fact(num - 1) * num;
    //     }
    // }

    /**
     * 求sin 
     * sinx的泰勒公式为： sin(x) = x - x^3/3! + x^5/5! - x^7/7! + ...
     * @param x
     * @return
     */
    public double my_sin(double x) {
        // ith term = x^i / i!
        double term = 1.0;

        // 求和
        double sum = 0.0;
        // 泰勒公式
        for (int i = 1; term != 0.0; i++) {
            term *= (x / i);
            if (i % 4 == 1) {
                sum += term;
            } else if (i % 4 == 3) {
                sum -= term;
            }
        }
        return sum;
    }

    /**
     * 求cos 
     * cos(x) = 1 − x^2/2! + x^4/4! − x^6/6!+ …
     * @param x
     * @return
     */

    public double my_cos(double x) {
        // 
        double term = 1.0;
        double sum = 1.0;
        for(int i = 1; term != 0; i++){
            term  *= (x / i);
            if(i % 4 == 0){
                sum += term;
            }else if(i % 4 == 2){
                sum -= term;
            }
        }
        return sum;
    }

    /**
     * 计算tan
     * tan(x) = 
     */
    public double my_tan(double x){
        return my_sin(x) / my_cos(x);
    }
 }