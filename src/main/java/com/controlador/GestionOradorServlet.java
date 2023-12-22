package com.controlador;


import com.dao.OradoresDAO;
import com.modelo.Orador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vistas/GestionOradorServlet")
public class GestionOradorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        OradoresDAO oradoresDAO = new OradoresDAO();


        int idOrador = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            case "actualizar":
                Orador orador = oradoresDAO.obtenerPorId(idOrador);
                request.setAttribute("orador", orador);
                request.getRequestDispatcher("actualizar.jsp").forward(request, response);
                break;
            case "confirmarActualizacion":
                Orador oradorActualizado = new Orador();
                oradorActualizado.setIdOrador(idOrador);
                oradorActualizado.setNombre(request.getParameter("nombre"));
                oradorActualizado.setApellido(request.getParameter("apellido"));
                oradorActualizado.setTema(request.getParameter("tema"));

                oradorActualizado.setFechaAlta(java.sql.Date.valueOf(request.getParameter("fechaAlta")));

                oradoresDAO.actualizarOrador(oradorActualizado);
                response.sendRedirect("gestionOradores.jsp");
                break;
            case "eliminar":
                oradoresDAO.eliminarOrador(idOrador);
                response.sendRedirect("gestionOradores.jsp");
                break;
            default:
                response.sendRedirect("gestionOradores.jsp");
                break;
        }
    }
}
