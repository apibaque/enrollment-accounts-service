package cl.redbanc.mvp.enrollment.data.service.impl;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final String DATA_IS_INCORRECT = "The enrollment data is incorrect.";
	private static final Logger LOGGER = LoggerFactory.getLogger(EnrollmentAccountsServiceImpl.class);
	private static final String FOUND_FOR_ID = "Enrollment accounts found for id ";
	private static final String DOCUMENT_NOT_FOUND = "Document not found for ";
	private static final String SERVICE_ERROR = "Service Error. ";

	@Autowired
	EnrollmentAccountsRepository enrollmentAccountsRepository;

	private EnrollmentAccountsDto validate(EnrollmentAccountsDto dto) throws ApiException {
		EnrollmentAccountsResponseDto entity;
		try {
			entity = this.findByClientId(dto.getClientId());
		} catch (ApiException e) {
			return dto;
		}
		if (!entity.getDebtorAccount().getIdentification().equals(dto.getDebtorAccount().getIdentification())) {
			LOGGER.warn("debtor account incorrect.");
			throw new ApiException(400, DATA_IS_INCORRECT);
		}
		// add debtor accounts.
		dto.setEnrollmentId(entity.getEnrollmentId());
		return dto;
	}

	@Override
	public EnrollmentAccountsDto save(EnrollmentAccountsDto dto) throws ApiException {
		EnrollmentAccountsDto updateDto = this.validate(dto);

		List<CreditorAccounts> creditorAccounts = new ArrayList<>();
		CreditorAccounts account = null;
		CreditorAccountsDto creditAccountDto = updateDto.getDebtorAccount().getCreditorAccounts().get(0);
		int control = 0;
		for (CreditorAccountsDto accountDto : updateDto.getDebtorAccount().getCreditorAccounts()) {
			if (control > 0 && creditAccountDto.getIdentification().equals(accountDto.getIdentification())) {
				LOGGER.error("Account number {} duplicated ", accountDto.getIdentification());
				throw new ApiException(400, DATA_IS_INCORRECT);
			}
			control++;
			account = new CreditorAccounts(accountDto.getIdentification(), accountDto.getSecondaryIdentification(),
					accountDto.getName(), accountDto.getDestinationDNI(), accountDto.getValidThru());
			creditorAccounts.add(account);
			
		}
		
		DebtorAccounts debtorAccounts = new DebtorAccounts(updateDto.getDebtorAccount().getIdentification(),
				updateDto.getDebtorAccount().getSecondaryIdentification(), updateDto.getDebtorAccount().getName(),
				updateDto.getDebtorAccount().getDestinationDNI(), creditorAccounts);
		
		EnrollmentAccounts data = new EnrollmentAccounts(updateDto.getEnrollmentId(), updateDto.getClientId(), debtorAccounts,
				new Date(), null);
		try {
			EnrollmentAccounts response = enrollmentAccountsRepository.save(data);
			return DtoDataObjectMapper.mapper(response);
		} catch (IOException e) {
			LOGGER.warn(e.getMessage(), e);
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
			if (entity == null) {
				throw new ApiException(404, DOCUMENT_NOT_FOUND + clientId);
			}
			dto = DtoDataObjectMapper.mapperResponse(entity);
			dto.setDescription(FOUND_FOR_ID + clientId);
			dto.setOperationDate(OffsetDateTime.now());
			return dto;
		} catch (IOException e) {
			throw new ApiException(500, SERVICE_ERROR + e.getMessage());
		}
	}

}
