package com.ltx.exercise;

/**
 * 字段不参与多态
 *
 * @author tianxing
 */
public class FieldHasNoPolymorphic {
    public static void main(String[] args) {
        Father gay = new Son();
        // I am Son,I have $0 --> 执行Son::showMeTheMoney()方法
        // I am Son,I have $4 --> 执行Son::showMeTheMoney()方法
        // This gay has $2 --> 通过静态类型访问到了父类中的money
        System.out.println("This gay has $" + gay.money);
    }

    public static class Father {
        public int money;

        public Father() {
            money = 2;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Father,I have $" + money);
        }
    }

    public static class Son extends Father {
        public int money;

        public Son() {
            money = 4;
            showMeTheMoney();
        }

        @Override
        public void showMeTheMoney() {
            System.out.println("I am Son,I have $" + money);
        }
    }
}
