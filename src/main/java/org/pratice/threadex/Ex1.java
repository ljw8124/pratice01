package org.pratice.threadex;

public class Ex1 {
    //bad code
    public static void main(String[] args) throws Exception {
        //멀티스레드 코드
        //Thread는 우리가 완벽하게 제어할 수 없음. 현재 cpu 상태에 따라서 다르다.
        new Thread(() -> {

            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " A" + i);
                //Thread.currentThread().getName() 은 사용한 Thread 이름을 불러오는 메소드
                try {
                    Thread.sleep(100); //0.1초동안 cpu에서 사용하고 있던 메모리를 반환환
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start(); //.start()는 새로운 Thread를 만들어서 출발시키라는 뜻.

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " B" + i);
            Thread.sleep(100);
        }


    }
}
