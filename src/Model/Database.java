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
