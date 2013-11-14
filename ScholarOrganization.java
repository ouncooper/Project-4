import java.io.Serializable;


public abstract class ScholarOrganization implements Serializable{

	private static final long serialVersionUID = 8369931218405922856L;
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
	
	public void setName(String input){
		name = input;
	}
	
}
