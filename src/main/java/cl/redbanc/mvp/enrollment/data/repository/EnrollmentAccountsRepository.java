package cl.redbanc.mvp.enrollment.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cl.redbanc.mvp.enrollment.data.model.EnrollmentAccounts;

public interface EnrollmentAccountsRepository extends MongoRepository<EnrollmentAccounts, String> {

	EnrollmentAccounts findByClientId(String clientId);

}
