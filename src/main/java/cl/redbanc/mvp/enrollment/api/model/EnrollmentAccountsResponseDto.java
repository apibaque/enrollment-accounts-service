package cl.redbanc.mvp.enrollment.api.model;

import java.time.OffsetDateTime;
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
 * * &#x60;&#x60;&#x60;ORDERID&#x60;&#x60;&#x60;: The Go Socket identification
 * number specified by the receiving end, often described in the invoice.
 * Payment initiator: Part of the context object, but kept here too for
 * reference.
 */
@Validated
public class EnrollmentAccountsResponseDto {
	
	@JsonProperty("enrollmentId")
	private String enrollmentId = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("operationDate")
	private OffsetDateTime operationDate = null;

	@JsonProperty("debtorAccount")
	private DebtorAccountsDto debtorAccount = null;

	public EnrollmentAccountsResponseDto enrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
		return this;
	}

	/**
	 * Get enrollmentId
	 * 
	 * @return enrollmentId
	 **/
	@NotNull
	@Pattern(regexp = "^\\w{24}$")
	@Size(min = 24, max = 24)
	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public EnrollmentAccountsResponseDto description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * 
	 * @return description
	 **/
	@NotNull
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EnrollmentAccountsResponseDto operationDate(OffsetDateTime operationDate) {
		this.operationDate = operationDate;
		return this;
	}

	/**
	 * Get operationDate
	 * 
	 * @return operationDate
	 **/
	@NotNull
	@Valid
	public OffsetDateTime getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(OffsetDateTime operationDate) {
		this.operationDate = operationDate;
	}

	public EnrollmentAccountsResponseDto debtorAccount(DebtorAccountsDto debtorAccount) {
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
		EnrollmentAccountsResponseDto enrollmentAccountsResponse = (EnrollmentAccountsResponseDto) o;
		return Objects.equals(this.enrollmentId, enrollmentAccountsResponse.enrollmentId)
				&& Objects.equals(this.description, enrollmentAccountsResponse.description)
				&& Objects.equals(this.operationDate, enrollmentAccountsResponse.operationDate)
				&& Objects.equals(this.debtorAccount, enrollmentAccountsResponse.debtorAccount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(enrollmentId, description, operationDate, debtorAccount);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EnrollmentAccountsResponse {\n");

		sb.append("    enrollmentId: ").append(toIndentedString(enrollmentId)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    operationDate: ").append(toIndentedString(operationDate)).append("\n");
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
