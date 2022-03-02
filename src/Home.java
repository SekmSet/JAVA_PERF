import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
/*
 * Created by JFormDesigner on Tue Mar 01 09:14:35 CET 2022
 */

/**
 * @author Joly
 */
public class Home extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Home frame = new Home();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Home() {
        initComponents();
    }

    private void addVehiculeButton(ActionEvent e) {
        Ajouter a = new Ajouter();
        a.setVisible(true);
    }

    private void listVehiculesButton(ActionEvent e) throws SQLException {
        Voir l = new Voir();
        l.setVisible(true);
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Joly
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setBackground(new Color(0, 0, 153));
        setForeground(SystemColor.textHighlight);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[582,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("GARAGE VAULVAU");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 10f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(new Color(0, 0, 153));
        contentPane.add(label1, "cell 0 0 3 1");

        //---- button1 ----
        button1.setText("AJOUTER UN VEHICULE");
        button1.addActionListener(e -> {
			button1(e);
			addVehiculeButton(e);
		});
        contentPane.add(button1, "cell 0 2 3 1");

        //---- button2 ----
        button2.setText("VOIR TOUS LES VEHICULES");
        button2.addActionListener(e -> {
            try {
                listVehiculesButton(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(button2, "cell 0 3 3 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Joly
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
