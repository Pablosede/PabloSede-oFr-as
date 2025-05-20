package ej1claseMuyLarga;

import java.util.*;

public class PlataformaEducativa {
	private Map<String, String> users; // username -> password
	private Map<String, List<String>> cursos; // username -> cursos
	private Map<String, String> Cursos; // curso -> contenido

	public PlataformaEducativa() { 
		users = new HashMap<>();
		cursos = new HashMap<>();
		Cursos = new HashMap<>();
	}

	public void registrarUsuario(String username, String password) {
		if (!users.containsKey(username)) {
			users.put(username, password);
			System.out.println("Usuario registrado con éxito.");
		} else {
			System.out.println("El usuario ya se ha registrado.");
		}
	}

	public boolean iniciarSesion(String username, String password) {
		return users.containsKey(username) && users.get(username).equals(password);
	}

	public void agregarCurso(String curso, String contenido) {
		if (!Cursos.containsKey(curso)) {
			Cursos.put(curso, contenido);
			System.out.println("Curso agregado con éxito.");
		} else {
			System.out.println("El curso ya se ha agregado.");
		}
	}

	public void inscribirUsuarioEnCurso(String username, String curso) {
		if (users.containsKey(username) && Cursos.containsKey(curso)) {
			cursos.get(username).add(curso);
			System.out.println("Usuario inscrito en el curso.");
		} else {
			System.out.println("Error al inscribir al usuario.");
		}
	}

	public void mostrarCursosUsuario(String username) {
		if (cursos.containsKey(username)) {
			List<String> listaCursos = cursos.get(username);
			System.out.println("Cursos de " + username + ": " + listaCursos);
		}
	}

	public void mostrarCursos() {
        for (String nombreCurso : cursos.keySet()) {
				System.out.println("Curso: " + nombreCurso);
        }
    }
}
