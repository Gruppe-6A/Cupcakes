package business.services;

import business.entities.Cupcake;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.Database;


public class CupcakeFacade {
    CupcakeMapper cupcakeMapper;

    public CupcakeFacade(Database database)
    {
        cupcakeMapper = new CupcakeMapper(database);
    }


    public Cupcake createCupcake(int bottom, int topping, int quantity, int cupcakes_id, int orders_id) throws UserException
    {
        Cupcake cupcake = new Cupcake(bottom, topping, quantity, cupcakes_id, orders_id);

        //System.out.println(cupcake);
        int user_id = 0;
        cupcakeMapper.createCupcake(cupcake, user_id);
        return cupcake;
    }
}