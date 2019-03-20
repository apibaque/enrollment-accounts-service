package cl.redbanc.mvp.enrollment.data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.PersistenceConstructor;

/**
 * DebtorAccount
 */
public class DebtorAccounts {
	
	private String identification = null;

	private String secondaryIdentification = null;

	private String name = null;

	private String destinationDNI = null;

	private List<CreditorAccounts> creditorAccounts = null;

	@PersistenceConstructor
	public DebtorAccounts(String identification, String secondaryIdentification, String name, String destinationDNI,
			@Valid List<CreditorAccounts> creditorAccounts) {
		super();
		this.identification = identification;
		this.secondaryIdentification = secondaryIdentification;
		this.name = name;
		this.destinationDNI = destinationDNI;
		this.creditorAccounts = creditorAccounts;
	}

	public DebtorAccounts identification(String identification) {
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

	public DebtorAccounts secondaryIdentification(String secondaryIdentification) {
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

	public DebtorAccounts name(String name) {
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

	public DebtorAccounts destinationDNI(String destinationDNI) {
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

	public DebtorAccounts creditorAccounts(List<CreditorAccounts> creditorAccounts) {
		this.creditorAccounts = creditorAccounts;
		return this;
	}

	public DebtorAccounts addCreditorAccountsItem(CreditorAccounts creditorAccountsItem) {
		if (this.creditorAccounts == null) {
			this.creditorAccounts = new ArrayList<CreditorAccounts>();
		}
		this.creditorAccounts.add(creditorAccountsItem);
		return this;
	}

	@Valid
	public List<CreditorAccounts> getCreditorAccounts() {
		return creditorAccounts;
	}

	public void setCreditorAccounts(List<CreditorAccounts> creditorAccounts) {
		this.creditorAccounts = creditorAccounts;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DebtorAccounts debtorAccount = (DebtorAccounts) o;
		return Objects.equals(this.identification, debtorAccount.identification)
				&& Objects.equals(this.secondaryIdentification, debtorAccount.secondaryIdentification)
				&& Objects.equals(this.name, debtorAccount.name)
				&& Objects.equals(this.destinationDNI, debtorAccount.destinationDNI)
				&& Objects.equals(this.creditorAccounts, debtorAccount.creditorAccounts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(identification, secondaryIdentification, name, destinationDNI, creditorAccounts);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DebtorAccount {\n");

		sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
		sb.append("    secondaryIdentification: ").append(toIndentedString(secondaryIdentification)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    destinationDNI: ").append(toIndentedString(destinationDNI)).append("\n");
		sb.append("    creditorAccounts: ").append(toIndentedString(creditorAccounts)).append("\n");
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
