package se.ludvig.hourly;

import java.util.ArrayList;

public class EmployeeManager {

	ArrayList<Employer> employers;
	public EmployeeManager() 
	{
		employers = new ArrayList<Employer>();
		fillListWithFake();
	}
	private void fillListWithFake() {
		
		employers.add(new Employer("Ikea", "Malmö Kronprinsen", 100));
		employers.add(new Employer("MAH", "Ubåtshallen", 40));
		employers.add(new Employer("Svea Rike", "Malmstensland nr 1", 150));
		
	}
	public ArrayList<Employer> getList()
	{
		return employers;
	}
	

}
