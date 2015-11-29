package br.javaweb.ecommerce;

import br.javaweb.dao.ProdutoDAO;
import br.javaweb.dao.ProdutoDB;
import br.javaweb.beans.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionarProdutoCarrinho extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        // Obtencao do canal de envio de dados para o cliente
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ecommerce : Academia do Java</title>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
        out.println("<link href= 'aj.css' rel='stylesheet' type='text/css'></link>");
        out.println("</head>");
        out.println("<body>");
        out.println("<H3>Adicionando produtos no carrinho de compras</H3>");

        // obtendo os parametros de request...
        String strIdProduto = request.getParameter("idProduto");
        Produto prod = null;
        ProdutoDAO dao = new ProdutoDB();

        try {
            int id = Integer.parseInt(strIdProduto);
            prod = dao.getProdutoById(id);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        // Impressao dos dados do produto
        out.println("<br/>id: <strong>" + prod.getId() + "</strong>");
        out.println("<br/>c&oacute;digo: <strong>" + prod.getCodigo() + "</strong>");
        out.println("<br/>nome: <strong>" + prod.getNome() + "</strong>");
        out.println("<br/>descri&ccedil;&atilde;o: <strong>" + prod.getDescricao() + "</strong>");
        out.println("<br/>pre&ccedil;o: <strong>" + prod.getPreco() + "</strong>");
        out.println("<br/><img src='imagem/" + prod.getImage() + "' />");
        out.println("</body>");
        out.println("</html>");
    }
}
