package algorithms.Search;
/**
 * Interface describe the searcher functions
 * @author Michael Kratik
 * @version 1.0
 *
 */
public interface Searcher {
	/**
	 * define the search mechanism functionality
	 * @param s - the search problem
	 * @return Solution of the problem
	 */
	Solution search(Searchable s);
}
