package business.persistence;

import business.entities.Cupcake;
import business.entities.User;
import business.exceptions.UserException;
import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.*;

public class CupcakeMapper
{
    private static Database database;
    public CupcakeMapper(Database database)
    {
        this.database = database;
    }

    public void insertIntoOrder(Cupcake cupcake, int userID) throws UserException{
        try(Connection connection = database.connect()){
            String sql = "INSERT INTO orders (users_user_id) VALUES (?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, userID);
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                cupcake.setId(id);

               createCupcake(cupcake, userID);
            }
        }catch(SQLException ex){

        }


    }




    public void createCupcake(Cupcake cupcake,  int userID) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO `cupcake`.`cupcakes` " +
            "(" +"`toppings_id`,"+"`bottoms_id`,"+"`quantity`) " +
            "VALUES (?,?,?);";


            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                //ps.setInt(1, cupcake.getCupcakes_id());
               ps.setInt(1, cupcake.getBottom());
               ps.setInt(2, cupcake.getTopping());
               ps.setInt(3, cupcake.getQuantity());
             //  ps.setInt(4, userID);

            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }


    public static double getToppingPriceFromID(int ID) throws SQLException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT price FROM toppings WHERE toppings_id = "+ ID;

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                rs.next();

                return  rs.getDouble("price");

            }
            catch (SQLException ex)
            {
                throw new SQLException();
            }
        }
        catch (SQLException ex)
        {
            throw new SQLException();
        }

    }
    public static double getBottomPriceFromID(int ID) throws SQLException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT price FROM bottoms WHERE bottoms_id = "+ ID;

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                rs.next();

                return rs.getDouble("price");

            }
            catch (SQLException ex)
            {
                throw new SQLException();
            }
        }
        catch (SQLException ex)
        {
            throw new SQLException();
        }

    }

    public static String getToppingNameFromID(int ID) throws SQLException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT names FROM toppings WHERE toppings_id = "+ ID;

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                rs.next();

                return  rs.getString("names");

            }
            catch (SQLException ex)
            {
                throw new SQLException();
            }
        }
        catch (SQLException ex)
        {
            throw new SQLException();
        }

    }
    public static String getBottomNameFromID(int ID) throws SQLException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT names FROM bottoms WHERE bottoms_id = "+ ID;

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                rs.next();

                return  rs.getString("names");

            }
            catch (SQLException ex)
            {
                throw new SQLException();
            }
        }
        catch (SQLException ex)
        {
            throw new SQLException();
        }

    }
    /*public void GetCupcakePrice(Cupcake cupcake, int userID) throws UserException{
        try (Connection connection = database.connect())
        {
            String sql = "SELECT  price, names FROM toppings";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, cupcake.getCupcakes_id());
                ps.setInt(2, cupcake.getOrders_id());
                ps.setInt(3, cupcake.getBottom());
                ps.setInt(4, cupcake.getTopping());
                ps.setInt(5, cupcake.getQuantity());



                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                cupcake.setId(id);
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }

    }

     */




}
