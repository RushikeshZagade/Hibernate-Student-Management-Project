package hibernate_student.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_data")
public class Student {

	@Id
	private int id;
	private String name;
	@Column(unique = true)
	private long phone;
	private String fatherName;
	private String motherName;
	@Column(unique = true)
	private String email;
	private String address;
	private double mock_rating;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getMock_rating() {
		return mock_rating;
	}

	public void setMock_rating(double mock_rating) {
		this.mock_rating = mock_rating;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + ", email=" + email + ", address=" + address + ", mock_rating="
				+ mock_rating + "]";
	}

}
