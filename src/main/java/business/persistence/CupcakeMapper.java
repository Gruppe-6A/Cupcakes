package business.persistence;

import business.entities.Cupcake;
import business.entities.CupcakeEntry;
import business.entities.User;
import business.exceptions.UserException;
import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

               createCupcake(cupcake, userID, id);
            }
        }catch(SQLException ex){

        }


    }




    public void createCupcake(Cupcake cupcake,  int userID, int id) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO `cupcake`.`cupcakes`"+
            "(orders_id,toppings_id,bottoms_id,quantity)"+
            "VALUES (?,?,?,?);";
            System.out.println("INSERT INTO `cupcake`.`cupcakes`"+
                    "(orders_id,toppings_id,bottoms_id,quantity)"+
                    "VALUES (?,?,?,?);");
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, id);
                System.out.println(id);
               ps.setInt(2, cupcake.getBottom());
                System.out.println(cupcake.getBottom());
               ps.setInt(3, cupcake.getTopping());
                System.out.println(cupcake.getTopping());
               ps.setInt(4, cupcake.getQuantity());
                System.out.println(cupcake.getQuantity());
             //  ps.setInt(4, userID);

                ps.execute();

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

    public List<CupcakeEntry> getAllOrders() throws UserException {

        List<CupcakeEntry> cupcakeEntryList = new ArrayList<>();
        try (Connection connection = database.connect())
        {
            String sql = "select u.email, o.orders_id, top.names as 'toppingnames', bot.names as 'bottomnames' from orders o join cupcakes c on o.orders_id = c.orders_id join toppings top on c.toppings_id = top.toppings_id join bottoms bot on c.bottoms_id = bot.bottoms_id join users u on u.id = o.users_user_id;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orders_id = rs.getInt("orders_id");
                    String bottomName = rs.getString("bottomnames");
                    String toppingName = rs.getString("toppingnames");
                    String userEmail = rs.getString("email");

                    cupcakeEntryList.add(new CupcakeEntry(userEmail, orders_id, bottomName, toppingName));
                }
                return cupcakeEntryList;
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
