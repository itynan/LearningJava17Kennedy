package concurrency.creating_threads;
class Countdown implements Runnable{
    String [] timeStr  = {"zero", "one", "two", "three", "four"
            , "five", "six", "seven", "eight", "nine"};

    @Override
    public void run(){
        for (int i = 9 ; i >= 0 ; i--) {
            try{
                System.out.println(timeStr[i]);
                Thread.sleep(500);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}
public class TimedCountdown{
    public static void main(String[] args) {
        Thread timer = new Thread(new Countdown());
        System.out.println("Starting 10 second count down...");
        timer.start();
        try{
            timer.join();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("Blast off!!!");
    }
}
