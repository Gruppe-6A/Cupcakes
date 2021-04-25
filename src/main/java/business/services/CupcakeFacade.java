package business.services;

import business.entities.Cupcake;
import business.entities.CupcakeEntry;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.Database;

import java.sql.SQLException;
import java.util.List;


public class CupcakeFacade {
    CupcakeMapper cupcakeMapper;

    public CupcakeFacade(Database database)
    {
        cupcakeMapper = new CupcakeMapper(database);
    }


    public Cupcake createCupcake(int bottom, int topping, int quantity, int user_id) throws UserException
    {
        Cupcake cupcake = new Cupcake(bottom, topping, quantity);

        cupcakeMapper.insertIntoOrder(cupcake, user_id);
        return cupcake;
    }

    public List<CupcakeEntry> getAllOrders() throws UserException
    {
     return cupcakeMapper.getAllOrders();
    }


    public String getToppingNameFromID(int ID) throws SQLException
    {
         return cupcakeMapper.getToppingNameFromID(ID);
    }
    public String getBottomNameFromID(int ID) throws SQLException
    {
        return cupcakeMapper.getBottomNameFromID(ID);
    }
    public double getBottomPriceFromID(int ID) throws SQLException
    {
        return CupcakeMapper.getBottomPriceFromID(ID);
    }
    public double getToppingPriceFromID(int ID) throws SQLException
    {
        return CupcakeMapper.getToppingPriceFromID(ID);
    }


}