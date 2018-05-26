import java.util.Random;

public class Raumschiffrennen implements Runnable{
    private Raumschiff r= new Raumschiff();

    public static void main(String []args) {
        Raumschiffrennen rennen = new Raumschiffrennen();
        Thread t1= new Thread(rennen);
        t1.setName("R1");
        Thread t2= new Thread(rennen);
        t2.setName("R2");
        Thread t3= new Thread(rennen);
        t3.setName("R3");
        Thread [] threads = new Thread[3];
        threads[0] = t1;
        threads[1] = t2;
        threads[2] = t3;

        for(int i=0; i<threads.length; i++) {
            int startNummer = rennen.startreihenfolge();
            try{
                threads[startNummer].start();
            }
            catch (Exception e) {

                i--;
            }
        }
    }

    public int startreihenfolge() {
        int rand = 0;
        rand = (int) (Math.random()*3);
        return rand;
    }

    @Override
    public void run() {
        move();
    }

    public void move() {
        System.out.println(Thread.currentThread().getName() + " bewegt sich");
    }
    public void stop() {
        System.out.println("Ziel erreicht");
    }

}
