package cl.redbanc.mvp.enrollment.data.model;

import java.time.OffsetDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

@Validated
public class EnrollmentAccounts {

	@Id
	private String enrollmentId = null;

	private String clientId;

	private DebtorAccounts debtorAccount = null;

	private OffsetDateTime creationDate;

	private OffsetDateTime modificationDate;

	public EnrollmentAccounts(String clientId, DebtorAccounts debtorAccount, OffsetDateTime creationDate,
			OffsetDateTime modificationDate) {
		super();
		this.clientId = clientId;
		this.debtorAccount = debtorAccount;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnrollmentAccounts [enrollmentId=");
		builder.append(enrollmentId);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", debtorAccount=");
		builder.append(debtorAccount);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append(", modificationDate=");
		builder.append(modificationDate);
		builder.append("]");
		return builder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((debtorAccount == null) ? 0 : debtorAccount.hashCode());
		result = prime * result + ((enrollmentId == null) ? 0 : enrollmentId.hashCode());
		result = prime * result + ((modificationDate == null) ? 0 : modificationDate.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EnrollmentAccounts))
			return false;
		EnrollmentAccounts other = (EnrollmentAccounts) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (debtorAccount == null) {
			if (other.debtorAccount != null)
				return false;
		} else if (!debtorAccount.equals(other.debtorAccount))
			return false;
		if (enrollmentId == null) {
			if (other.enrollmentId != null)
				return false;
		} else if (!enrollmentId.equals(other.enrollmentId))
			return false;
		if (modificationDate == null) {
			if (other.modificationDate != null)
				return false;
		} else if (!modificationDate.equals(other.modificationDate))
			return false;
		return true;
	}

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public DebtorAccounts getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(DebtorAccounts debtorAccount) {
		this.debtorAccount = debtorAccount;
	}

	public OffsetDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(OffsetDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public OffsetDateTime getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(OffsetDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}

}
