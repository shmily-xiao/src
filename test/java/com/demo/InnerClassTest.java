package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by simpletour_java on 2015/6/2.
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

        new ArrayList<String>(){
            {
                add("ssf");
                add("gfg");
            }
        };
    }
}
    class TalkingClock{
        private int interval;
        private boolean beep;

        public TalkingClock(int interval,boolean beep){
            this.interval = interval;
            this.beep = beep;
        }

        public void start(){

            ActionListener listener  = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Date now = new Date();
                    System.out.println("At the tone, the time is "+ now);
                    if(beep) Toolkit.getDefaultToolkit().beep();
                }
            };
//            ActionListener listener2 = new TimePrinter();
            Timer t = new Timer(interval,listener);
            t.start();
        }

//        public class TimePrinter implements ActionListener{
//
//            public void actionPerformed(ActionEvent event){
//                Date now = new Date();
//                System.out.println("At the tone, the time is "+ now);
//                if(beep) Toolkit.getDefaultToolkit().beep();
//            }
//        }
    }
