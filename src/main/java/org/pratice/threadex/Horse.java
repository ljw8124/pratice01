package org.pratice.threadex;

public class Horse extends Thread {

    private String name;
    private int position;

    public Horse(String name) {
        this.name = name;
        this.position = 0;
    }

    @Override
    public void run() {
        this.gallop();
    }

    public void gallop() {
        for (int i = 0; i < 100; i++) {
            int range = (int)(Math.random() * 10) + 1;

            this.position += range;

            //synchronized()는 괄호안에 있는 내용을 한번에, 하나의 스레드만 사용가능, web에서 많이 사용
            //하지만 synchronized()를 너무 남발하면 오히려 프로그램 성능저하를 일으킬 수 있음.
            synchronized (System.out) {
                int count = this.position / 10;
                for(int j = 0; j < count; j++) {
                    System.out.print(".");
                }
                System.out.println(this.name + ": " + this.position);
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Horse h1 = new Horse("둘리말");
        Horse h2 = new Horse("도우너말");
        Horse h3 = new Horse("고길동말");
        Horse h4 = new Horse("마이콜말");

        h1.start();
        h2.start();
        h3.start();
        h4.start();
    }

}
