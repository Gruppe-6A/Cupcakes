package web.commands;

import business.entities.Cupcake;
import business.entities.CupcakeEntry;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.services.CupcakeFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CommandEmployee extends CommandProtectedPage
{
   private CupcakeFacade cupcakeFacade;

    public CommandEmployee(String pageToShow, String role)
    {
        super(pageToShow, role);
        cupcakeFacade = new CupcakeFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();


        List<CupcakeEntry> cupcakeEntryList = cupcakeFacade.getAllOrders();
        request.setAttribute("cupcakeEntryList", cupcakeEntryList);
        return pageToShow;
    }

    public String getRole()
    {
        return role;
    }
}
