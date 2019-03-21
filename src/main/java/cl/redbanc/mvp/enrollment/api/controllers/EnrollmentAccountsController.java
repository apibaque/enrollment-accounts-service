package cl.redbanc.mvp.enrollment.api.controllers;

import java.time.OffsetDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.redbanc.mvp.enrollment.api.exception.ApiException;
import cl.redbanc.mvp.enrollment.api.model.EnrollmentAccountsDto;
import cl.redbanc.mvp.enrollment.api.model.EnrollmentAccountsResponseDto;
import cl.redbanc.mvp.enrollment.data.service.EnrollmentAccountsService;

/**
 *
 * A enrollment controller to add new enrollement accounts.
 */
@RestController
public class EnrollmentAccountsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnrollmentAccountsController.class);

	@Autowired
	private EnrollmentAccountsService service;

	/**
	 * Get enrollmentAccounts by enrollment Id.
	 * 
	 * @param name
	 *            the name to greet
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/enrollments/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<EnrollmentAccountsResponseDto> getEnrollmentAccounts(@PathVariable String id) {
		LOGGER.info("[getEnrollmentAccounts] Getting enrollment request for id [{}]", id);
		try {
			EnrollmentAccountsResponseDto response = service.findById(id);
			LOGGER.info("[getEnrollmentAccounts] Enrollment accounts response [{}]", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApiException e) {
			LOGGER.error(e.getMessage(), e.getCause());
			return new ResponseEntity<>(HttpStatus.valueOf(e.getCode()));
		}
	}

	/**
	 * Add or update a enrollment accounts registry. 
	 * @param body
	 * @return ResponseEntity
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/enrollments")
	public ResponseEntity<EnrollmentAccountsResponseDto> addEnrollmentAccounts(
			@RequestBody EnrollmentAccountsDto body) {
		LOGGER.info("[addEnrollmentAccounts] Adding enrollment accounts request body [{}]", body);
		try {
			EnrollmentAccountsDto dto = service.save(body);
			EnrollmentAccountsResponseDto response = new EnrollmentAccountsResponseDto();
			response.setDescription("Enrollment accounts created ");
			response.setEnrollmentId(dto.getEnrollmentId());
			response.setOperationDate(OffsetDateTime.now());
			LOGGER.info("[addEnrollmentAccounts] Enrollment accounts response [{}]", response);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (ApiException e) {
			LOGGER.error(e.getMessage(), e.getCause());
			return new ResponseEntity<>(HttpStatus.valueOf(e.getCode()));
		}
	}
}
