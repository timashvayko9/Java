import javax.swing.*;
import java.awt.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.jar.JarEntry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatUPD  extends JFrame {

    private JTextArea taMain;
    private JTextField tfMsg;

    private final String FRM_TITTLE = "Our Tiny Chat";
    private final int FRM_LOC_X = 100;
    private final int FRM_LOC_Y = 100;
    private final int FRM_WIDTH =400;
    private final int FRM_HEIGHT = 400;

    private final int PORT = 9876;
    private final String IP_BROADCAST = "172.18.0.255";


    private class thdReciever extends Thread{
        @Override
        public  void  start(){
            super.start();
            try{
                customize();
            } catch (Exception ex){
                ex.printStackTrace();
            }

        }

        private void customize() throws Exception{
            DatagramSocket receiveSocket = new DatagramSocket(PORT);
            Pattern regex = Pattern.compile("[\u0020-\uFFFF]");

            while(true){
                byte[] recieveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(recieveData,recieveData.length);
                receiveSocket.receive(receivePacket);
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                String sentence = new String(receivePacket.getData());
                Matcher m = regex.matcher(sentence);

                taMain.append(IPAddress.toString()+";"+ port+":");
                while(m.find())
                    taMain.append(sentence.substring(m.start(),m.end()));
                taMain.append("\r\n");
            }
        }
    }

    private void btnSend_Handler()throws  Exception{
        DatagramSocket sendSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName(IP_BROADCAST);
        byte[] sendData;
        String sentence = tfMsg.getText();
        tfMsg.setText("");
        sendData = sentence.getBytes("UTF-8");
        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,PORT);
        sendSocket.send(sendPacket);
    }

    private void frameDraw(JFrame frame){
        tfMsg = new JTextField();
        taMain = new JTextArea(FRM_HEIGHT/19,50);
        JScrollPane spMain = new JScrollPane(taMain);
        spMain.setLocation(0,0);
        taMain.setLineWrap(true);
        taMain.setEditable(false);

        JButton btnSend = new JButton();
        btnSend.setText("Send");
        btnSend.setToolTipText("Broadcast a message");
        btnSend.addActionListener(e ->{
            try{
                btnSend_Handler();
            }catch(Exception ex){
                ex.printStackTrace();
            }


        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(FRM_TITTLE);
        frame.setLocation(FRM_LOC_X,FRM_LOC_Y);
        frame.setSize(FRM_WIDTH,FRM_HEIGHT);
        frame.setResizable(false);
        frame.getContentPane().add(BorderLayout.NORTH,spMain);
        frame.getContentPane().add(BorderLayout.CENTER,tfMsg);
        frame.getContentPane().add(BorderLayout.EAST,btnSend);
        frame.setVisible(true);
    }

    private void antistatic(){
        frameDraw(new ChatUPD());
        new thdReciever().start();
    }

    public static void main(String[] args) {
        new ChatUPD().antistatic();
    }
}
