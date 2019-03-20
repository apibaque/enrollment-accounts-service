package cl.redbanc.mvp.enrollment.api.controllers;

import java.time.OffsetDateTime;

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
 * A enrollment controller to add new enrollement accounts
 */
@RestController
public class EnrollmentAccountsController {
	
	@Autowired
	private EnrollmentAccountsService service;
	
    /**
     *Get enrollmentAccounts by enrollment Id
     * @param name the name to greet
     * @return 
     */
    @RequestMapping(value = "/enrollments/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EnrollmentAccountsResponseDto> getEnrollmentAccounts(@PathVariable String id) {
    	try {
    		EnrollmentAccountsResponseDto response = service.findById(id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ApiException e) {
			return new ResponseEntity<>(HttpStatus.valueOf(e.getCode()));
		}
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/enrollments")
    public ResponseEntity<EnrollmentAccountsResponseDto> addEnrollmentAccounts(@RequestBody EnrollmentAccountsDto body) {
    	try {
    		EnrollmentAccountsDto dto = service.save(body);
    		EnrollmentAccountsResponseDto response = new EnrollmentAccountsResponseDto();
    		response.setDescription("Enrollment accounts created ");
    		response.setEnrollmentId(dto.getEnrollmentId());
    		response.setOperationDate(OffsetDateTime.now());
    		
    		return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (ApiException e) {
			return new ResponseEntity<>(HttpStatus.valueOf(e.getCode()));
		}
    }
}
