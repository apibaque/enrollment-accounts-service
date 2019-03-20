package cl.redbanc.mvp.enrollment.mapper;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.redbanc.mvp.enrollment.api.model.CreditorAccountsDto;
import cl.redbanc.mvp.enrollment.api.model.DebtorAccountsDto;
import cl.redbanc.mvp.enrollment.api.model.EnrollmentAccountsDto;
import cl.redbanc.mvp.enrollment.api.model.EnrollmentAccountsResponseDto;
import cl.redbanc.mvp.enrollment.data.model.CreditorAccounts;
import cl.redbanc.mvp.enrollment.data.model.DebtorAccounts;
import cl.redbanc.mvp.enrollment.data.model.EnrollmentAccounts;

public final class DtoDataObjectMapper {

	private DtoDataObjectMapper() {
		// constructor
	}

	private static final ObjectMapper objectMapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	public static EnrollmentAccountsDto mapper(EnrollmentAccounts data) throws IOException {
		String jsonInString = objectMapper.writeValueAsString(data);
		return objectMapper.readValue(jsonInString, EnrollmentAccountsDto.class);
	}
	
	public static EnrollmentAccountsResponseDto mapperResponse(EnrollmentAccounts data) throws IOException {
		String jsonInString = objectMapper.writeValueAsString(data);
		return objectMapper.readValue(jsonInString, EnrollmentAccountsResponseDto.class);
	}

	public static CreditorAccountsDto mapper(CreditorAccounts data) throws IOException {
		String jsonInString = objectMapper.writeValueAsString(data);
		return objectMapper.readValue(jsonInString, CreditorAccountsDto.class);
	}

	public static DebtorAccountsDto mapper(DebtorAccounts data) throws IOException {
		String jsonInString = objectMapper.writeValueAsString(data);
		return objectMapper.readValue(jsonInString, DebtorAccountsDto.class);
	}

}
