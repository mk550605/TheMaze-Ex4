package Model.algorithms.Search;
/**
 * Define a State of Searcher 
 * @author Michael Kratik
 * @version 1.0
 * 
 */
public class State implements Comparable<State> {
	private String description;
	private double cost;
	private State comeFrom;
	/**
	 * Getter of description
	 * @return String description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Setter of description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Getter of Cost
	 * @return Double Cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * Setter of CostS
	 * @param cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * Getter of Come_From
	 * @return State comeFrom
	 */
	public State getCameFrom() {
		return comeFrom;
	}
	/**
	 * Setter Come_From
	 * @param cameFrom
	 */
	public void setCameFrom(State cameFrom) {
		this.comeFrom = cameFrom;
	}
	/**
	 * Override the toString
	 * @return String description
	 */
	@Override
	public String toString() {
		return description;
	}
	/**
	 * Override compareTo
	 * @return int with reduction of costs
	 */
	@Override
	public int compareTo(State s) {
		return (int)(this.cost - s.cost);

	}
	/**
	 * Override equals
	 * compare descriptions
	 * @return Boolean
	 */
	@Override
	public boolean equals(Object arg0) {
		State state = (State)arg0;
		return description.equals(state.description);
	}
	/**
	 * Override hashCode
	 * @return int hash of description
	 */
	@Override
	public int hashCode(){
		return description.hashCode();
	}
	
	
}
