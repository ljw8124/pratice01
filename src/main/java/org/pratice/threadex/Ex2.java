package org.pratice.threadex;

public class Ex2 implements Runnable {

    public void doA() {
        for (int i = 0; i < 100; i++) {
            //Thread.currentThread().getName() 은 사용한 thread의 이름을 불러오는 것.
            System.out.println(Thread.currentThread().getName() + " : " + this);
            //결과에서도 보이듯이 형성된 객체 this는 하나이다.
        }
    }

    //상속의 경우 Override가 필수는 아니지만 인터페이스의 경우 Override가 필수이다.
    @Override
    public void run() {
        doA();
    }

    public static void main(String[] args) {

        Ex2 obj = new Ex2();

        //여기서 객체화처럼 보여도 Thread는 객체가 아니다. 주의!!
        Thread t0 = new Thread(obj);
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        Thread t3 = new Thread(obj);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
