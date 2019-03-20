package cl.redbanc.mvp.enrollment.data.service.impl;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.redbanc.mvp.enrollment.api.exception.ApiException;
import cl.redbanc.mvp.enrollment.api.model.CreditorAccountsDto;
import cl.redbanc.mvp.enrollment.api.model.EnrollmentAccountsDto;
import cl.redbanc.mvp.enrollment.api.model.EnrollmentAccountsResponseDto;
import cl.redbanc.mvp.enrollment.data.model.CreditorAccounts;
import cl.redbanc.mvp.enrollment.data.model.DebtorAccounts;
import cl.redbanc.mvp.enrollment.data.model.EnrollmentAccounts;
import cl.redbanc.mvp.enrollment.data.repository.EnrollmentAccountsRepository;
import cl.redbanc.mvp.enrollment.data.service.EnrollmentAccountsService;
import cl.redbanc.mvp.enrollment.mapper.DtoDataObjectMapper;

@Service
public class EnrollmentAccountsServiceImpl implements EnrollmentAccountsService {
	
	private static final String FOUND_FOR_ID = "Enrollment accounts found for id ";
	private static final String DOCUMENT_NOT_FOUND = "Document not found for ";
	private static final String SERVICE_ERROR = "Service Error. ";
	
	@Autowired
	EnrollmentAccountsRepository enrollmentAccountsRepository; 
	
	
	private EnrollmentAccountsResponseDto validate(String clientId) throws ApiException {
		EnrollmentAccountsResponseDto entity = this.findByClientId(clientId);
		if (enrollmentAccountsRepository.existsById(entity.getEnrollmentId())) {
			return this.findById(entity.getEnrollmentId());
		}
		return null;		
	}
	
	

	@Override
	public EnrollmentAccountsDto save(EnrollmentAccountsDto dto) throws ApiException {
		this.validate(dto.getClientId());
		
		List<CreditorAccounts> creditorAccounts = new ArrayList<>();
		CreditorAccounts account = null;
		for (CreditorAccountsDto accountDto : dto.getDebtorAccount().getCreditorAccounts()) {
			account = new CreditorAccounts(accountDto.getIdentification(), accountDto.getSecondaryIdentification(), accountDto.getName(), accountDto.getDestinationDNI(), accountDto.getValidThru());
			creditorAccounts.add(account);
		}
		DebtorAccounts debtorAccounts = new DebtorAccounts(dto.getDebtorAccount().getIdentification(), dto.getDebtorAccount().getSecondaryIdentification(), dto.getDebtorAccount().getName(), dto.getDebtorAccount().getDestinationDNI(), creditorAccounts );
		EnrollmentAccounts data = new EnrollmentAccounts(dto.getEnrollmentId(), dto.getClientId(), debtorAccounts, new Date(), null);
		try {
			EnrollmentAccounts response = enrollmentAccountsRepository.save(data);
			return DtoDataObjectMapper.mapper(response);
		} catch (IOException e) {
			throw new ApiException(500, SERVICE_ERROR + e.getMessage());
		}	
	}

	@Override
	public EnrollmentAccountsResponseDto findById(String enrollmentId) throws ApiException {
		try {
			Optional<EnrollmentAccounts> optional = enrollmentAccountsRepository.findById(enrollmentId);
			if (!optional.isPresent()) {
				throw new ApiException(404, DOCUMENT_NOT_FOUND + enrollmentId);
			}
			EnrollmentAccountsResponseDto dto = DtoDataObjectMapper.mapperResponse(optional.get());
			dto.setDescription(FOUND_FOR_ID + enrollmentId);
			dto.setOperationDate(OffsetDateTime.now());
			return dto;
				
		} catch (IOException e) {
			throw new ApiException(500, SERVICE_ERROR + e.getMessage());
		}
	}



	@Override
	public EnrollmentAccountsResponseDto findByClientId(String clientId) throws ApiException {
		EnrollmentAccountsResponseDto dto = null; 
		try {
			EnrollmentAccounts entity = enrollmentAccountsRepository.findByClientId(clientId);
			
			dto = DtoDataObjectMapper.mapperResponse(entity);
			dto.setDescription(FOUND_FOR_ID + clientId);
			dto.setOperationDate(OffsetDateTime.now());
			return dto;
		} catch (IOException e) {
			throw new ApiException(500, SERVICE_ERROR + e.getMessage());
		}
	}

}
