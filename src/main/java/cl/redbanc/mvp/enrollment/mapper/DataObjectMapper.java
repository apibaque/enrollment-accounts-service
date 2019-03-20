package cl.redbanc.mvp.enrollment.mapper;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.redbanc.mvp.enrollment.api.model.CreditorAccountsDto;
import cl.redbanc.mvp.enrollment.api.model.DebtorAccountsDto;
import cl.redbanc.mvp.enrollment.api.model.EnrollmentAccountsDto;
import cl.redbanc.mvp.enrollment.data.model.CreditorAccounts;
import cl.redbanc.mvp.enrollment.data.model.DebtorAccounts;
import cl.redbanc.mvp.enrollment.data.model.EnrollmentAccounts;

public final class DataObjectMapper {

	private DataObjectMapper() {
		// constructor
	}

	private static final ObjectMapper objectMapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	public static EnrollmentAccounts mapper(EnrollmentAccountsDto dto) throws IOException {
		String jsonInString = objectMapper.writeValueAsString(dto);
		return objectMapper.readValue(jsonInString, EnrollmentAccounts.class);
	}

	public static CreditorAccounts mapper(CreditorAccountsDto dto) throws IOException {
		String jsonInString = objectMapper.writeValueAsString(dto);
		return objectMapper.readValue(jsonInString, CreditorAccounts.class);
	}

	public static DebtorAccounts mapper(DebtorAccountsDto dto) throws IOException {
		String jsonInString = objectMapper.writeValueAsString(dto);
		return objectMapper.readValue(jsonInString, DebtorAccounts.class);
	}

}
