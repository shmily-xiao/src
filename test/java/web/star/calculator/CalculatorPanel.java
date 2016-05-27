package web.star.calculator;

    import java.awt.BorderLayout;
    import java.awt.GridLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.JButton;
    import javax.swing.JPanel;
    import javax.swing.JTextField;

    /**
     * 目的：这是用来创建一个计算器的面板的，里面的好多理念值得学习啊，待会会仔细指出的，学习了
     * @author sornor
     * @version 1.0
     */
    public class CalculatorPanel extends JPanel{
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private JPanel panel;
        private JTextField display;
        private String lastCommend;			//这是用来指定操作符的变量，想法不错哟！！
        private boolean start;			//在开始阶段会产生很多不同的情况，所以要仔细的定位处理le
        private double result;			//这是最后的结果了

        public CalculatorPanel() {

            panel = new JPanel();
            setLayout(new BorderLayout());		//边框布局了

            display = new JTextField("0",10);
            display.setHorizontalAlignment(display.RIGHT);
            this.add(display,BorderLayout.NORTH);
            lastCommend = "=";
            result = 0;
            start = true;

            panel.setLayout(new GridLayout(4,4,10,10));
            ActionListener insert = new InsertActionListener();
            ActionListener commend = new CommendActionListener();

            this.addButton("7", insert);
            this.addButton("8", insert);
            this.addButton("9", insert);
            this.addButton("+", commend);


            this.addButton("4", insert);
            this.addButton("5", insert);
            this.addButton("6", insert);
            this.addButton("-", commend);


            this.addButton("1", insert);
            this.addButton("2", insert);
            this.addButton("3", insert);
            this.addButton("*", commend);


            this.addButton("0", insert);
            this.addButton(".", insert);
            this.addButton("=", commend);
            this.addButton("/", commend);

            this.add(panel,BorderLayout.CENTER);
            panel.setVisible(true);
        }

        public void addButton(String label,ActionListener listener) {
            JButton button = new JButton(label);
            button.addActionListener(listener);
            panel.add(button);
        }

        class InsertActionListener implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                String input = e.getActionCommand();		//获得按钮上的字符串了e
                if(start == true) {
                    display.setText("");
                    start = false;
                }
                display.setText(display.getText()+input);
            }
        }

        class CommendActionListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                String commend = e.getActionCommand();
                if(start == true) {

                    if(commend.equals("-")) {
                        display.setText(commend);
                        start = false;
                    }
                    else {
                        lastCommend = commend;
                    }
                }
                else {
                    calculator(Double.parseDouble(display.getText()));
                    lastCommend = commend;
                    start = true;
                }
            }
        }

        public void calculator (double temp) {
            if(lastCommend.equals("+")) result += temp;
            else if(lastCommend.equals("-")) result -= temp;
            else if(lastCommend.equals("*")) result *= temp;
            else if(lastCommend.equals("/")) result /= temp;
            else result = temp;
            display.setText(""+result);

        }
    }


