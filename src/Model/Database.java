package Model;

import org.sqlite.SQLiteDataSource;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * The class creates the dungeon characters database
 */
public class Database implements Serializable {
    /**
     * Constructor of Database class
     * @throws SQLException database error
     */
    Database() throws SQLException {
        createConnection();
        createTable();
    }

    /**
     * Connect the SQLite with jdbc driver
     * @return database
     */
    public SQLiteDataSource createConnection() {
        SQLiteDataSource myDS = null;

        try {
            myDS = new SQLiteDataSource();
            myDS.setUrl("jdbc:sqlite:DungeonCharacter.db");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return myDS;
    }

    /**
     * Create the hero table
     * @throws SQLException errors
     */
    public void createTable() throws SQLException {
        Connection myConn = createConnection().getConnection();
        Statement myStmt = myConn.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS heroes ( " +
                "WARRIOR," +
                "PRIESTESS," +
                "THIEF," +
                "OGRE," +
                "GREMLIN," +
                "SKELETON )";
        try {
            myStmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Retrieve data from the table.
     * @param theName
     * @return the status
     * @throws SQLException database error
     */
    public StringBuilder getStats(String theName) throws SQLException {
        StringBuilder myStats = new StringBuilder();
        Connection myConn = createConnection().getConnection();
        Statement myStmt = myConn.createStatement();

        String query = "SELECT * FROM heroes";
        try {
            ResultSet myRS = myStmt.executeQuery(query);
            while (myRS.next()) {
                myStats.append(myRS.getString(theName.toUpperCase(Locale.ROOT)));
                myStats.append(" ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return myStats;
    }
}
