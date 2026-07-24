public class ThreadTest {

    public static void main(String[] args) {
        TestThread testThread = new TestThread(5);
        TestThread testThread2 = new TestThread(3);
        testThread.start();
        testThread2.start();

    }
}

class TestThread extends Thread {
     int n;

     TestThread(int n) {
         this.n = n;
     }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.print(i);
        }

    }
}
