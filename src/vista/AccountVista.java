package vista;

import javax.swing.*;
import java.awt.*;

public class AccountVista {
    private JPanel PanelPrincipal;
    private JPanel PanelSuperior;
    private JPanel PanelInferior;
    private JLabel Account;
    private JButton annadirButton;
    private JButton actualizarButton;
    private JButton borrarButton;
    private JTable table1;
    private JPanel PanelDerecho;
    private JTextField iban;
    private JTextField creditCard;
    private JTextField balance;
    private JTextField fullName;
    private JButton aceptarButton;
    private JButton cancelarButton;

    public JTextField getIban() {
        return iban;
    }

    public JTextField getCreditCard() {
        return creditCard;
    }

    public JTextField getBalance() {
        return balance;
    }

    public JTextField getFullName() {
        return fullName;
    }

    public JButton getAceptarButton() {
        return aceptarButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JTable getTable1() {
        return table1;
    }

    public JPanel getPanelDerecho() {
        return PanelDerecho;
    }

    public JButton getAnnadirButton() {
        return annadirButton;
    }

    public JButton getBorrarButton() {
        return borrarButton;
    }

    public AccountVista() {
        JFrame frame = new JFrame("Cuenta");
        frame.setContentPane(PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(dimension.width/2,dimension.height/2);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        PanelDerecho.setVisible(false);
    }
}
