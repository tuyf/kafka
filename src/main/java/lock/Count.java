package lock;

public class Count {
    Lock lock = new Lock();
    public void print() throws InterruptedException{
        lock.lock();
        doAdd();
        lock.unlock();
    }
    public void doAdd() throws InterruptedException{
        lock.lock();
        //do something
        lock.unlock();
    }

    public static void main(String[] args) {
        try{
            System.out.println("开始：" );
            Count count = new Count();
            count.print();
            System.out.println("结束：" );
        }catch (Exception e){
            System.out.println("异常：" + e.getMessage());
        }
    }
}
