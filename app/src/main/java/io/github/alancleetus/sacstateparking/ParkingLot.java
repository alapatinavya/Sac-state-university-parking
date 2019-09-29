package io.github.alancleetus.sacstateparking;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ParkingLot extends RealmObject {
	@PrimaryKey
	int number;

	int totalSpots, spotsLeft, student, handicap, resident, faculty, ev, hov;
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

	public String getTrend() {
		return trend;
	}

	public void setTrend(String trend) {
		this.trend = trend;
	}
}
