import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
/*
 * Created by JFormDesigner on Tue Mar 01 09:19:55 CET 2022
 */
/**
 * @author Joly
 */
public class Voir extends JFrame {
    ArrayList<Voiture> listNeufs;
    ArrayList<Occasion> listOccasions;
    Voiture neuf;
    Occasion occasion;
    String type;

    private final String colorRed = "#CD1818";

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Joly
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JLabel spanError;
    private JButton button4;
    private DefaultListModel listModel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Voir frame = new Voir();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Voir() throws SQLException {
        initComponents();
    }

    private void initComponents() throws SQLException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Joly
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        spanError = new JLabel();
        button4 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[293,fill]" +
            "[218,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
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
        button1.setText("QUITTER");
        button1.addActionListener(e -> quitterListButton(e));
        contentPane.add(button1, "cell 3 0");

        //---- button2 ----
        button2.setText("Neuve");
        button2.addActionListener(e -> {
            try {
                voirVoitureNeuve(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(button2, "cell 2 1");

        //---- button3 ----
        button3.setText("Occasion");
        button3.addActionListener(e -> {
            try {
                voirVoitureOccasion(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(button3, "cell 2 2");

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "i",
                    "\u00a7"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1, "cell 2 4 2 1");

        //---- spanError ----
        spanError.setFont(spanError.getFont().deriveFont(spanError.getFont().getStyle() | Font.ITALIC, spanError.getFont().getSize() + 3f));
        contentPane.add(spanError, "cell 2 5 2 1");

        //---- button4 ----
        button4.setText("Voir les d\u00e9tails");
        button4.addActionListener(e -> voirDetailsButton(e));
        contentPane.add(button4, "cell 2 6 2 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        getAll();
    }

    private void quitterListButton(ActionEvent e) {
        // TODO add your code here
    }

    private void voirDetailsButton(ActionEvent e) {
        int index = list1.getSelectedIndex();

        if(index == -1) {
            spanError.setText("Aucun élément sélectionner.");
            spanError.setForeground(Color.decode(this.colorRed));
            return;
        }

        Voiture v = new Voiture();
        Occasion o = new Occasion();

        var element = listModel.getElementAt(index);

        switch(type) {
            case "list all" :
                occasion = o.getVoitureNeufOrOccasion(listOccasions, element.toString());

                if (occasion == null) {
                    neuf = v.getVoitureNeufOrOccasion(listNeufs, element.toString());
                }

                break;
            case "list occasion" :
                occasion = o.getVoitureOccasion(listOccasions, element.toString());
                break;
            case "list neuf" :
                neuf = v.getVoitureNeuf(listNeufs, element.toString());
                break;
        }

        listModel = new DefaultListModel();

        if(neuf != null) {
            listModel.addElement(neuf);
        }

        if(occasion != null) {
            listModel.addElement(occasion);
        }

        list1.setModel(listModel);
    }

    private void voirVoitureNeuve(ActionEvent e) throws SQLException {
        Voiture voitures = new Voiture();
        listNeufs = voitures.getVoituresNeufs();

        if(listNeufs != null) {
            listModel = new DefaultListModel();

            for(Voiture v : listNeufs) {
                listModel.addElement(v.getImmatriculation());
            }

            list1.setModel(listModel);

            type = "list neuf";
        }
    }

    private void voirVoitureOccasion(ActionEvent e) throws SQLException {
        Occasion occasions = new Occasion();
        listOccasions = occasions.getVoituresOccasions();

        if(listOccasions != null) {
            listModel = new DefaultListModel();

            for(Occasion o : listOccasions) {
                listModel.addElement(o.getImmatriculation());
            }

            list1.setModel(listModel);
            type = "list occasion";

        }
    }

    private void getAll () throws SQLException {
        Voiture voitures = new Voiture();
        Occasion occasions = new Occasion();
        listNeufs = voitures.getVoituresNeufs();
        listOccasions = occasions.getVoituresOccasions();
        listModel = new DefaultListModel();

        if(listNeufs != null && listOccasions != null) {

            for(Voiture v : listNeufs) {
                listModel.addElement(v.getImmatriculation());
            }
            list1.setModel(listModel);

            for(Occasion o : listOccasions) {
                listModel.addElement(o.getImmatriculation());
            }
            list1.setModel(listModel);
            type = "list all";
        }
    }
}
