package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Voiture extends Database {

    private String immatriculation;
    private String marque;
    private String modele;
    private int kilometrage;
    private float prix;

    public Voiture() {
        super();
    }

    public Voiture(
        String immatriculation,
        String marque,
        String modele,
        int kilometrage,
        float prix
    ) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.kilometrage = kilometrage;
        this.prix = prix;
    }

    public static void main(String[] args) {

    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void afficherDonnees (Voiture voiture) {
        System.out.println("Model.Voiture matriculation : " + voiture.getImmatriculation());
        System.out.println("Model.Voiture marque : " + voiture.getMarque());
        System.out.println("Model.Voiture modèle : " + voiture.getModele());
        System.out.println("Model.Voiture kilométrage : " + voiture.getKilometrage() + " KM");
        System.out.println("Model.Voiture prix de vente : " + voiture.getPrix() + " €");
    }

    @Override
    public String toString() {
        return "Model.Voiture{" +
                "marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", kilometrage=" + kilometrage +
                ", prix=" + prix +
                '}';
    }

    public ArrayList<Voiture> getVoituresNeufs() throws SQLException {
        Connection dbCon = this.databaseConnexion();

        if(dbCon != null) {
            this.getListVehiculesNeufs(dbCon);
            return neufs;
        }
        return null;
    }

    public Voiture getVoitureNeufOrOccasion(ArrayList<Voiture> list, String immatriculation) {
        for (Voiture neuf : list) {
            if (neuf.getImmatriculation().equals(immatriculation)) {
                return neuf;
            }
        }
        return null;
    }

    public Voiture getVoitureNeuf(ArrayList<Voiture> listNeufs, String element) {
        for (Voiture neuf : listNeufs) {
            if (neuf.getImmatriculation().equals(element)) {
                return neuf;
            }
        }
        return null;
    }

    public void createVoiture (Voiture voiture) throws SQLException {
        Connection dbCon = this.databaseConnexion();

        this.createVehicule(dbCon, voiture);
    }

}
