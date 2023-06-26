package cn.gamechanger.model.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.gamechanger.connection.DbCon;
import cn.gamechanger.model.*;

public class CarrelloDao {
    private Connection con;
    private static final Logger logger = Logger.getLogger(DbCon.class.getName());

    public CarrelloDao(Connection con) {
        this.con = con;
    }

    public CarrelloDao() {
		// TODO Auto-generated constructor stub
	}

	public void stampaProdottiCarrello(String username) {
        try {
            String query = "SELECT * FROM carrello WHERE username = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                System.out.println("Prodotto nel carrello: " + productId);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
        	e.printStackTrace();
	        logger.info(e.getMessage());
        }
    }
    
    public List<Carrello> getCarrelloByUsername(String username) {
        List<Carrello> carrelloList = new ArrayList<Carrello>();

        try {
        	String query = "SELECT * FROM carrello AS c JOIN prodotto AS p ON c.codice = p.codice WHERE username = ?";
			PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
            rs = pst.executeQuery();

            while (rs.next()) {
            	int id_carrello = rs.getInt("id_carrello");
                int idProdotto = rs.getInt("codice");
                int quantitàProdotto = rs.getInt("quant_prod");
                String nomeProdotto = rs.getString("nome");
                float prezzo = rs.getFloat("prezzo");
                Carrello carrello = new Carrello(id_carrello, username, idProdotto, quantitàProdotto, nomeProdotto, prezzo);
                carrelloList.add(carrello);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carrelloList;
    }
    
    public void aggiungiProdottoAlCarrello(String username, int codiceProdotto, int quantita) {
        try {
            String query = "INSERT INTO carrello (username, codice, quant_prod) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, username);
            statement.setInt(2, codiceProdotto);
            statement.setInt(3, quantita);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }
    }

}
