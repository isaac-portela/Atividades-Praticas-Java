package com.isaac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author isaac
 */
@WebServlet(name = "CabelhosRequisicaoNavegador", urlPatterns = {"/CabelhosRequisicaoNavegador"})
public class CabelhosRequisicaoNavegador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<h3> Cabeçalhos http </h3>");
        out.println("Método de Solicitação: " + request.getMethod() + "<br />");
        out.println("Requisisição URI: " + request.getRequestURI() + "<br />");
        out.println("Protocolo de requisição: " + request.getProtocol() + "<br />");
        out.println("Caminho do Servlet: " + request.getServletPath() + "<br />");
        out.println("Caminho da Info: " + request.getPathInfo() + "<br />");
        out.println("Caminho do translated: " + request.getPathTranslated() + "<br />");
        out.println("String de Consulta: " + request.getQueryString() + "<br />");
        out.println("Comprimento do conteúdo: " + request.getContentLength() + "<br />");
        out.println("Tipo de conteúdo: " + request.getContentType() + "<br />");
        out.println("Nome do servidor: " + request.getServerName() + "<br />");
        out.println("Porta do servidor: " + request.getServerPort() + "<br />");
        out.println("Usuário remoto: "+request.getRemoteUser()+"<br />");
        out.println("Endereço remoto: "+ request.getRemoteAddr()+"<br />");
        out.println("Host remoto: "+request.getRemoteHost()+"<br />");
        out.println("Esquema de autorização: "+request.getAuthType()+"<br />");
        out.println("getCharacterEncoding: "+request.getCharacterEncoding()+"<br />");
        out.println("getscheme: "+request.getScheme()+"<br />");
        out.println("</HTML>");
        out.close();

    }

    @Override
    public String getServletInfo(){
        return "Short description";
    }
    
}
