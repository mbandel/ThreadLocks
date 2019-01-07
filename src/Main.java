public class Main {

    public static void main(String[] args){
        if (args[0].equals("livelock")) {
            Livelock livelock = new Livelock();
            livelock.start();
        }else if (args[0].equals("deadlock")) {
            Deadlock deadlock = new Deadlock();
            deadlock.start();
        }else if(args[0].equals("starvation")){
            Starvation starvation = new Starvation();
            starvation.start();
        }else System.out.println("Wrong argument, try again.");


    }

}

