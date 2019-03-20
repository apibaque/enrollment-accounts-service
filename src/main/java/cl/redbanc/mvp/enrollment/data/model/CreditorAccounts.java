package cl.redbanc.mvp.enrollment.data.model;

import java.util.Date;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.PersistenceConstructor;

/**
 * CreditorAccount
 */
public class CreditorAccounts {
	
	private String identification = null;

	private String secondaryIdentification = null;

	private String name = null;

	private String destinationDNI = null;

	private Date validThru = null;

	
	@PersistenceConstructor
	public CreditorAccounts(String identification, String secondaryIdentification, String name, String destinationDNI,
			Date validThru) {
		super();
		this.identification = identification;
		this.secondaryIdentification = secondaryIdentification;
		this.name = name;
		this.destinationDNI = destinationDNI;
		this.validThru = validThru;
	}

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

	public CreditorAccounts secondaryIdentification(String secondaryIdentification) {
		this.secondaryIdentification = secondaryIdentification;
		return this;
	}

	@NotNull
	@Pattern(regexp = "^\\d{5}$")
	@Size(min = 5, max = 5)
	public String getSecondaryIdentification() {
		return secondaryIdentification;
	}

	public void setSecondaryIdentification(String secondaryIdentification) {
		this.secondaryIdentification = secondaryIdentification;
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

	public CreditorAccounts validThru(Date validThru) {
		this.validThru = validThru;
		return this;
	}

	@Valid
	public Date getValidThru() {
		return validThru;
	}

	public void setValidThru(Date validThru) {
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
				&& Objects.equals(this.secondaryIdentification, creditorAccount.secondaryIdentification)
				&& Objects.equals(this.name, creditorAccount.name)
				&& Objects.equals(this.destinationDNI, creditorAccount.destinationDNI)
				&& Objects.equals(this.validThru, creditorAccount.validThru);
	}

	@Override
	public int hashCode() {
		return Objects.hash(identification, secondaryIdentification, name, destinationDNI, validThru);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CreditorAccount {\n");

		sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
		sb.append("    secondaryIdentification: ").append(toIndentedString(secondaryIdentification)).append("\n");
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
