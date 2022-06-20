package br.com.alura.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresaForm;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

// @WebServlet("/entrada")
public class UnidaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		
		String nomeClasse = "br.com.alura.gerenciador.acao." + paramAcao;
				
		String nome = null;
		try {
			Class classe = Class.forName(nomeClasse);
			Object obj = classe.newInstance();
			Acao acao = (Acao)obj;
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		String[] nomeEndereco = nome.split(":");

		if (nomeEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + nomeEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(nomeEndereco[1]);
		}

//		if (paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acaoListar = new ListaEmpresas();
//			nome = acaoListar.executa(request, response);
//
//		} else if (paramAcao.equals("RemoveEmpresa")) {
//			RemoveEmpresa acaoRemover = new RemoveEmpresa();
//			nome = acaoRemover.executa(request, response);
//
//		} else if (paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa acaoAlterar = new AlteraEmpresa();
//			nome = acaoAlterar.executa(request, response);
//
//		} else if (paramAcao.equals("MostraEmpresa")) {
//			MostraEmpresa acaoMostrar = new MostraEmpresa();
//			nome = acaoMostrar.executa(request, response);
//			
//		} else if (paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa acaoNova = new NovaEmpresa();
//			nome = acaoNova.executa(request, response);
//		} else if (paramAcao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm acaoNovaForm = new NovaEmpresaForm();
//			nome = acaoNovaForm.executa(request, response);
//		}

	}
}
