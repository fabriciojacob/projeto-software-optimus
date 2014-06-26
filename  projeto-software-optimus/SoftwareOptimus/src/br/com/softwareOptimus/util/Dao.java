package br.com.softwareOptimus.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

	/*
	 * - Somente podem existir métodos publicos dentro de uma interface
	 * independente de ter isso explicito ou não
	 * 
	 * - Dentro de interfaces não existem atributos somente constantes
	 */
	Dao<T> insere(T elemento);

	Dao<T> atualiza(T elemento);

	Dao<T> remove(T elemento);

	T get(Long codigo);

	List<T> all();

	Dao<T> begin() throws IOException, SQLException;

	Dao<T> commit();

	Dao<T> rollback();

}
