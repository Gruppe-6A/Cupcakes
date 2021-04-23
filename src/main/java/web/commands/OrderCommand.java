package web.commands;

import business.entities.Basket;
import business.entities.Bottom;
import business.entities.Top;
import business.entities.User;
import business.exceptions.UserException;
import business.services.CupcakeFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

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
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        List<Top> toplist = (List<Top>) request.getServletContext().getAttribute("toplist");
        List<Bottom> bottomlist = (List<Bottom>) request.getServletContext().getAttribute("Bottomlist");

        Basket basket = (Basket) session.getAttribute("basket");

        if(basket == null){
            basket = new Basket();
        }



       // int cupcakes_id = 0;
        //int orders_id = 0;
        String getToppingsNames ="";
        String getBottomsNames ="";
        Double getToppingsPrice = 0.00;
        Double getBottomsPrice = 0.00;
        Double getSum =0.00;

        try{
            getBottomsPrice = cupcakeFacade.getBottomPriceFromID(bottom);
            getToppingsPrice = cupcakeFacade.getToppingPriceFromID(topping);
            getSum = cupcakeFacade.getToppingPriceFromID(topping)+cupcakeFacade.getBottomPriceFromID(bottom);
        } catch (SQLException ex){

        }

        try {
            getBottomsNames = cupcakeFacade.getBottomNameFromID(bottom);
            getToppingsNames = cupcakeFacade.getToppingNameFromID(topping);
        } catch (SQLException ex) {

        }

        request.setAttribute("bottoms", bottom);
        request.setAttribute("toppings", topping);
        request.setAttribute("quantity", quantity);
        request.setAttribute("getToppingsNames", getToppingsNames);
        request.setAttribute("getBottomsNames", getBottomsNames);
        request.setAttribute("getToppingsPrice", getToppingsPrice);
        request.setAttribute("getBottomsPrice", getBottomsPrice);
        request.setAttribute("getSum", getSum);

       cupcakeFacade.createCupcake(bottom,topping, quantity);


        return pageToShow;
    }
}