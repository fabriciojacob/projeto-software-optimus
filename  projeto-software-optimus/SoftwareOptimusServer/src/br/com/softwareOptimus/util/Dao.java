package br.com.softwareOptimus.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

	/*
	 * - Somente podem existir m�todos publicos dentro de uma interface
	 * independente de ter isso explicito ou n�o
	 * 
	 * - Dentro de interfaces n�o existem atributos somente constantes
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
