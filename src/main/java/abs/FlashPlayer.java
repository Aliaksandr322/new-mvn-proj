package abs;

public class FlashPlayer extends Player implements Playable{

    @Override
    public void play() {
        System.out.println("Start track from memory");
    }

    @Override
    public void stop() {
        System.out.println("Stop track from memory ");
    }
}
