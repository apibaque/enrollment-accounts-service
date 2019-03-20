package cl.redbanc.mvp.enrollment.api.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The payment initiation object can be used for three types of payments, which
 * should be specified in the &#x60;&#x60;&#x60;type&#x60;&#x60;&#x60; property:
 * * &#x60;&#x60;&#x60;enrollmentId&#x60;&#x60;&#x60;: The enrollment
 * identification number specified by the receiving end, often described in the
 * invoice.
 */
@Validated
public class EnrollmentAccountsDto {
	
	@JsonProperty("enrollmentId")
	private String enrollmentId = null;
	
	@JsonProperty("clientId")
	private String clientId = null;

	@JsonProperty("debtorAccount")
	private DebtorAccountsDto debtorAccount = null;

	public EnrollmentAccountsDto enrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
		return this;
	}
	
	public EnrollmentAccountsDto clientId(String clientId) {
		this.clientId = clientId;
		return this;
	}
	
	/**
	 * @return the enrollmentId
	 */
	public String getEnrollmentId() {
		return enrollmentId;
	}

	/**
	 * @param enrollmentId the enrollmentId to set
	 */
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	/**
	 * Get clientId
	 * 
	 * @return clientId
	 **/
	@NotNull
	@Pattern(regexp = "^\\d{24}$")
	@Size(min = 24, max = 24)
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public EnrollmentAccountsDto debtorAccount(DebtorAccountsDto debtorAccount) {
		this.debtorAccount = debtorAccount;
		return this;
	}

	/**
	 * Get debtorAccount
	 * 
	 * @return debtorAccount
	 **/
	@NotNull
	@Valid
	public DebtorAccountsDto getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(DebtorAccountsDto debtorAccount) {
		this.debtorAccount = debtorAccount;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EnrollmentAccountsDto enrollmentRequest = (EnrollmentAccountsDto) o;
		return Objects.equals(this.clientId, enrollmentRequest.clientId)
				&& Objects.equals(this.debtorAccount, enrollmentRequest.debtorAccount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId, debtorAccount);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EnrollmentRequest {\n");

		sb.append("    enrollmentId: ").append(toIndentedString(clientId)).append("\n");
		sb.append("    debtorAccount: ").append(toIndentedString(debtorAccount)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
