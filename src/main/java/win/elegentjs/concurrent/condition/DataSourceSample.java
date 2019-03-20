package win.elegentjs.concurrent.condition;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataSourceSample {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() -> {
            while (true) {
                dataSource.getConn();
                System.out.println("获取了一个连接。");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });


        executorService.submit(() -> {
            while (true) {
                dataSource.release(new Connection());
                System.out.println("释放了一个连接。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        executorService.submit(() -> {
            while (true) {
                dataSource.release(new Connection());
                System.out.println("释放了一个连接。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        executorService.submit(() -> {
            while (true) {
                dataSource.release(new Connection());
                System.out.println("释放了一个连接。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

    }
}

class DataSource {

    private LinkedList<Connection> pool = new LinkedList<>();

    private static final int MAX_CONNS  = 10;

    private Lock lock = new ReentrantLock();
    private Condition getCondition = lock.newCondition();


    public Connection getConn() {
        lock.lock();
        try {
            while (pool.size() <= 0) {
                try {
                    System.out.println("连接池已经空了，等待。。。");
                    getCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return pool.removeFirst();
        } finally {
            lock.unlock();
        }
    }


    public void release(Connection conn) {
        lock.lock();
        pool.addLast(conn);

        getCondition.signal();
        lock.unlock();
    }
}

class Connection {}