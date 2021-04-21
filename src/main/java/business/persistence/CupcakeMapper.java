package business.persistence;

import business.entities.Cupcake;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;

public class CupcakeMapper
{
    private Database database;

    public CupcakeMapper(Database database)
    {
        this.database = database;
    }

    public void createCupcake(Cupcake cupcake, int userID) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO cupcakes (cupcakes_id, orders_id, bottoms_id, toppings_id, quantity) VALUES (?, ?, ?, ?, ?)";

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


    /*public User login(String email, String password) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT id, role FROM users WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String role = rs.getString("role");
                    int id = rs.getInt("id");
                    User user = new User(email, password, role);
                    user.setId(id);
                    return user;
                } else
                {
                    throw new UserException("Could not validate user");
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }

     */

}
