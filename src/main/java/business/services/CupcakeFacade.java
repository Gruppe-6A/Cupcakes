package business.services;

import business.entities.BasketItem;
import business.entities.Bottom;
import business.entities.Cupcake;
import business.entities.Top;
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


    public BasketItem createCupcake(Bottom bottom, Top top, int quantity) throws UserException
    {
        BasketItem basketItem = new BasketItem(bottom, top, quantity);

        //System.out.println(cupcake);
        int user_id = 0;
        cupcakeMapper.insertIntoOrder(basketItem, user_id);
        return basketItem;
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