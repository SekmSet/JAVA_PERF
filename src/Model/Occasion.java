package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Occasion extends Database {

    private String immatriculation;
    private String marque;
    private String modele;
    private int kilometrage;
    private float prix;
    private Integer dureeDeVie;
    private Date datePremierAchat;
    private Date dataRevente;

    public Occasion() {
    }

    public Occasion(
            String immatriculation,
            String marque,
            String modele,
            int kilometrage,
            float prix,
            Integer dureeDeVie,
            Date datePremierAchat,
            Date dataRevente
    ) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.kilometrage = kilometrage;
        this.prix = prix;
        this.dureeDeVie = dureeDeVie;
        this.datePremierAchat = datePremierAchat;
        this.dataRevente = dataRevente;
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

    public Integer getDureeDeVie() {
        return dureeDeVie;
    }

    public void setDureeDeVie(Integer dureeDeVie) {
        this.dureeDeVie = dureeDeVie;
    }

    public Date getDatePremierAchat() {
        return datePremierAchat;
    }

    public void setDatePremierAchat(Date datePremierAchat) {
        this.datePremierAchat = datePremierAchat;
    }

    public Date getDataRevente() {
        return dataRevente;
    }

    public void setDataRevente(Date dataRevente) {
        this.dataRevente = dataRevente;
    }

    public void afficherDonnees (Occasion occasion) {
        System.out.println("Model.Voiture occasion matriculation : " + occasion.getImmatriculation());
        System.out.println("Model.Voiture occasion marque : " + occasion.getMarque());
        System.out.println("Model.Voiture occasion mod??le : " + occasion.getModele());
        System.out.println("Model.Voiture occasion kilom??trage : " + occasion.getKilometrage() + " KM");
        System.out.println("Model.Voiture occasion dur??e de vie : " + occasion.getDureeDeVie());
        System.out.println("Model.Voiture occasion prix de vente : " + occasion.getPrix() + " ???");
    }

    @Override
    public String toString() {
        return "Model.Occasion{" +
                "immatriculation='" + immatriculation + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", kilometrage=" + kilometrage +
                ", prix=" + prix +
                ", dureeDeVie=" + dureeDeVie +
                ", datePremierAchat=" + datePremierAchat +
                ", dataRevente=" + dataRevente +
                '}';
    }

    public ArrayList<Occasion> getVoituresOccasions() throws SQLException {
        Connection dbCon = this.databaseConnexion();

        if(dbCon != null) {
            this.getListVehiculesOccasion(dbCon);
            return occasions;
        }
        return null;
    }

    public Occasion getVoitureOccasion(ArrayList<Occasion> listOccasions, String element) {
        for (Occasion o : listOccasions) {
            if (o.getImmatriculation().equals(element)) {
                return o;
            }
        }
        return null;
    }

    public Occasion getVoitureNeufOrOccasion(ArrayList<Occasion> list, String immatriculation) {
        for (Occasion occasion : list) {
            if (occasion.getImmatriculation().equals(immatriculation)) {
                return occasion;
            }
        }
        return null;
    }

    public void createOccasion(Occasion occasion) throws SQLException {
        Connection dbCon = this.databaseConnexion();

        this.createVehiculeOccasion(dbCon, occasion);
    }
}
