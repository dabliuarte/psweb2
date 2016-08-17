import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class IncluirFuncionario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("empty-statement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                                    
            Funcionario funcionario = new Funcionario();
            
            funcionario.setNivel(request.getParameter("nivel"));
            funcionario.setTelefone(request.getParameter("telefone"));
            funcionario.setSenha(request.getParameter("senha"));
            funcionario.setEmail(request.getParameter("email"));
            funcionario.setSexo(request.getParameter("sexo"));
            funcionario.setCpf(request.getParameter("cpf"));
            funcionario.setEndereco(request.getParameter("endereco"));
            funcionario.setNome(request.getParameter("nome"));

            out.println("Incluido com sucesso!<br/>");    
            //Criar a sessão
            Session sessao = HibernateUtil
                    .getSessionFactory()
                    .openSession();

            //Criar a transação
            Transaction t = sessao.beginTransaction();

            //Falar que quer salvar
            sessao.save(funcionario);

            //Mandar salvar
            sessao.flush();

            //Commitar a transação
            t.commit();

            //Fechar a sessao
            sessao.close();
            
            out.println("<a href=\"buscarPorNome.html\">Pesquisar por nome</a></br>");
            out.println("<a href=\"buscarPorId.html\">Pesquisar por id</a>");
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
