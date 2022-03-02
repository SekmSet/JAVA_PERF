import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
/*
 * Created by JFormDesigner on Tue Mar 01 09:19:45 CET 2022
 */

/**
 * @author Joly
 */
public class Ajouter extends JFrame {

    private final String colorRed = "#CD1818";

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Joly
    private JLabel label1;
    private JButton button2;
    private JLabel label9;
    private JTextField textField8;
    private JLabel span16;
    private JLabel label2;
    private JTextField textField1;
    private JLabel span9;
    private JLabel label3;
    private JTextField textField2;
    private JLabel span10;
    private JLabel label4;
    private JTextField textField3;
    private JLabel span11;
    private JLabel label5;
    private JTextField textField4;
    private JLabel span12;
    private JLabel label6;
    private JTextField textField5;
    private JLabel span13;
    private JLabel label7;
    private JTextField textField6;
    private JLabel span14;
    private JLabel label8;
    private JTextField textField7;
    private JLabel span15;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Ajouter frame = new Ajouter();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public Ajouter() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Joly
        label1 = new JLabel();
        button2 = new JButton();
        label9 = new JLabel();
        textField8 = new JTextField();
        span16 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        span9 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        span10 = new JLabel();
        label4 = new JLabel();
        textField3 = new JTextField();
        span11 = new JLabel();
        label5 = new JLabel();
        textField4 = new JTextField();
        span12 = new JLabel();
        label6 = new JLabel();
        textField5 = new JTextField();
        span13 = new JLabel();
        label7 = new JLabel();
        textField6 = new JTextField();
        span14 = new JLabel();
        label8 = new JLabel();
        textField7 = new JTextField();
        span15 = new JLabel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[184,fill]" +
            "[264,fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[108]"));

        //---- label1 ----
        label1.setText("GARAGE VAULVAU");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 10f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(new Color(0, 0, 153));
        contentPane.add(label1, "cell 0 0 2 1");

        //---- button2 ----
        button2.setText("Quitter");
        button2.addActionListener(e -> quitterAddButton(e));
        contentPane.add(button2, "cell 2 0");

        //---- label9 ----
        label9.setText("Immatriculation");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getStyle() | Font.BOLD, label9.getFont().getSize() + 3f));
        contentPane.add(label9, "cell 0 1");
        contentPane.add(textField8, "cell 1 1");
        contentPane.add(span16, "cell 0 2 2 1");

        //---- label2 ----
        label2.setText("Marque");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 3f));
        contentPane.add(label2, "cell 0 3");
        contentPane.add(textField1, "cell 1 3");

        //---- span9 ----
        span9.setFont(span9.getFont().deriveFont(span9.getFont().getStyle() | Font.ITALIC, span9.getFont().getSize() + 1f));
        contentPane.add(span9, "cell 0 4 3 1");

        //---- label3 ----
        label3.setText("Mod\u00e8le");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 3f));
        contentPane.add(label3, "cell 0 5");
        contentPane.add(textField2, "cell 1 5");

        //---- span10 ----
        span10.setFont(span10.getFont().deriveFont(span10.getFont().getStyle() | Font.ITALIC, span10.getFont().getSize() + 1f));
        contentPane.add(span10, "cell 0 6 3 1");

        //---- label4 ----
        label4.setText("Kilom\u00e9trage");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD, label4.getFont().getSize() + 3f));
        contentPane.add(label4, "cell 0 7");
        contentPane.add(textField3, "cell 1 7");

        //---- span11 ----
        span11.setFont(span11.getFont().deriveFont(span11.getFont().getStyle() | Font.ITALIC, span11.getFont().getSize() + 1f));
        contentPane.add(span11, "cell 0 8 3 1");

        //---- label5 ----
        label5.setText("Prix");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD, label5.getFont().getSize() + 3f));
        contentPane.add(label5, "cell 0 9");
        contentPane.add(textField4, "cell 1 9");

        //---- span12 ----
        span12.setFont(span12.getFont().deriveFont(span12.getFont().getStyle() | Font.ITALIC, span12.getFont().getSize() + 1f));
        contentPane.add(span12, "cell 0 10 3 1");

        //---- label6 ----
        label6.setText("Dur\u00e9e de vie");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD, label6.getFont().getSize() + 3f));
        contentPane.add(label6, "cell 0 11");
        contentPane.add(textField5, "cell 1 11");

        //---- span13 ----
        span13.setFont(span13.getFont().deriveFont(span13.getFont().getStyle() | Font.ITALIC, span13.getFont().getSize() + 1f));
        contentPane.add(span13, "cell 0 12 3 1");

        //---- label7 ----
        label7.setText("Date premier achat");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD, label7.getFont().getSize() + 3f));
        contentPane.add(label7, "cell 0 13");
        contentPane.add(textField6, "cell 1 13");

        //---- span14 ----
        span14.setFont(span14.getFont().deriveFont(span14.getFont().getStyle() | Font.ITALIC, span14.getFont().getSize() + 1f));
        contentPane.add(span14, "cell 0 14 3 1");

        //---- label8 ----
        label8.setText("Date revente");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getStyle() | Font.BOLD, label8.getFont().getSize() + 3f));
        contentPane.add(label8, "cell 0 15");
        contentPane.add(textField7, "cell 1 15");

        //---- span15 ----
        span15.setFont(span15.getFont().deriveFont(span15.getFont().getStyle() | Font.ITALIC, span15.getFont().getSize() + 1f));
        contentPane.add(span15, "cell 0 16 3 1");

        //---- button1 ----
        button1.setText("VALIDER");
        button1.addActionListener(e -> {
            try {
                addVehiculeButton(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        });
        contentPane.add(button1, "cell 0 18 3 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void quitterAddButton(ActionEvent e) {
        // TODO add your code here
    }

    private boolean addVehiculeButton(ActionEvent e) throws SQLException, ParseException {
        // string
        String immatriculation = textField8.getText();
        String marque = textField1.getText();
        String modele = textField2.getText();

        // convert to int
        String kilometrage = textField3.getText();
        String dureeDeVie = textField5.getText();

        // convert to decimal
        String prix = textField4.getText();

        // convert to date
        String datePremierAchat = textField6.getText();
        String dateRevente = textField6.getText();

        boolean error = false;

        if(immatriculation.equals("")) {
            span16.setText("Champ obligatoire.");
            span9.setForeground(Color.decode(this.colorRed));

            error = true;
        }

        if(marque.equals("")) {
            span9.setText("Champ obligatoire.");
            span9.setForeground(Color.decode(this.colorRed));

            error = true;
        }

        if(!Objects.equals(kilometrage, "0") && (datePremierAchat.equals("") || dateRevente.equals(""))) {
            span14.setText("Champ obligatoire.");
            span15.setText("Champ obligatoire.");

            span14.setForeground(Color.decode(this.colorRed));
            span15.setForeground(Color.decode(this.colorRed));

            error = true;
        } else if(modele.equals("")) {
            span10.setText("Champ obligatoire.");
            span10.setForeground(Color.decode(this.colorRed));

            error = true;
        } else if (kilometrage.equals("")) {
            span11.setText("Champ obligatoire.");
            span11.setForeground(Color.decode(this.colorRed));

            error = true;
        } else if (prix.equals("")) {
            span12.setText("Champ obligatoire.");
            span12.setForeground(Color.decode(this.colorRed));

            error = true;
        }

        if (error) {
            return false;
        }

        if (kilometrage.equals("0")) {
            Voiture v = new Voiture(
                    immatriculation,
                    marque,
                    modele,
                    parseInt(kilometrage),
                    parseFloat(prix)
            );

            v.createVoiture(v);
        } else {
            Date convertToDatePremierAchat = new SimpleDateFormat("dd/MM/yyyy").parse(datePremierAchat);
            Date convertToDateRevente = new SimpleDateFormat("dd/MM/yyyy").parse(dateRevente);

            System.out.println(convertToDatePremierAchat);
            System.out.println(convertToDateRevente);

            Occasion o = new Occasion(
                    immatriculation,
                    marque,
                    modele,
                    parseInt(kilometrage),
                    parseFloat(prix),
                    parseInt(dureeDeVie),
                    convertToDatePremierAchat,
                    convertToDateRevente
            );

            o.createOccasion(o);
        }

        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");

        return true;
    }
}