package Control;

/**
 * Created by smrut on 11/1/2017.
 */
public class Processor extends Thread {
    int num;
    int tNum;
    public Processor(int num,int tNum){
        this.num=num;
        this.tNum=tNum;
    }

    @Override
    public void run() {
        System.out.println("Thread" + tNum + "started");
        for (int i = 0; i <num ; i++) {
            Boolean isPrime=true;
            for (int j = 2; j < i; j++) {
                if(i%j==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){

                System.out.println("Thread "+ tNum +" " + i+" ");
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread" + tNum + "ended");


    }


}
