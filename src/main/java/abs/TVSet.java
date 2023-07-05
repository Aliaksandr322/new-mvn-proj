package abs;

public class TVSet implements Playable{
    @Override
    public void play() {
        System.out.println("Start showing");
    }

    @Override
    public void stop() {
        System.out.println("Stop showing");
    }
}
