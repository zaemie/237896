public class MySleep extends Thread {

    public static void main(String[] args) {
        new Thread(new MySleep()).start();
    }

    @Override
    public void run() {
        try {
            for (int x = 0; x < 10500; x++) {
                System.out.println(x);
                sleep(5000);
                
                if((x%50==0)&&(x!=0)){
                    System.out.println("String");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}