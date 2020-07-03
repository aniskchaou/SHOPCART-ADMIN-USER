package uha.anis.fr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10,name="user_id")
	int userId;
	@Column(length = 10,name="user_email")
	String userEmail;
	@Column(length = 100,name="user_password")
	String userPassword;
	@Column(length = 100,name="user_phone")
	String userPhone;
	@Column(length = 100,name="user_pic")
	String userPic;
	@Column(length = 100,name="user_address")
	String userAdress;
	@Column(length = 100,name="user_type")
	String userType;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userEmail, String userPassword, String userPhone, String userPic,
			String userAdress) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userPic = userPic;
		this.userAdress = userAdress;
		this.userType="normal";
	}

	public User(String userEmail, String userPassword, String userPhone, String userPic, String userAdress) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userPic = userPic;
		this.userAdress = userAdress;
		this.userType="normal";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getUserAdress() {
		return userAdress;
	}

	public void setUserAdress(String userAdress) {
		this.userAdress = userAdress;
	}

	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userPhone="
				+ userPhone + ", userPic=" + userPic + ", userAdress=" + userAdress + "]";
	}
	
	
	
}
