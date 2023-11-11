import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch extends JFrame implements ActionListener{

    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");

    JLabel timelabel = new JLabel();

    int elapsedTime = 0;    int seconds = 0;
    int minutes = 0;
    int hours = 0;

    boolean started = false;

    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener(){
        public void actionPerformed(ActionEvent e){

            elapsedTime = elapsedTime+1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) %60;
            seconds = (elapsedTime/1000) %60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timelabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        }

    });

    StopWatch(){

        timelabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        timelabel.setBounds(125,75,250,200);
        timelabel.setBackground(Color.PINK);
        timelabel.setFont(new Font("Comic Sans MS",Font.BOLD,35));
        timelabel.setBorder(BorderFactory.createBevelBorder(1));
        timelabel.setOpaque(true);
        timelabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(125,275,125,50);
        startButton.setFont(new Font("Comic Sans MS",Font.BOLD,25));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        resetButton.setBounds(250,275,125,50);
        resetButton.setFont(new Font("Comic Sans MS",Font.BOLD,25));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("StopWatch");
        this.setSize(500, 500);
        this.setLayout(null); 
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
        this.add(timelabel);
        this.add(startButton);
        this.add(resetButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton){ 
            if(!started){
                started = true;
                startButton.setText("STOP");
                start();
            }
            else{
                started = false;
                startButton.setText("START");
                stop();

            }
        }
        if(e.getSource()==resetButton){
            started = false;
            startButton.setText("START");
            reset();
        }
        
    }

    void start(){
        timer.start();

    }

    void stop(){
        timer.stop();
        

    }

    void reset(){
        timer.stop();

        elapsedTime=0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timelabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
    }
}
