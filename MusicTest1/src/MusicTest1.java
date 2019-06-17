import javax.sound.midi.*;


public class MusicTest1 {


    public static void main(String[] args)  {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }
    public void play()  {
        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("We get sintazator");
        } catch(MidiUnavailableException ex){
            System.out.println("fail");
        }
    }
}
