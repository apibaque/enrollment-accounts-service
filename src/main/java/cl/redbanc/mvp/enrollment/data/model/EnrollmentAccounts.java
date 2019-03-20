package cl.redbanc.mvp.enrollment.data.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="enrollmentAccounts")
@TypeAlias("enrollmentAccount")
public class EnrollmentAccounts {

	@Id
	private String enrollmentId = null;

	@TextIndexed
	private String clientId;

	private Date creationDate;

	private Date modificationDate;
	
	private DebtorAccounts debtorAccount = null;

	public EnrollmentAccounts() {
		// 
	}
	
	@PersistenceConstructor
	public EnrollmentAccounts(String enrollmentId, String clientId, DebtorAccounts debtorAccount, Date creationDate,
			 Date modificationDate) {
		super();
		this.enrollmentId = enrollmentId;
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

	public  Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate( Date creationDate) {
		this.creationDate = creationDate;
	}

	public  Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate( Date modificationDate) {
		this.modificationDate = modificationDate;
	}

}
