package Model;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class Database {
    Database() throws SQLException {
        createConnection();
        createTable();
    }
    public SQLiteDataSource createConnection(){
        SQLiteDataSource myDS = null;

        try{
            myDS = new SQLiteDataSource();
            myDS.setUrl("jdbc:sqlite:DungeonCharacter.db");
        } catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        return myDS;
    }
    public void createTable() throws SQLException {
        Connection myConn = createConnection().getConnection();
        Statement myStmt = myConn.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS heroes ( " +
                "WARRIOR," +
                "PRIESTESS," +
                "THIEF," +
                "OGRE,"+
                "GREMLIN,"+
                "SKELETON )";
        try {
            int myRv = myStmt.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
            System.exit(0);
        }
        String query1 = "INSERT INTO heroes ( WARRIOR, PRIESTESS, THIEF, OGRE, GREMLIN, SKELETON ) VALUES ( '125', '75', '75', '200', '70', '100' )";
        String query2 = "INSERT INTO heroes ( WARRIOR, PRIESTESS, THIEF, OGRE, GREMLIN, SKELETON ) VALUES ( '4', '5', '6', '2', '5', '3' )";
        String query3 = "INSERT INTO heroes ( WARRIOR, PRIESTESS, THIEF, OGRE, GREMLIN, SKELETON ) VALUES ( '0.8', '0.7', '0.8', '0.6', '0.8', '0.8' )";
        String query4 = "INSERT INTO heroes ( WARRIOR, PRIESTESS, THIEF, OGRE, GREMLIN, SKELETON ) VALUES ( '35', '25', '20', '30', '15', '30' )";
        String query5 = "INSERT INTO heroes ( WARRIOR, PRIESTESS, THIEF, OGRE, GREMLIN, SKELETON ) VALUES ( '60', '45', '40', '60', '30', '50' )";
        String query6 = "INSERT INTO heroes ( WARRIOR, PRIESTESS, THIEF, OGRE, GREMLIN, SKELETON ) VALUES ( '0.2', '0.3', '0.4', '0.1', '0.4', '0.3' )";
        String query7 = "INSERT INTO heroes ( WARRIOR, PRIESTESS, THIEF, OGRE, GREMLIN, SKELETON ) VALUES ( '', '', '', '30', '20', '30' )";
        String query8 = "INSERT INTO heroes ( WARRIOR, PRIESTESS, THIEF, OGRE, GREMLIN, SKELETON ) VALUES ( '', '', '', '60', '40', '50' )";


        try{
            int myRv = myStmt.executeUpdate(query1);
            myRv = myStmt.executeUpdate(query2);
            myRv = myStmt.executeUpdate(query3);
            myRv = myStmt.executeUpdate(query4);
            myRv = myStmt.executeUpdate(query5);
            myRv = myStmt.executeUpdate(query6);
            myRv = myStmt.executeUpdate(query7);
            myRv = myStmt.executeUpdate(query8);
        } catch (SQLException e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    public StringBuilder getStats(String theName) throws SQLException {
        StringBuilder myStats = new StringBuilder();
        Connection myConn = createConnection().getConnection();
        Statement myStmt = myConn.createStatement();

        String query = "SELECT * FROM heroes";
        try {
            ResultSet myRS = myStmt.executeQuery(query);
            while (myRS.next()){
                myStats.append(myRS.getString(theName.toUpperCase(Locale.ROOT)));
                myStats.append(" ");
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.exit(0);
        }
        return myStats;
    }
}
