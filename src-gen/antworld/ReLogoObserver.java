package antworld;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoObserver extends BaseObserver{

	/**
	 * Makes a number of randomly oriented antWorkers and then executes a set of commands on the
	 * created antWorkers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created antWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> createAntWorkers(int number, Closure closure) {
		AgentSet<antworld.relogo.AntWorker> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"AntWorker");
		for (Turtle t : createResult){
			if (t instanceof antworld.relogo.AntWorker){
				result.add((antworld.relogo.AntWorker)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented antWorkers and then executes a set of commands on the
	 * created antWorkers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created antWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> createAntWorkers(int number) {
		return createAntWorkers(number,null);
	}

	/**
	 * Makes a number of uniformly fanned antWorkers and then executes a set of commands on the
	 * created antWorkers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created antWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> createOrderedAntWorkers(int number, Closure closure) {
		AgentSet<antworld.relogo.AntWorker> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"AntWorker");
		for (Turtle t : createResult){
			if (t instanceof antworld.relogo.AntWorker){
				result.add((antworld.relogo.AntWorker)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned antWorkers and then executes a set of commands on the
	 * created antWorkers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created antWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> createOrderedAntWorkers(int number) {
		return createOrderedAntWorkers(number,null);
	}

	/**
	 * Queries if object is a antWorker.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a antWorker
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public boolean isAntWorkerQ(Object o){
		return (o instanceof antworld.relogo.AntWorker);
	}

	/**
	 * Returns an agentset containing all antWorkers.
	 * 
	 * @return agentset of all antWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> antWorkers(){
		AgentSet<antworld.relogo.AntWorker> a = new AgentSet<antworld.relogo.AntWorker>();
		for (Object e : this.getContext().getObjects(antworld.relogo.AntWorker.class)) {
			if (e instanceof antworld.relogo.AntWorker){
				a.add((antworld.relogo.AntWorker)e);
			}
		}
		return a;
	}

	/**
	 * Returns the antWorker with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public antworld.relogo.AntWorker antWorker(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof antworld.relogo.AntWorker)
			return (antworld.relogo.AntWorker) turtle;
		return null;
	}

	/**
	 * Returns an agentset of antWorkers on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of antWorkers on patch p
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> antWorkersOn(Patch p){
		AgentSet<antworld.relogo.AntWorker> result = new AgentSet<antworld.relogo.AntWorker>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"antWorker")){
			if (t instanceof antworld.relogo.AntWorker)
			result.add((antworld.relogo.AntWorker)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of antWorkers on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of antWorkers on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> antWorkersOn(Turtle t){
		AgentSet<antworld.relogo.AntWorker> result = new AgentSet<antworld.relogo.AntWorker>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"antWorker")){
			if (tt instanceof antworld.relogo.AntWorker)
			result.add((antworld.relogo.AntWorker)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of antWorkers on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of antWorkers on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> antWorkersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<antworld.relogo.AntWorker>();
		}

		Set<antworld.relogo.AntWorker> total = new HashSet<antworld.relogo.AntWorker>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(antWorkersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(antWorkersOn(p));
				}
			}
		}
		return new AgentSet<antworld.relogo.AntWorker>(total);
	}

	/**
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> createUserTurtles(int number, Closure closure) {
		AgentSet<antworld.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof antworld.relogo.UserTurtle){
				result.add((antworld.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> createUserTurtles(int number) {
		return createUserTurtles(number,null);
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> createOrderedUserTurtles(int number, Closure closure) {
		AgentSet<antworld.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof antworld.relogo.UserTurtle){
				result.add((antworld.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> createOrderedUserTurtles(int number) {
		return createOrderedUserTurtles(number,null);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof antworld.relogo.UserTurtle);
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> userTurtles(){
		AgentSet<antworld.relogo.UserTurtle> a = new AgentSet<antworld.relogo.UserTurtle>();
		for (Object e : this.getContext().getObjects(antworld.relogo.UserTurtle.class)) {
			if (e instanceof antworld.relogo.UserTurtle){
				a.add((antworld.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public antworld.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof antworld.relogo.UserTurtle)
			return (antworld.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<antworld.relogo.UserTurtle> result = new AgentSet<antworld.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"userTurtle")){
			if (t instanceof antworld.relogo.UserTurtle)
			result.add((antworld.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<antworld.relogo.UserTurtle> result = new AgentSet<antworld.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"userTurtle")){
			if (tt instanceof antworld.relogo.UserTurtle)
			result.add((antworld.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<antworld.relogo.UserTurtle>();
		}

		Set<antworld.relogo.UserTurtle> total = new HashSet<antworld.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<antworld.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof antworld.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public AgentSet<antworld.relogo.UserLink> userLinks(){
		AgentSet<antworld.relogo.UserLink> a = new AgentSet<antworld.relogo.UserLink>();
		for (Object e : this.getContext().getObjects(antworld.relogo.UserLink.class)) {
			if (e instanceof antworld.relogo.UserLink){
				a.add((antworld.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public antworld.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (antworld.relogo.UserLink)(this.getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public antworld.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Returns the value of the global variable numAnts.
	 *
	 * @return the value of the global variable numAnts
	 */
	@ReLogoBuilderGeneratedFor("global: numAnts")
	public Object getNumAnts(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numAnts");
	}

	/**
	 * Sets the value of the global variable numAnts.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numAnts")
	public void setNumAnts(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numAnts",value);
	}

	/**
	 * Returns the value of the global variable numLarva.
	 *
	 * @return the value of the global variable numLarva
	 */
	@ReLogoBuilderGeneratedFor("global: numLarva")
	public Object getNumLarva(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numLarva");
	}

	/**
	 * Sets the value of the global variable numLarva.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numLarva")
	public void setNumLarva(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numLarva",value);
	}


}