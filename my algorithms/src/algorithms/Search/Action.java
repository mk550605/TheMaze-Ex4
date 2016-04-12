package algorithms.Search;
/**
 * define a Action in searcher domain
 * @author Michael Kratik
 *
 */
public class Action {
	private String description;
	private double cost;
	
	
	/**
	 * constructor for Action 
	 * define description and cost
	 * @param description
	 * @param cost
	 */
	public Action(String description, Double cost) {
		this.description = description;
		this.cost = cost;
	}
	
	
	/**
	 * Getter for description
	 * @return String description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Setter for description
	 * 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Getter for cost
	 * @return double cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * Setter for cost
	 * 
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}
	/**
	 * Hashcode for using Hashs
	 */
	@Override
	public int hashCode(){
		return description.hashCode();
	}
	/**
	 * Specific equals for Actions
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Action) {
			Action other = (Action)obj;
			return this.description.equals(other.description)
					&& this.cost == other.cost;
		} else {
			return false;
		}
	}
}
