package business.services;

import business.entities.Cupcake;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.Database;

import java.sql.SQLException;


public class CupcakeFacade {
    CupcakeMapper cupcakeMapper;

    public CupcakeFacade(Database database)
    {
        cupcakeMapper = new CupcakeMapper(database);
    }


    public Cupcake createCupcake(int bottom, int topping, int quantity) throws UserException
    {
        Cupcake cupcake = new Cupcake(bottom, topping, quantity);

        //System.out.println(cupcake);
        int user_id = 0;
        cupcakeMapper.insertIntoOrder(cupcake, user_id);
        return cupcake;
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