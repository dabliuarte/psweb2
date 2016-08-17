import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class BuscarPorNome extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuscarClientePorNome</title>");
            out.println("</head>");
            out.println("<body>");

            Session sessao = HibernateUtil.getSessionFactory().openSession();

            Criteria criteria = sessao.createCriteria(Funcionario.class);

            criteria.add(Restrictions.eq("nome", request.getParameter("nome")));

            List<Funcionario> resultado = criteria.list();
            out.println("Funcionarios encontrados: ");

            for (Funcionario funcionario : resultado) {       
                out.println("</br>Nome: " + funcionario.getNome());
                out.println("</br>Cpf: " + funcionario.getCpf());
                out.println("</br>Endereco: " + funcionario.getEndereco());
                out.println("</br>Sexo: " + funcionario.getSexo());
                out.println("</br>Email: " + funcionario.getEmail());
                out.println("</br>Senha: " + funcionario.getSenha());
                out.println("</br>Telefone: " + funcionario.getTelefone());
                out.println("</br>Nível de Acesso: " + funcionario.getNivel());
                out.println("</br>---------------------------------</br>");
            }
            out.println("<a href=\"buscarPorNome.html\">Pesquisar por nome</a></br>");
            out.println("<a href=\"buscarPorId.html\">Pesquisar por id</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
