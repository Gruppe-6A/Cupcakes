package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.CupcakeFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderCommand extends CommandProtectedPage{
    private CupcakeFacade cupcakeFacade;

    public OrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
        cupcakeFacade = new CupcakeFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        User user;
        int user_id = 1;
        HttpSession session = request.getSession();

        if(session.getAttribute("user") != null)
        {
            user = (User) session.getAttribute("user");
            user_id = user.getId();
        }

        int bottom = Integer.parseInt(request.getParameter("bottoms"));
        int topping = Integer.parseInt(request.getParameter("toppings"));
        int quantity = 0;
        int cupcakes_id = 0;
        int orders_id = 0;


        request.setAttribute("bottoms", bottom);
        request.setAttribute("toppings", topping);
        request.setAttribute("quantity", topping);

        cupcakeFacade.createCupcake(bottom, topping, quantity, cupcakes_id, orders_id);
        return pageToShow;
    }
}