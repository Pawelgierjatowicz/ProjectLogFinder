package LogFinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Gui extends JPanel {

    /**
     * Creates new form LogFind
     */
    public Gui() {
        initComponents();
    }
    static boolean click = false;
    boolean Showtext = false;
    boolean CopyFile = false;
    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JRadioButton jRadioButton1 = new JRadioButton();
        JRadioButton jRadioButton2 = new JRadioButton();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel5 = new JLabel();
        jButton1 = new JButton();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();



        setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jRadioButton1.setText("Do you want to copy found text ?");
        jRadioButton1.setOpaque(false);
        jRadioButton1.setForeground(new Color(255, 255, 255));
        jRadioButton1.addActionListener(this::jRadioButton1ActionPerformed);
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(740, 260, 250, 23);
        jRadioButton2.setText("Do you want to copy found files ?");
        jRadioButton2.setOpaque(false);
        jRadioButton2.setForeground(new Color(255, 255, 255));
        jRadioButton2.addActionListener(this::jRadioButton2ActionPerformed);
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(740, 220, 250, 23);

        jTextField2.addActionListener(this::jTextField2ActionPerformed);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(39, 205, 598, 45);

        jTextField3.addActionListener(this::jTextField3ActionPerformed);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(39, 300, 598, 45);

        jTextField4.addActionListener(evt -> jTextField4ActionPerformed());
        jTextField4.setVisible(false);

        jTextField5.addActionListener(evt -> jTextField5ActionPerformed());
        jPanel1.add(jTextField5);
        jTextField5.setBounds(39, 395, 598, 45);
        jButton1.addActionListener(evt -> jButton1ActionPerformed());



        jPanel1.add(jTextField4);
        jTextField4.setBounds(800, 360, 74, 60);

        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("How many lines ?");
        jLabel1.setVisible(false);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(780, 320, 120, 29);

        jLabel2.setFont(new Font("SansSerif", Font.PLAIN, 18)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Set the location, where the files can be found:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 155, 395, 60);

        jLabel3.setFont(new Font("SansSerif", Font.PLAIN, 18)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("Set the destination location:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 250, 281, 55);

        jLabel7.setFont(new Font("SansSerif", Font.PLAIN, 18)); // NOI18N
        jLabel7.setForeground(new Color(255, 255, 255));
        jLabel7.setText("What words should the file contain");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 345, 395, 60);

        jLabel5.setFont(new Font("SansSerif", Font.PLAIN, 48)); // NOI18N
        jLabel5.setForeground(new Color(255, 153, 51));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("LogFinder");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(330, 10, 440, 130);

        jButton1.setFont(new Font("SansSerif", Font.PLAIN, 18)); // NOI18N
        jButton1.setText("Search");
        jPanel1.add(jButton1);
        jButton1.setBounds(80, 530, 929, 67);

        jLabel6.setIcon(new ImageIcon("C:\\Users\\ljjptq\\Downloads\\Space.jpg")); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 1120, 660);

        add(jPanel1);
        jPanel1.setBounds(0, 1, 1130, 670);

    }// </editor-fold>



    private void jButton1ActionPerformed(){
        click = true;
        System.out.println("Klik");
        jButton1.setEnabled(false);
    }

    private void jTextField5ActionPerformed(){

    }
    private void jTextField2ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField3ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField4ActionPerformed() {
        // TODO add your handling code here:
    }

    private void jRadioButton2ActionPerformed(ActionEvent evt) {
        CopyFile = !CopyFile;
    }

    private void jRadioButton1ActionPerformed(ActionEvent evt) {
        Showtext = !Showtext;
        showing();
    }
    public void showing(){
        if(Showtext){
            jTextField4.setVisible(true);
            jLabel1.setVisible(true);
        }
        else{
            jTextField4.setVisible(false);
            jLabel1.setVisible(false);
        }
    }
    public static String getText2(){
        return jTextField2.getText();
    }
    public static String getText3(){
        return jTextField3.getText();
    }
    public static int getText4() {
        return Integer.parseInt(jTextField4.getText());
    }
    public static String getText5(){
        return jTextField5.getText();
    }

    private JButton jButton1;
    private JLabel jLabel1;
    private static JTextField jTextField2;
    private static JTextField jTextField3;
    private static JTextField jTextField4;
    private static JTextField jTextField5;
    // End of variables declaration
}
