package com.e_com.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.e_com.Entity.User;

@Repository
public class UserRepoImpl implements UserRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	public UserRepoImpl() {
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public List<User> findAll(Sort sort) {
		return null;
	}

	@Override
	public List<User> findAllById(Iterable<Integer> ids) {
		return null;
	}

	@Override
	public <S extends User> List<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public void flush() {

	}

	@Override
	public <S extends User> S saveAndFlush(S entity) {
		return null;
	}

	@Override
	public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<User> entities) {

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {

	}

	@Override
	public void deleteAllInBatch() {

	}

	@Override
	public User getOne(Integer id) {
		return null;
	}

	@Override
	public User getById(Integer id) {
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public <S extends User> S save(S entity) {
		return null;
	}

	@Override
	public Optional<User> findById(Integer id) {
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		return false;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Integer id) {

	}

	@Override
	public void delete(User entity) {

	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {

	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public <S extends User> Optional<S> findOne(Example<S> example) {
		return null;
	}

	@Override
	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends User> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends User> boolean exists(Example<S> example) {
		return false;
	}

	@Override
	public <S extends User, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return null;
	}

	@Override
	@Transactional
	public User findByUserName(String username) {
		System.out.println("enter user repo impl" + username);
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("after current session" + currentSession);
		
		Query<User> theQuery =
				currentSession.createQuery("from User u where u.username = :username ",
											User.class);
		System.out.println("below query" );

		theQuery.setParameter("username",username);
		User theUser = theQuery.getSingleResult();
		
		return theUser;
	}

}
