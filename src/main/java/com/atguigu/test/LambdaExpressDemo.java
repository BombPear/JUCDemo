package com.atguigu.test;

/**
 * @author lbstart
 * @create 2021-06-18 18:27
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public int add(int x, int y) {
                return x+y;
            }
        };
        Foo foo1 = (x,y)->{return x+y;};
        foo1.add(1, 2);
        Foo.div(1, 2);

    }
}

interface Foo{
    public int add(int x, int y);

    default int sub(int x, int y) {
        return x-y;
    }

    default int sub2(int x) {
        return 2;
    }

    public static int div(int x, int y) {
        return x / y;
    }

    public static int div2(int e, int m) {
        return 2;
    }
}