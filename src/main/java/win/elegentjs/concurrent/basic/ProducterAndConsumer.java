package win.elegentjs.concurrent.basic;

/**
 * 使用多线程演示生产消费者模式
 *
 * 当商品数量降为0时，消费者停止消费
 * 当商品数量大于100时，生产者停止生产
 *
 */
public class ProducterAndConsumer {

    public static void main(String[] args) throws InterruptedException {

        Storage s = new Storage();

        new Thread(new Producter("厂家1", s)).start();
        new Thread(new Producter("厂家2", s)).start();
        new Thread(new Producter("厂家3", s)).start();
        new Thread(new Producter("厂家4", s)).start();
        new Thread(new Producter("厂家5", s)).start();

        new Thread(new Consumer("张三", s)).start();
        new Thread(new Consumer("李四", s)).start();
        new Thread(new Consumer("王五", s)).start();

    }
}


class Producter implements Runnable {

    // 货架
    private Storage storage;

    // 厂家
    private String name;

    public Producter(String name, Storage storage) {
        this.name = name;
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (storage) {
                while (storage.getCount() >= 30) {
                    try {
                        storage.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                storage.add();
                System.out.println("厂家 : " + name + ", " + storage);

                storage.notifyAll();
            }
        }

    }
}

class Consumer implements Runnable {

    // 货架
    private Storage storage;

    // 消费者姓名
    private String name;

    public Consumer(String name, Storage storage) {
        this.name = name;
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (storage) {
                while (storage.getCount() <= 0) {
                    try {
                        storage.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                storage.remove();
                System.out.println("消费者 : " + name + ", " + storage);

                storage.notifyAll();
            }
        }



    }
}


class Storage {
    private int count;

    public void add() {
        count ++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void remove() {
        count --;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        return count;
    }


    @Override
    public String toString() {
        return "Storage {" +
                "当前库存 =" + count +
                '}';
    }
}



