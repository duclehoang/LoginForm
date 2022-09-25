import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Image;

public class LoginForm extends JFrame {

    private JPanel contentPane;
    private JTextField txtuser;
    private JPasswordField txtpassuser;
    private JPanel panel_2;
    private  JLabel lbl_mesage;

    private JLabel lblIConLogo, lblIconuser,lbliconpass;

    ImageIcon icon_logo=new ImageIcon("res/school.png");
    ImageIcon icon_user=new ImageIcon("res/user.png");
    ImageIcon icon_pass=new ImageIcon("res/keys.png");

    ImageIcon icon_login=new ImageIcon("res/agt_login.png");


    /**
     * Launch the application.
     *
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginForm frame = new LoginForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LoginForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setForeground(Color.WHITE);
        contentPane.setBackground(new Color(0, 191, 255));
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        setUndecorated(true);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(206, 116, 223, 44);
        contentPane.add(panel);
        panel.setLayout(null);

        txtuser = new JTextField();
        txtuser.setText("Tên đăng nhập");

        txtuser.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtuser.getText().equals("Tên đăng nhập")){
                    txtuser.setText("");
                }
                else {
                    txtuser.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtuser.getText().equals("")){
                    txtuser.setText("Tên đăng nhập");
                }
            }
        });
        txtuser.setBounds(10, 10, 163, 24);
        txtuser.setBorder(null);
        panel.add(txtuser);
        txtuser.setColumns(10);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(206, 195, 223, 44);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        txtpassuser = new JPasswordField();
        txtpassuser.setText("Mật khẩu");

        txtpassuser.setEchoChar((char) 0);
        txtpassuser.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtpassuser.getText().equals("Mật khẩu")){
                    txtpassuser.setEchoChar('*');
                    txtpassuser.setText("");
                }
                else {
                    txtpassuser.selectAll();
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtpassuser.getText().equals("")){
                    txtpassuser.setText("Mật khẩu");
                    txtpassuser.setEchoChar((char) 0);
                }
            }
        });
        txtpassuser.setBounds(10, 10, 163, 24);
        txtpassuser.setBorder(null);
        panel_1.add(txtpassuser);

        panel_2 = new JPanel();
        panel_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtuser.getText().equals("admin")&&txtpassuser.getPassword().equals("admin")){

                } else if (txtuser.getText().equals(" ")||txtuser.getText().equals("Tên đăng nhập")||txtpassuser.getText().equals(" ")||txtpassuser.getText().equals("Mật khẩu")) {

                    lbl_mesage.setText("Phải điền đủ thông tin");
                }
                else {
                    lbl_mesage.setText("Tên đăng nhập hoặc mật khẩu không đúng");
                }
            }
        });
        panel_2.setBackground(new Color(0, 0, 128));
        panel_2.setBounds(216, 277, 190, 44);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblLogin.setForeground(new Color(255, 255, 255));
        lblLogin.setBounds(74, 10, 93, 24);
        panel_2.add(lblLogin);

        JLabel lbl_X = new JLabel("X");
        lbl_X.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null,"Bạn có muốn thoát","Thoát chương trình",JOptionPane.YES_NO_OPTION)==0){
                   LoginForm.this.dispose();

                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lbl_X.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
              lbl_X.setForeground(Color.WHITE);
            }
        });
        lbl_X.setForeground(new Color(255, 255, 255));
        lbl_X.setToolTipText("Đóng");
        lbl_X.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl_X.setBounds(567, 10, 23, 13);
        contentPane.add(lbl_X);

        lblIConLogo = new JLabel("");
        lblIConLogo.setBounds(275, 34, 100, 68);
        lblIConLogo.setIcon(new ImageIcon(icon_logo.getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH)));
        contentPane.add(lblIConLogo);

        lblIconuser = new JLabel("");
        lblIconuser.setBounds(183, 10, 37, 24);
        lblIconuser.setIcon(new ImageIcon(icon_user.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT)));
        panel.add( lblIconuser);

        JLabel lblpass = new JLabel("");
        lblpass.setBounds(176, 9, 37, 24);
        lblpass.setIcon(new ImageIcon(icon_pass.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT)));
        panel_1.add(lblpass);

        lbl_mesage = new JLabel("");
        lbl_mesage.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lbl_mesage.setBounds(212, 249, 250, 13);
        lbl_mesage.setForeground(Color.RED);

        contentPane.add(lbl_mesage);

    }
}
