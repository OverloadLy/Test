package model;
// Generated 2017-10-29 14:32:57 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name = "student", catalog = "usermanager")
public class Student {

	private Integer id;
	private String sname;
	private String spass;
	private String class_;
	private Integer score;

	public Student() {
	}

	public Student(String sname, String spass, String class_, Integer score) {
		this.sname = sname;
		this.spass = spass;
		this.class_ = class_;
		this.score = score;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "sName", length = 30)
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "sPass", length = 30)
	public String getSpass() {
		return this.spass;
	}

	public void setSpass(String spass) {
		this.spass = spass;
	}

	@Column(name = "class", length = 30)
	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	@Column(name = "score")
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", spass=" + spass + ", class_=" + class_ + ", score=" + score
				+ "]";
	}

}
