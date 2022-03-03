import java.sql.*;
import java.util.ArrayList;

public class Database {
    ArrayList<Voiture> neufs = new ArrayList<>();
    ArrayList<Occasion> occasions = new ArrayList<>();

    public Database() {
    }

    public static void main(String[] args) throws SQLException {
    }

    public ArrayList<Voiture> getNeufs() {
        return neufs;
    }

    public void setNeufs(ArrayList<Voiture> neufs) {
        this.neufs = neufs;
    }

    public void getNeufs (Connection dbCon) throws SQLException {

    }

    public Connection databaseConnexion() {
        String dbURL = "jdbc:mysql://localhost:3306/garage";
        String username ="root";
        String password = "Obrigada";

        Connection dbCon = null;

        try {
            dbCon = DriverManager.getConnection(dbURL, username, password);
            return dbCon;

        } catch (SQLException ex) {
            System.out.println("error");
        }
        return null;
    }

    public void getListVehiculesNeufs(Connection dbCon) throws SQLException {
        Statement stmt;
        ResultSet rs;

        String query = "select * from voiture where kilometrage = 0";

        stmt = dbCon.prepareStatement(query);
        rs = stmt.executeQuery(query);

        while(rs.next()){
            String immatriculation = rs.getString("immatriculation");
            String modele = rs.getString("modele");
            String marque = rs.getString("marque");
            int kilometrage = rs.getInt("kilometrage");
            float prix = rs.getFloat("prix");

            Voiture v = new Voiture (
                    immatriculation,
                    modele,
                    marque,
                    kilometrage,
                    prix
            );

            neufs.add(v);
        }
    }

    public void getListVehiculesOccasion(Connection dbCon) throws SQLException {
        Statement stmt;
        ResultSet rs;

        String query = "select * from voiture where kilometrage > 0";

        stmt = dbCon.prepareStatement(query);
        rs = stmt.executeQuery(query);

        while(rs.next()){
            String immatriculation = rs.getString("immatriculation");
            String modele = rs.getString("modele");
            String marque = rs.getString("marque");
            int kilometrage = rs.getInt("kilometrage");
            float prix = rs.getFloat("prix");
            int dureeDeVie = rs.getInt("dureeDeVie");
            Date datePremierAchat = rs.getDate("datePremierAchat");
            Date dateRevente = rs.getDate("dateRevente");

            Occasion o = new Occasion(
                    immatriculation,
                    modele,
                    marque,
                    kilometrage,
                    prix,
                    dureeDeVie,
                    datePremierAchat,
                    dateRevente
            );

            occasions.add(o);
        }
    }

    public void createVehicule (Connection dbCon, Voiture voiture) throws SQLException {
        PreparedStatement stmt;

        try {
            String query = "insert into voiture (immatriculation, marque, modele, kilometrage, prix) values (?,?,?,?,?)";

            stmt = dbCon.prepareStatement(query);

            stmt.setString(1, voiture.getImmatriculation());
            stmt.setString(2, voiture.getMarque());
            stmt.setString(3, voiture.getModele());
            stmt.setInt(4, voiture.getKilometrage());
            stmt.setFloat(5, voiture.getPrix());

            int i = stmt.executeUpdate();

            isCreate(i);

            neufs.add(voiture);
        } catch (SQLException error) {
            System.out.println("Une erreur s'est produite lors de la création du véhicule neuf. " + error);
        }
    }

    public void createVehiculeOccasion (Connection dbCon, Occasion occasion) throws SQLException {
        PreparedStatement stmt;

        String query = "insert into voiture (immatriculation, marque, modele, kilometrage, prix, dureeDeVie, datePremierAchat, dateRevente) values (?,?,?,?,?,?,?,?)";

        try {
            stmt = dbCon.prepareStatement(query);

            stmt.setString(1, occasion.getImmatriculation());
            stmt.setString(2, occasion.getMarque());
            stmt.setString(3, occasion.getModele());
            stmt.setInt(4, occasion.getKilometrage());
            stmt.setFloat(5, occasion.getPrix());
            stmt.setInt(6, occasion.getDureeDeVie());

            stmt.setDate(7, new java.sql.Date(occasion.getDatePremierAchat().getTime()));
            stmt.setDate(8, new java.sql.Date(occasion.getDataRevente().getTime()));

            int i = stmt.executeUpdate();
            isCreate(i);

            occasions.add(occasion);
        } catch (SQLException error) {
            System.out.println("Une erreure est apparue durant l'ajout du vehicule d'occasion. " + error);
        }
    }

    private void isCreate(int i) {
        if (i > 0) {
            System.out.println(i + " lignes ajoutées");
        } else {
            System.out.println("Aucune ligne ajoutée");
        }
    }
}

