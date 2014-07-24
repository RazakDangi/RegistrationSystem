package com.mc.rad.model;

public class CustomerVO {

	Long totalCount;
	
	int statesCount;
	
	int countriesCount;

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public int getStatesCount() {
		return statesCount;
	}

	public void setStatesCount(int statesCount) {
		this.statesCount = statesCount;
	}

	public int getCountriesCount() {
		return countriesCount;
	}

	public void setCountriesCount(int countriesCount) {
		this.countriesCount = countriesCount;
	}

	@Override
	public String toString() {
		return "CustomerVO [totalCount=" + totalCount + ", statesCount="
				+ statesCount + ", countriesCount=" + countriesCount + "]";
	}


	
	
	
	
}
