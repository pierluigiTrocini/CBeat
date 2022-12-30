package it.unical.demacs.progetto.cbeat.cbeat.handler;

import com.google.gson.*;
import it.unical.demacs.progetto.cbeat.cbeat.model.Employee;
import it.unical.demacs.progetto.cbeat.cbeat.utility.ActiveEmployee;
import it.unical.demacs.progetto.cbeat.cbeat.utility.PasswordEncrypter;
import it.unical.demacs.progetto.cbeat.cbeat.utility.Settings;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.*;

public class DatabaseHandler{
    private static DatabaseHandler instance = new DatabaseHandler();
    public DatabaseHandler() { this.databaseConnect(); }
    public static DatabaseHandler getInstance() { return instance; }


    private Connection connection = null;

    public void databaseConnect() {
        try {
            connection = DriverManager.getConnection(Settings.databaseUrl);
        } catch (SQLException e) { e.printStackTrace(); } //TODO serve grafica
    }

    public void databaseClose(){
        try {
            if( connection != null ) connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public void updateLocalDatabase() throws IOException, SQLException {

        for( char alphabet = 'a';  alphabet <= 'z'; alphabet++ ) {

            JsonObject jsonObject = APIHandler.getInstance().searchFromText(String.valueOf(alphabet));
            if (!jsonObject.get("drinks").isJsonNull()) {
                JsonArray array = jsonObject.getAsJsonArray("drinks");
                for (int i = 0; i < array.size(); i++) {
                    JsonObject object = array.get(i).getAsJsonObject();
                    PreparedStatement stmt = connection.prepareStatement(Settings.insertionQuery);

                    stmt.setString(1, String.valueOf(object.get("idDrink")));
                    stmt.setString(2, String.valueOf(object.get("strDrink")));
                    stmt.setString(3, String.valueOf(object.get("strAlcoholic")));
                    stmt.setString(4, String.valueOf(object.get("strDrinkThumb")));
                    stmt.setString(5, String.valueOf(object.get("strInstructionsIT")));
                    stmt.setString(6, String.valueOf(object.get("strIngredient1")));
                    stmt.setString(7, String.valueOf(object.get("strIngredient2")));
                    stmt.setString(8, String.valueOf(object.get("strIngredient3")));
                    stmt.setString(9, String.valueOf(object.get("strIngredient4")));
                    stmt.setString(10, String.valueOf(object.get("strIngredient5")));
                    stmt.setString(11, String.valueOf(object.get("strIngredient6")));
                    stmt.setString(12, String.valueOf(object.get("strIngredient7")));
                    stmt.setString(13, String.valueOf(object.get("strIngredient8")));
                    stmt.setString(14, String.valueOf(object.get("strIngredient9")));
                    stmt.setString(15, String.valueOf(object.get("strIngredient10")));
                    stmt.setString(16, String.valueOf(object.get("strIngredient11")));
                    stmt.setString(17, String.valueOf(object.get("strIngredient12")));
                    stmt.setString(18, String.valueOf(object.get("strIngredient13")));
                    stmt.setString(19, String.valueOf(object.get("strIngredient14")));
                    stmt.setString(20, String.valueOf(object.get("strIngredient15")));
                    stmt.setString(21, String.valueOf(object.get("strMeasure1")));
                    stmt.setString(22, String.valueOf(object.get("strMeasure2")));
                    stmt.setString(23, String.valueOf(object.get("strMeasure3")));
                    stmt.setString(24, String.valueOf(object.get("strMeasure4")));
                    stmt.setString(25, String.valueOf(object.get("strMeasure5")));
                    stmt.setString(26, String.valueOf(object.get("strMeasure6")));
                    stmt.setString(27, String.valueOf(object.get("strMeasure7")));
                    stmt.setString(28, String.valueOf(object.get("strMeasure8")));
                    stmt.setString(29, String.valueOf(object.get("strMeasure9")));
                    stmt.setString(30, String.valueOf(object.get("strMeasure10")));
                    stmt.setString(31, String.valueOf(object.get("strMeasure11")));
                    stmt.setString(32, String.valueOf(object.get("strMeasure12")));
                    stmt.setString(33, String.valueOf(object.get("strMeasure13")));
                    stmt.setString(34, String.valueOf(object.get("strMeasure14")));
                    stmt.setString(35, String.valueOf(object.get("strMeasure15")));

                    stmt.execute();
                }
            }
        }

        this.databaseClose();
    }

    public ResultSet queryForCards() throws SQLException {
        if( connection == null || connection.isClosed() )
            return null;

        PreparedStatement statement = connection.prepareStatement(Settings.cardQuery);
        return statement.executeQuery();
    }

    public ResultSet queryOrders() throws SQLException {
        if( connection == null || connection.isClosed() )
            return null;

        PreparedStatement statement = connection.prepareStatement(Settings.queryOrders);
        return statement.executeQuery();
    }

    public ResultSet queryInformations( String name ) throws SQLException {
        if( connection == null || connection.isClosed() )
            return null;

        PreparedStatement statement = connection.prepareStatement(Settings.drinkInfo);
        statement.setString(1, name);

        return statement.executeQuery();
    }

    public ResultSet querySearch( String name ) throws SQLException {
        if( connection == null || connection.isClosed() )
            return null;

        PreparedStatement statement = connection.prepareStatement(Settings.searchQuery);
        statement.setString(1, ( "%" + name + "%" ));

        return statement.executeQuery();

    }

    public ResultSet showOnly( Boolean alcoholic ) throws SQLException {
        if( connection == null || connection.isClosed() )
            return null;

        PreparedStatement statement = connection.prepareStatement(Settings.searchOnly);
        if( alcoholic )
            statement.setString(1, ( "\"Alcoholic\"" ));
        else
            statement.setString(1, ( "\"Non alcoholic\"" ));


        return statement.executeQuery();

    }

    public ResultSet searchByIngredient( String name ) throws SQLException {
        if( connection == null || connection.isClosed() )
            return null;

        PreparedStatement statement = connection.prepareStatement(Settings.searchByIngredient);
        for( int i = 1; i <= 15; i++ )
            statement.setString(i, "\"" + name + "\"");

        return statement.executeQuery();
    }

    public boolean insertOrders( String id, int amount, int table ) throws SQLException {
        if( connection == null || connection.isClosed() )
            return false;

        PreparedStatement statement = connection.prepareStatement(Settings.insertOrder);
        statement.setString(1, id);
        statement.setInt(2, amount);
        statement.setInt(3, table);

        return statement.execute();
    }

    public boolean CheckProcessedOrderExists(String username) throws SQLException {
        if( connection == null || connection.isClosed() )
            return false;

        PreparedStatement statement = connection.prepareStatement(Settings.procOrderExists);
        statement.setString(1,username);

        ResultSet set=statement.executeQuery();
        if (set.next())
            return true;

        return false;

    }
    public boolean SaveOrUpdateProcessedOrder(String username,Integer amount) throws SQLException {
        if( connection == null || connection.isClosed() )
            return false;
        if(!CheckProcessedOrderExists(ActiveEmployee.getInstance().getUsername())) {
            PreparedStatement statement = connection.prepareStatement(Settings.SaveProcessedOrder);
            statement.setString(1,username);
            statement.setInt(2,amount);
           return statement.execute();

        }
        else{
            PreparedStatement statement = connection.prepareStatement(Settings.UpdateProcessedOrder);
            statement.setInt(1,amount);
            statement.setString(2,username);
            return statement.execute();


        }
    }

    public boolean DeleteFromOrders(Integer orderId) throws SQLException {
        if( connection == null || connection.isClosed() )
            return false;

        PreparedStatement statement = connection.prepareStatement(Settings.DeleteFromOrders);
        statement.setInt(1,orderId);
        return statement.execute();



    }


    public Boolean CorrectUserPass(String username,String password){
        try{
            if( connection == null || connection.isClosed() )
                return false;

                PreparedStatement stmt=connection.prepareStatement(Settings.SearchCorrectUsername);
                stmt.setString(1,username);
                ResultSet rs=stmt.executeQuery();


                if(rs.next()){
                    String encryptedPassword=rs.getString("password");
                    if(BCrypt.checkpw(password,encryptedPassword)){
                        return true;
                    }


                }
                stmt.close();
                rs.close();


            }
        catch (SQLException e){}

        return false;
    }

    public boolean insertEmployee(Employee employee) throws SQLException{

        if( connection == null || connection.isClosed() )
            return false;

        PreparedStatement statement = connection.prepareStatement(Settings.InsertEmployee);
        statement.setString(1, employee.username());
        String encryptedpassword= PasswordEncrypter.getInstance().EncryptPassword(employee.password());
        statement.setString(2, encryptedpassword);

        return statement.execute();


    }

}










