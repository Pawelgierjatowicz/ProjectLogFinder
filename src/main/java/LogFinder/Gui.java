package LogFinder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

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
        jLabel4 = new JLabel();
        pbar = new JProgressBar();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel5 = new JLabel();
        jButton1 = new JButton();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        setLayout(null);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);
        jLabel6.setOpaque(true);
        jLabel6.setLayout(null);

        jRadioButton1.setText("Do you want to copy found text ?");
        jRadioButton1.setOpaque(false);
        jRadioButton1.setForeground(new Color(255, 255, 255));
        jRadioButton1.addActionListener(this::jRadioButton1ActionPerformed);
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(740, 190, 250, 23);
        jRadioButton2.setText("Do you want to copy found files ?");
        jRadioButton2.setOpaque(false);
        jRadioButton2.setForeground(new Color(255, 255, 255));
        jRadioButton2.addActionListener(this::jRadioButton2ActionPerformed);
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(740, 150, 250, 23);


        jPanel1.add(jTextField2);
        jTextField2.setBounds(39, 205, 598, 45);


        jPanel1.add(jTextField3);
        jTextField3.setBounds(39, 300, 598, 45);


        jTextField4.setVisible(false);


        jPanel1.add(jTextField5);
        jTextField5.setBounds(39, 395, 598, 45);
        jButton1.addActionListener(evt -> jButton1ActionPerformed());

        jPanel1.add(jTextField4);
        jTextField4.setBounds(800, 250, 50, 40);

        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("How many lines ?");
        jLabel1.setVisible(false);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(780, 220, 120, 29);

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

        jLabel4.setFont(new Font("SansSerif", Font.PLAIN, 12)); // NOI18N
        jLabel4.setForeground(new Color(0,0,0));
        jLabel4.setBackground(new Color(255,255,255));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(700,330,300,150);
        jLabel4.setVisible(false);

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

        pbar.setMinimum(0);
        pbar.setBounds(80,590,929,30);
        pbar.setVisible(true);
        pbar.setOpaque(true);
        jPanel1.add(pbar);

        jButton1.setFont(new Font("SansSerif", Font.PLAIN, 18)); // NOI18N
        jButton1.setText("Search");
        jPanel1.add(jButton1);
        jButton1.setBounds(80, 500, 929, 67);

        jLabel6.setIcon(new ImageIcon(MyPanel())); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 1120, 660);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1130, 670);


    }
    private BufferedImage image;
    public BufferedImage MyPanel() {
        try {
            image = ImageIO.read(Objects.requireNonNull(Gui.class.getResource("/Space.jpg")));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return image;
    }


    private void jButton1ActionPerformed(){
        System.out.println("Klik");
        if(Data.assembledest().isEmpty() || Data.assembleinputwords().isEmpty() || Data.assemblesrcDir().isEmpty()){
            jLabel4.setText("One of the input values is empty");
            jLabel4.setVisible(true);
            jButton1.setPressedIcon(jButton1.getDisabledSelectedIcon());
        }
        else{
            jLabel4.setVisible(false);
            click = true;

        }
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
        try {
            Integer.parseInt(jTextField4.getText());
            return Integer.parseInt(jTextField4.getText());
        }
        catch (NumberFormatException e) {
                jLabel4.setText("The number of lines should be an integer");
                jLabel4.setVisible(true);
        }
        return 0;

    }
    public static String getText5(){
        return jTextField5.getText();
    }
    public static void clearing(){
            jTextField4.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField5.setText("");
            pbar.setMaximum(0);
    }

    private JLabel jLabel1;
    private static JLabel jLabel4;
    public static JProgressBar pbar;
    private static JButton jButton1;
    private static JTextField jTextField2;
    private static JTextField jTextField3;
    private static JTextField jTextField4;
    private static JTextField jTextField5;
    // End of variables declaration
}
