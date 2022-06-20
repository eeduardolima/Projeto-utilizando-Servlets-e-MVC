package br.com.alura.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Long inicio = System.currentTimeMillis();
		
		String paramAcao = request.getParameter("acao");

		chain.doFilter(request, response);
		
		Long fim = System.currentTimeMillis();
		System.out.println("Tempo em MS gasto na ação: " + paramAcao + ", foi de " + (fim - inicio));
		
	}

}
