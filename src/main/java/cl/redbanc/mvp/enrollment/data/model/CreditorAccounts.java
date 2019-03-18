package cl.redbanc.mvp.enrollment.data.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

/**
 * CreditorAccount
 */
@Validated
public class CreditorAccounts {
	private String identification = null;

	private String secundaryIdentification = null;

	private String name = null;

	private String destinationDNI = null;

	private OffsetDateTime validThru = null;

	public CreditorAccounts identification(String identification) {
		this.identification = identification;
		return this;
	}

	@NotNull
	@Pattern(regexp = "^\\d{8,20}$")
	@Size(min = 8, max = 20)
	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public CreditorAccounts secundaryIdentification(String secundaryIdentification) {
		this.secundaryIdentification = secundaryIdentification;
		return this;
	}

	@NotNull
	@Pattern(regexp = "^\\d{5}$")
	@Size(min = 5, max = 5)
	public String getSecundaryIdentification() {
		return secundaryIdentification;
	}

	public void setSecundaryIdentification(String secundaryIdentification) {
		this.secundaryIdentification = secundaryIdentification;
	}

	public CreditorAccounts name(String name) {
		this.name = name;
		return this;
	}

	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CreditorAccounts destinationDNI(String destinationDNI) {
		this.destinationDNI = destinationDNI;
		return this;
	}

	@NotNull
	@Pattern(regexp = "^\\d{7,8}$")
	@Size(min = 7, max = 8)
	public String getDestinationDNI() {
		return destinationDNI;
	}

	public void setDestinationDNI(String destinationDNI) {
		this.destinationDNI = destinationDNI;
	}

	public CreditorAccounts validThru(OffsetDateTime validThru) {
		this.validThru = validThru;
		return this;
	}

	@Valid
	public OffsetDateTime getValidThru() {
		return validThru;
	}

	public void setValidThru(OffsetDateTime validThru) {
		this.validThru = validThru;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CreditorAccounts creditorAccount = (CreditorAccounts) o;
		return Objects.equals(this.identification, creditorAccount.identification)
				&& Objects.equals(this.secundaryIdentification, creditorAccount.secundaryIdentification)
				&& Objects.equals(this.name, creditorAccount.name)
				&& Objects.equals(this.destinationDNI, creditorAccount.destinationDNI)
				&& Objects.equals(this.validThru, creditorAccount.validThru);
	}

	@Override
	public int hashCode() {
		return Objects.hash(identification, secundaryIdentification, name, destinationDNI, validThru);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CreditorAccount {\n");

		sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
		sb.append("    secundaryIdentification: ").append(toIndentedString(secundaryIdentification)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    destinationDNI: ").append(toIndentedString(destinationDNI)).append("\n");
		sb.append("    validThru: ").append(toIndentedString(validThru)).append("\n");
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
