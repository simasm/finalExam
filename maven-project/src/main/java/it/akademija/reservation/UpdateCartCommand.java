package it.akademija.reservation;

import java.util.List;

public class UpdateCartCommand {

	private List<Long> updatedItems;

	public List<Long> getUpdatedItems() {
		return updatedItems;
	}

	public void setUpdatedItems(List<Long> updatedItems) {
		this.updatedItems = updatedItems;
	}

}
