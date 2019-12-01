/*******************************************************************************
 * Copyright 2012 Anteros Tecnologia
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package br.com.anteros.security.spring.sql.service;

import java.io.Serializable;
import java.util.List;

import br.com.anteros.persistence.dsl.osql.types.OrderSpecifier;
import br.com.anteros.persistence.dsl.osql.types.Predicate;
import br.com.anteros.persistence.metadata.identifier.Identifier;
import br.com.anteros.persistence.session.repository.Page;
import br.com.anteros.persistence.session.repository.Pageable;
import br.com.anteros.persistence.session.service.SQLService;
import br.com.anteros.security.spring.ActionSecured;

public interface SQLServiceSecured<T,ID extends Serializable> extends SQLService<T, ID> {

	@ActionSecured(actionName="ACT_save", category="Edição", description="Salvar entidade")
	<S extends T> S save(S entity);

	@ActionSecured(actionName="ACT_save", category="Edição", description="Salvar entidade")
	<S extends T> Iterable<S> save(Iterable<S> entities);

	@ActionSecured(actionName="ACT_save", category="Edição", description="Salvar entidade")
	<S extends T> S saveAndFlush(S entity);

	@ActionSecured(actionName="ACT_flush", category="Edição", description="Descarregar comandos da sessão")
	void flush();

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	T findOne(ID id, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_exists", category="Busca", description="Verifica se uma entidade existe")
	boolean exists(ID id);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	List<T> findAll(String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	Page<T> findAll(Pageable pageable, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	List<T> find(String sql, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	Page<T> find(String sql, Pageable pageable, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	List<T> find(String sql, Object parameters, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	Page<T> find(String sql, Object parameters, Pageable pageable, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Busca entidades")
	List<T> findByNamedQuery(String queryName, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	Page<T> findByNamedQuery(String queryName, Pageable pageable, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	List<T> findByNamedQuery(String queryName, Object parameters, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	Page<T> findByNamedQuery(String queryName, Object parameters, Pageable pageable, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	T findOne(Predicate predicate, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	T findOneBySql(String sql, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	T findOneBySql(String sql, Object parameters, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	List<T> findAll(Predicate predicate, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	Iterable<T> findAll(Predicate predicate, String fieldsToForceLazy, OrderSpecifier<?>... orders);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	Page<T> findAll(Predicate predicate, Pageable pageable, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_select", category="Busca", description="Buscar entidades")
	Page<T> findAll(Predicate predicate, Pageable pageable,  String fieldsToForceLazy, OrderSpecifier<?>... orders);

	@ActionSecured(actionName="ACT_refresh", category="Edição", description="Atualiza um objeto")
	void refresh(T entity, String fieldsToForceLazy);

	@ActionSecured(actionName="ACT_count", category="Edição", description="Conta a quantidade de objetos")
	long count();

	@ActionSecured(actionName="ACT_count", category="Edição", description="Conta a quantidade de objetos")
	long count(Predicate predicate);

	@ActionSecured(actionName="ACT_remove", category="Edição", description="Remover entidades")
	void remove(ID id);

	@ActionSecured(actionName="ACT_remove", category="Edição", description="Remover entidades")
	void remove(T entity);

	@ActionSecured(actionName="ACT_remove", category="Edição", description="Remover entidades")
	void remove(Iterable<? extends T> entities);

	@ActionSecured(actionName="ACT_remove", category="Edição", description="Remover entidades")
	void removeAll();

	@ActionSecured(actionName="ACT_createIdentifier", category="Edição", description="Cria um identificador")
	Identifier<T> createIdentifier() throws Exception;

	@ActionSecured(actionName="ACT_getIdentifier", category="Edição", description="Obtém um identificador")
	Identifier<T> getIdentifier(T owner) throws Exception;
}
