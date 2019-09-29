package io.github.alancleetus.sacstateparking;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ParkingStructure extends RealmObject {

	@PrimaryKey
	int number;

	int totalSpots, spotsLeft, student, handicap, resident, faculty, ev, hov;
	int level1,level2,level3,level4,level5;
	String trend;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getTotalSpots() {
		return totalSpots;
	}

	public void setTotalSpots(int totalSpots) {
		this.totalSpots = totalSpots;
	}

	public int getSpotsLeft() {
		return spotsLeft;
	}

	public void setSpotsLeft(int spotsLeft) {
		this.spotsLeft = spotsLeft;
	}

	public int getStudent() {
		return student;
	}

	public void setStudent(int student) {
		this.student = student;
	}

	public int getHandicap() {
		return handicap;
	}

	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}

	public int getResident() {
		return resident;
	}

	public void setResident(int resident) {
		this.resident = resident;
	}

	public int getFaculty() {
		return faculty;
	}

	public void setFaculty(int faculty) {
		this.faculty = faculty;
	}

	public int getEv() {
		return ev;
	}

	public void setEv(int ev) {
		this.ev = ev;
	}

	public int getHov() {
		return hov;
	}

	public void setHov(int hov) {
		this.hov = hov;
	}

	public int getLevel1() {
		return level1;
	}

	public void setLevel1(int level1) {
		this.level1 = level1;
	}

	public int getLevel2() {
		return level2;
	}

	public void setLevel2(int level2) {
		this.level2 = level2;
	}

	public int getLevel3() {
		return level3;
	}

	public void setLevel3(int level3) {
		this.level3 = level3;
	}

	public int getLevel4() {
		return level4;
	}

	public void setLevel4(int level4) {
		this.level4 = level4;
	}

	public int getLevel5() {
		return level5;
	}

	public void setLevel5(int level5) {
		this.level5 = level5;
	}

	public String getTrend() {
		return trend;
	}

	public void setTrend(String trend) {
		this.trend = trend;
	}
}
