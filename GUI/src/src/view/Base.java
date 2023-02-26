package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Base {
//    It is a reference class that has initialized main and common properties
//    for the majority of the widgets used in the application.
        static class ShowPassword extends JButton {
//            It sets all the properties required for the functionality to show password.
            ImageIcon show = new ImageIcon("Public\\Show.png");

            LineBorder lineBorder =new LineBorder(Color.decode("#202A44"), 2, true);

            ShowPassword(int x, int y, int width, int height){
                setIcon(show);
                setBorder(lineBorder);
                setAlignmentX(CENTER_ALIGNMENT);
                setAlignmentY(CENTER_ALIGNMENT);
                setForeground(Color.decode("#202A44"));
                setBounds(x,y,width,height);
                setBackground(Color.white);
                setEnabled(false);
                setDisabledIcon(show);
            }
        }

        public static class Button extends JButton{
            //            It sets all the properties required for the basic buttons.
            LineBorder lineBorder =new LineBorder(Color.decode("#202A44"), 2, true);

            public Button(String text, int fontSize, int x, int y, int width, int height){
                setText(text);
                setFont(new Font("Poppins",Font.BOLD,fontSize));
                setAlignmentX(CENTER_ALIGNMENT);
                setAlignmentY(CENTER_ALIGNMENT);
                setBounds(x,y,width,height);
                setBackground(Color.decode("#202A44"));
                setForeground(Color.white);
                setBorder(lineBorder);
            }
        }
    public static class IconButton extends JButton{
        //            It sets all the properties required for the buttons with icon images.
        LineBorder lineBorder =new LineBorder(Color.GRAY, 2, true);

        public IconButton( int fontSize, int x, int y, int width, int height){
            setBorder(lineBorder);
            setAlignmentX(CENTER_ALIGNMENT);
            setAlignmentY(CENTER_ALIGNMENT);
            setBounds(x,y,width,height);
            setBackground(Color.GRAY);
            setEnabled(false);
        }
    }

        static class Label extends JLabel{
            //            It sets all the properties required for the basic labels.
            Label(String text, String fontName, int fontSize, int x, int y, int width, int height){
                setText(text);
                setForeground(Color.decode("#202A44"));
                setFont(new Font(fontName,Font.BOLD,fontSize));
                setBounds(x,y,width,height);
            }
            Label(String text, int fontSize){
                setText(text);
                setHorizontalAlignment(SwingConstants.CENTER);
                setForeground(Color.decode("#ffffff"));
                setFont(new Font("Hornbill",Font.BOLD,fontSize));
                setBackground(Color.decode("#202A44"));
                setBounds(85, 0, 298, 73);
            }
        }

        public static class TextField extends JTextField {
            //            It sets all the properties required for the basic text fields.
            LineBorder lineBorder = new LineBorder(Color.decode("#202A44"), 2, true);

            public TextField(String placeholder, int fontSize, int x, int y, int width, int height) {
                setText(placeholder);
                setFont(new Font("Poppins", Font.PLAIN, fontSize));
                setBounds(x, y, width, height);
                setForeground(Color.decode("#27445C"));
                setBorder(lineBorder);
                setBorder(BorderFactory.createCompoundBorder(
                        getBorder(),
                        BorderFactory.createEmptyBorder(5, 8, 5, 5)));
                addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (getText().equals(placeholder)) {
                            setText("");
                            setForeground(Color.decode("#202A44"));
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        if (getText().isEmpty()) {
                            setForeground(Color.decode("#202A44"));
                            setText(placeholder);
                        }
                    }
                });
            }

            TextField(String placeholder, String text, int x, int y, int width, int height) {
                setText(text);
                setFont(new Font("Poppins", Font.PLAIN, 16));
                setBounds(x, y, width, height);
                setForeground(Color.decode("#202A44"));
                setBorder(lineBorder);
                setBorder(BorderFactory.createCompoundBorder(
                        getBorder(),
                        BorderFactory.createEmptyBorder(5, 8, 5, 5)));
                addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (getText().equals(placeholder)) {
                            setText("");
                            setForeground(Color.decode("#202A44"));
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        if (getText().isEmpty()) {
                            setForeground(Color.decode("#202A44"));
                            setText(placeholder);
                        }
                    }
                });
            }

            TextField(String placeholder, int fontSize, int x, int y, int width, int height, JButton nextButton) {
                setText(placeholder);
                setFont(new Font("Poppins", Font.PLAIN, fontSize));
                setBounds(x, y, width, height);
                setForeground(Color.decode("#202A44"));
                setBorder(lineBorder);
                setBorder(BorderFactory.createCompoundBorder(
                        getBorder(),
                        BorderFactory.createEmptyBorder(5, 8, 5, 5)));
                addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (getText().equals(placeholder)) {
                            nextButton.setEnabled(true);
                            setText("");
                            setForeground(Color.decode("#202A44"));
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        if (getText().isEmpty()) {
                            nextButton.setEnabled(false);
                            setForeground(Color.decode("#27445C"));
                            setText(placeholder);
                        }
                    }
                });
            }
        }

        static class PasswordField extends JPasswordField {
            //            It sets all the properties required for the password fields.
            LineBorder lineBorder =new LineBorder(Color.decode("#202A44"), 2, true);

            PasswordField(String placeholder,int fontSize, int x, int y, int width, int height, JButton showPasswordButton){
                setText(placeholder);
                setEchoChar((char)0);
                setFont(new Font("Poppins",Font.PLAIN,fontSize));
                setBounds(x,y,width,height);
                setForeground(Color.decode("#27445C"));
                setBorder(lineBorder);
                setBorder(BorderFactory.createCompoundBorder(
                        getBorder(),
                        BorderFactory.createEmptyBorder(5, 8, 5, 5)));
                addFocusListener(new FocusListener() {

                    @Override
                    public void focusGained(FocusEvent e) {
                        String pass = String.copyValueOf(getPassword());
                        if (pass.equals(placeholder)) {
                            showPasswordButton.setEnabled(true);
                            setEchoChar('\u25cf');
                            setText("");
                            setForeground(Color.decode("#202A44"));
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        String pass = String.copyValueOf(getPassword());
                        if (pass.isEmpty()) {
                            showPasswordButton.setEnabled(false);
                            setEchoChar((char)0);
                            setForeground(Color.decode("#27445C"));
                            setText(placeholder);
                        }
                    }}
                );
            }
        }
}


