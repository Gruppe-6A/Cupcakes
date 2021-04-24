package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CommandHvidvask extends CommandProtectedPage
{
    private UserFacade userFacade;

    public CommandHvidvask(String pageToShow, String role)
    {
        super(pageToShow, role);
        userFacade = new UserFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        double amount = 0;
        String email = "";
        amount = Double.parseDouble(request.getParameter("amountToAdd"));
        email = request.getParameter("customerEmail");

        if (email == null)
        {
            request.setAttribute("error", "Den indtastede email findes ikke!");
            return "emailHenter";

        }




        request.setAttribute("amountToAdd", amount);
        request.setAttribute("customerEmail", email);

        try {
            userFacade.InsertMoneyIntoUsers(email, amount);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pageToShow;
    }

    public String getRole()
    {
        return role;
    }
}
