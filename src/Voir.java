import java.awt.event.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Created by JFormDesigner on Tue Mar 01 09:19:55 CET 2022
 */
/**
 * @author Joly
 */
public class Voir extends JFrame {
    ArrayList<Voiture> listNeufs;
    ArrayList<Occasion> listOccasions;
    Voiture neuf = null;
    Occasion occasion = null;
    String type;
    String currentImmatriculation;
    ArrayList<String> listImatriculation;
    int index = 0;

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

    private void list1KeyPressed(KeyEvent e) {

        occasion = null;
        neuf = null;

        int keyCode = e.getKeyCode();
//        int index = -1;

        Voiture v = new Voiture();
        Occasion o = new Occasion();

        var listWithNeufAndOccasions = new ArrayList<>();
        listWithNeufAndOccasions.addAll(listNeufs);
        listWithNeufAndOccasions.addAll(listOccasions);


        if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("Fleche de droite");

            if (type.equals("list occasion")) {
                System.out.println("oc");

                index += 1;
                if (listOccasions.size() == index) {
                    index = 0;
                }

                occasion = listOccasions.get(index);
                currentImmatriculation = neuf.getImmatriculation();
            } else if (type.equals("list neuf")) {
                System.out.println("ne");

                index += 1;
                if (listNeufs.size() == index) {
                    index = 0;
                }

                neuf = listNeufs.get(index);
                currentImmatriculation = neuf.getImmatriculation();
            }  else if (type.equals("list all")) {
                System.out.println("ne");
                index += 1;
                if (listWithNeufAndOccasions.size() == index) {
                    index = 0;
                }

                var neufOfOccasions = listWithNeufAndOccasions.get(index);
                if (neufOfOccasions.getClass() == Voiture.class) {
                    neuf = (Voiture)neufOfOccasions;
                    currentImmatriculation = neuf.getImmatriculation();
                }
                if (neufOfOccasions.getClass() == Occasion.class) {
                    occasion = (Occasion)neufOfOccasions;
                    currentImmatriculation = occasion.getImmatriculation();
                }
            }
        } else if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("Fleche de gauche");

            if (type.equals("list occasion")) {
                System.out.println("oc");

                index -= 1;
                if (index == 0) {
                    index = listOccasions.size() -1;
                }

                occasion = listOccasions.get(index);
                currentImmatriculation = neuf.getImmatriculation();
            } else if (type.equals("list neuf")) {
                System.out.println("ne");

                index -= 1;
                if (index < 0) {
                    index = listNeufs.size() -1;
                }

                neuf = listNeufs.get(index);
                currentImmatriculation = neuf.getImmatriculation();
            } else if (type.equals("list all")) {
                System.out.println("ne");

                index -= 1;
                if (index < 0) {
                    index = listWithNeufAndOccasions.size() -1;
                }

                var neufOfOccasions = listWithNeufAndOccasions.get(index);
                if (neufOfOccasions.getClass() == Voiture.class) {
                    neuf = (Voiture)neufOfOccasions;
                    currentImmatriculation = neuf.getImmatriculation();
                }
                if (neufOfOccasions.getClass() == Occasion.class) {
                    occasion = (Occasion)neufOfOccasions;
                    currentImmatriculation = occasion.getImmatriculation();
                }
            }

        } else {
            System.out.println("Non reconnu");
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
            list1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    list1KeyPressed(e);
                }
            });
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
        index = list1.getSelectedIndex();

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
                neuf = v.getVoitureNeufOrOccasion(listNeufs, element.toString());

                if (occasion != null) {
                    currentImmatriculation = occasion.getImmatriculation();
                } else if (neuf != null) {
                    currentImmatriculation = neuf.getImmatriculation();
                }

                break;
            case "list occasion" :
                occasion = o.getVoitureOccasion(listOccasions, element.toString());
                currentImmatriculation = occasion.getImmatriculation();
                break;
            case "list neuf" :
                neuf = v.getVoitureNeuf(listNeufs, element.toString());
                currentImmatriculation = neuf.getImmatriculation();
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
