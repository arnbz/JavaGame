package game;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public Database() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "missionborder", "tiger");
            stmt = con.createStatement();

            //	String s = "INSERT INTO SCORE VALUES('aaa','12',120)";
            //	 stmt.executeUpdate(s);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insert(int score, String name, String age) {
        try {
            //System.out.println(score);
            //System.out.println("call insert method");
            //String query = "INSERT INTO SCORE VALUES('name','age', score)";
            //String query = "INSERT INTO SCORE VALUES('shovon','12', 100)";
            //String query = "UPDATE SCORELIST SET SCORE=+score+ WHERE POSITION = +position+";
            //int count = stmt.executeUpdate(query);
				/*Login lg = new Login();
				String a= lg.getName();
				String b = lg.getAge();
				System.out.println(b);
				System.out.println(score);*/
            //String sql ="INSERT INTO SCORE VALUES(' " + lg.getName() + " '  , ' " + lg.getAge() + " ' , 100)";
            stmt.executeUpdate("INSERT INTO SCORE VALUES(' " + name + " '  , ' " + age + " '  ,  " + score + " ) ");
            //System.out.println(lg.getName());
            //System.out.println("Updated queries: hello ");
        } catch (Exception e) {
        }
    }

    public ObservableList<ScoreList> getscoreList() {

        ObservableList<ScoreList> highScores = FXCollections.observableArrayList();

        try {

            String sql = "SELECT * FROM SCORE";

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                highScores.add(new ScoreList(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }

        } catch (Exception r) {}

        return highScores;

    }


}

