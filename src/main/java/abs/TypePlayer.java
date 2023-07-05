package abs;

public class TypePlayer extends Player implements Playable{
    @Override
    public void play() {
        System.out.println("Start type record");
    }

    @Override
    public void stop() {
        System.out.println("Stop type record");
    }
}
