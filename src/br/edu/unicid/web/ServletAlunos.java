package br.edu.unicid.web;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.edu.unicid.bean.Aluno;
import br.edu.unicid.dao.AlunoDAO;

/**
 * Servlet implementation class ServletAlunos
 */
@WebServlet("/ServletAlunos")
public class ServletAlunos extends HttpServlet {
// m�todo para convers�o de String para data
	/*private Date strToDate(String data) throws Exception {
		if (data == null) {
			return null;
		}
		Date dataF = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			long timestamp = dateFormat.parse(data).getTime();
			dataF = new Date(timestamp);
		} catch (ParseException pe) {
			throw pe;
		}
		return dataF;
	}*/

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
// a vari�vel cmd indica o tipo de a��o - incluir, alterar, consulta.....
		String cmd = request.getParameter("cmd");
// cria um objeto dao - CRUD
		AlunoDAO dao;
// cria um objeto do tipo aluno
		Aluno aluno = new Aluno();
		if (cmd != null) {
			try {
// inicializa os atributos da classe Alunos
				aluno.setCaAluno(Integer.parseInt(request.getParameter("txtCa")));
				aluno.setNomeAluno(request.getParameter("txtNome"));
				aluno.setEmailAluno(request.getParameter("txtEmail"));
				aluno.setDtaNasc(request.getParameter("txtData"));
				aluno.setIdadeAluno(Integer.parseInt(request.getParameter("txtIdade")));

				aluno.setEndAluno(request.getParameter("txtEndereco"));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		try {
// cria a instancia do objeto dao
			dao = new AlunoDAO();
			RequestDispatcher rd = null;
// lista todos os alunos
			if (cmd.equalsIgnoreCase("listar")) {
				List alunosList = dao.todosAlunos();
// cria uma sess�o para encaminhar a lista para uma JSP
				request.setAttribute("alunosList", alunosList);
// redireciona para a JSP mostraAlunosCads
				rd = request.getRequestDispatcher("/mostrarAlunosCads.jsp");
			}
// incluir aluno
			else if (cmd.equalsIgnoreCase("incluir")) {
				dao.salvar(aluno);
				rd = request.getRequestDispatcher("ServletAlunos?cmd=listar");
// consulta aluno para exclus�o
			} else if (cmd.equalsIgnoreCase("exc")) {
				aluno = dao.procurarAluno(aluno.getCaAluno());
				HttpSession session = request.getSession(true);
				session.setAttribute("aluno", aluno);
				rd = request.getRequestDispatcher("/formExcAluno.jsp");
// exclui aluno
			} else if (cmd.equalsIgnoreCase("excluir")) {
				dao.excluir(aluno);
				rd = request.getRequestDispatcher("ServletAlunos?cmd=listar");
// consulta aluno para altera��o
			} else if (cmd.equalsIgnoreCase("atu")) {
				aluno = dao.procurarAluno(aluno.getCaAluno());
				HttpSession session = request.getSession(true);
				session.setAttribute("aluno", aluno);
				rd = request.getRequestDispatcher("/formAtuAluno.jsp");
// consulta aluno
			} else if (cmd.equalsIgnoreCase("con")) {
				aluno = dao.procurarAluno(aluno.getCaAluno());
				HttpSession session = request.getSession(true);
				session.setAttribute("aluno", aluno);
				rd = request.getRequestDispatcher("/formConAluno.jsp");
// altera aluno
			} else if (cmd.equalsIgnoreCase("atualizar")) {
				dao.atualizar(aluno);
				rd = request.getRequestDispatcher("ServletAlunos?cmd=listar");
// direciona para a p�gina principal
			} else if (cmd.equalsIgnoreCase("principal")) {
				rd = request.getRequestDispatcher("/index.jsp");
			}
// executa a a��o de direcionar para a p�gina JSP
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);

		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}