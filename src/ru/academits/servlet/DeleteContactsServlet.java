package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.service.ContactService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteContactsServlet extends HttpServlet {
    private ContactService phoneBookService = PhoneBook.phoneBookService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] idsStringArray = req.getParameter("idsString").split(",");

        int[] idsArray = new int[idsStringArray.length];

        for (int i = 0; i < idsArray.length; i++) {
            idsArray[i] = Integer.parseInt(idsStringArray[i]);
        }

        phoneBookService.deleteContactsbyIds(idsArray);
    }
}
