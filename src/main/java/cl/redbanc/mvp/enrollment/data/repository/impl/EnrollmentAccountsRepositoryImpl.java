package cl.redbanc.mvp.enrollment.data.repository.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cl.redbanc.mvp.enrollment.data.model.EnrollmentAccounts;
import cl.redbanc.mvp.enrollment.data.repository.EnrollmentAccountsRepository;

@Repository
public class EnrollmentAccountsRepositoryImpl
		implements MongoRepository<EnrollmentAccounts, String>, EnrollmentAccountsRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public <S extends EnrollmentAccounts> List<S> saveAll(Iterable<S> entities) {
		// Implement
		return null;
	}

	@Override
	public List<EnrollmentAccounts> findAll() {
		// Implement
		return null;
	}

	@Override
	public List<EnrollmentAccounts> findAll(Sort sort) {
		// Implement
		return null;
	}

	@Override
	public <S extends EnrollmentAccounts> S insert(S entity) {
		// Implement
		return null;
	}

	@Override
	public <S extends EnrollmentAccounts> List<S> insert(Iterable<S> entities) {
		// Implement
		return null;
	}

	@Override
	public <S extends EnrollmentAccounts> List<S> findAll(Example<S> example) {
		// Implement
		return null;
	}

	@Override
	public <S extends EnrollmentAccounts> List<S> findAll(Example<S> example, Sort sort) {
		// Implement
		return null;
	}

	@Override
	public Page<EnrollmentAccounts> findAll(Pageable pageable) {
		// Implement
		return null;
	}

	@Override
	public <S extends EnrollmentAccounts> S save(S entity) {
		return mongoTemplate.save(entity);
	}

	@Override
	public Optional<EnrollmentAccounts> findById(String id) {
		
		EnrollmentAccounts entity = mongoTemplate.findById(id, EnrollmentAccounts.class);
		Optional<EnrollmentAccounts> opt = Optional.empty();
		if (Objects.isNull(entity)) {
			return null;
		}
		opt = Optional.of(entity);
		return opt;
	}

	@Override
	public boolean existsById(String id) {
		// Implement
		return false;
	}

	@Override
	public Iterable<EnrollmentAccounts> findAllById(Iterable<String> ids) {
		// Implement
		return null;
	}

	@Override
	public long count() {
		// Implement
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// Implement

	}

	@Override
	public void delete(EnrollmentAccounts entity) {
		// Implement

	}

	@Override
	public void deleteAll(Iterable<? extends EnrollmentAccounts> entities) {
		// Implement

	}

	@Override
	public void deleteAll() {
		// Implement

	}

	@Override
	public <S extends EnrollmentAccounts> Optional<S> findOne(Example<S> example) {
		// Implement
		return null;
	}

	@Override
	public <S extends EnrollmentAccounts> Page<S> findAll(Example<S> example, Pageable pageable) {
		// Implement
		return null;
	}

	@Override
	public <S extends EnrollmentAccounts> long count(Example<S> example) {
		// Implement
		return 0;
	}

	@Override
	public <S extends EnrollmentAccounts> boolean exists(Example<S> example) {
		// Implement
		return false;
	}

	@Override
	public EnrollmentAccounts findByClientId(String clientId) {
		Criteria criteria = Criteria.where("clientId").is(clientId);
		Query query = new Query();
		query.addCriteria(criteria);
		
		List<EnrollmentAccounts> result = mongoTemplate.find(query, EnrollmentAccounts.class);
		if (result.isEmpty()) {
			throw new EntityNotFoundException(clientId);
		}
		return result.get(0);
	}

}
