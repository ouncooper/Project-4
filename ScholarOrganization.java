
public abstract class ScholarOrganization {
	/* A variable to store the name of the organization */
	private String name;
	
	/**
	 * Default constructor
	 */
	public ScholarOrganization() { }
	
	/**
	 * Preferred constructor
	 * @param name the name of the organization
	 */
	public ScholarOrganization(String name) {
		this.name = name;
	}
	
	
	/**
	 * Getter for name
	 * @return Name of the scholar organization
	 */
	public String getName()
	{
		return name;
	}
}