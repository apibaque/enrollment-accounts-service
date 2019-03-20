package cl.redbanc.mvp.enrollment.data.service;

import cl.redbanc.mvp.enrollment.api.exception.ApiException;
import cl.redbanc.mvp.enrollment.api.model.EnrollmentAccountsDto;
import cl.redbanc.mvp.enrollment.api.model.EnrollmentAccountsResponseDto;

public interface EnrollmentAccountsService {
	
	EnrollmentAccountsDto save(EnrollmentAccountsDto dto) throws ApiException;
	
	EnrollmentAccountsResponseDto findById(String enrollmentId) throws ApiException;
	
	EnrollmentAccountsResponseDto findByClientId(String clientId) throws ApiException;
	
	

}
