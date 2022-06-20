package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static Integer idSequencial = 1;

	static {
		Empresa empresa = new Empresa();
		empresa.setId(idSequencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(idSequencial++);
		empresa2.setNome("Caelum");
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);

		Usuario u = new Usuario();
		u.setLogin("eduardo");
		u.setSenha("12345");
		Usuario u2 = new Usuario();
		u2.setLogin("rafaela");
		u2.setSenha("12345");
		listaUsuarios.add(u);
		listaUsuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(idSequencial++);
		listaEmpresas.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return listaEmpresas;
	}

	public void removeEmpresaPeloId(Integer id) {

		Iterator<Empresa> it = listaEmpresas.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : listaEmpresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}		
		return null;
	}
}