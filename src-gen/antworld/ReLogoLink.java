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
public class ReLogoLink<T> extends BaseLink<T>	{

	/**
	 * Returns an agentset of antAWorkers on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of antAWorkers on patch p
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntAWorker")
	public AgentSet<antworld.relogo.AntAWorker> antAWorkersOn(Patch p){
		AgentSet<antworld.relogo.AntAWorker> result = new AgentSet<antworld.relogo.AntAWorker>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"antAWorker")){
			if (t instanceof antworld.relogo.AntAWorker)
			result.add((antworld.relogo.AntAWorker)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of antAWorkers on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of antAWorkers on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntAWorker")
	public AgentSet<antworld.relogo.AntAWorker> antAWorkersOn(Turtle t){
		AgentSet<antworld.relogo.AntAWorker> result = new AgentSet<antworld.relogo.AntAWorker>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"antAWorker")){
			if (tt instanceof antworld.relogo.AntAWorker)
			result.add((antworld.relogo.AntAWorker)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of antAWorkers on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of antAWorkers on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntAWorker")
	public AgentSet<antworld.relogo.AntAWorker> antAWorkersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<antworld.relogo.AntAWorker>();
		}

		Set<antworld.relogo.AntAWorker> total = new HashSet<antworld.relogo.AntAWorker>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(antAWorkersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(antAWorkersOn(p));
				}
			}
		}
		return new AgentSet<antworld.relogo.AntAWorker>(total);
	}

	/**
	 * Queries if object is a antAWorker.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a antAWorker
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntAWorker")
	public boolean isAntAWorkerQ(Object o){
		return (o instanceof antworld.relogo.AntAWorker);
	}

	/**
	 * Returns the antAWorker with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntAWorker")
	public antworld.relogo.AntAWorker antAWorker(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof antworld.relogo.AntAWorker)
			return (antworld.relogo.AntAWorker) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all antAWorkers.
	 * 
	 * @return agentset of all antAWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntAWorker")
	public AgentSet<antworld.relogo.AntAWorker> antAWorkers(){
		AgentSet<antworld.relogo.AntAWorker> a = new AgentSet<antworld.relogo.AntAWorker>();
		for (Object e : this.getMyObserver().getContext().getObjects(antworld.relogo.AntAWorker.class)) {
			if (e instanceof antworld.relogo.AntAWorker){
				a.add((antworld.relogo.AntAWorker)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of antBWorkers on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of antBWorkers on patch p
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntBWorker")
	public AgentSet<antworld.relogo.AntBWorker> antBWorkersOn(Patch p){
		AgentSet<antworld.relogo.AntBWorker> result = new AgentSet<antworld.relogo.AntBWorker>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"antBWorker")){
			if (t instanceof antworld.relogo.AntBWorker)
			result.add((antworld.relogo.AntBWorker)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of antBWorkers on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of antBWorkers on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntBWorker")
	public AgentSet<antworld.relogo.AntBWorker> antBWorkersOn(Turtle t){
		AgentSet<antworld.relogo.AntBWorker> result = new AgentSet<antworld.relogo.AntBWorker>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"antBWorker")){
			if (tt instanceof antworld.relogo.AntBWorker)
			result.add((antworld.relogo.AntBWorker)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of antBWorkers on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of antBWorkers on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntBWorker")
	public AgentSet<antworld.relogo.AntBWorker> antBWorkersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<antworld.relogo.AntBWorker>();
		}

		Set<antworld.relogo.AntBWorker> total = new HashSet<antworld.relogo.AntBWorker>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(antBWorkersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(antBWorkersOn(p));
				}
			}
		}
		return new AgentSet<antworld.relogo.AntBWorker>(total);
	}

	/**
	 * Queries if object is a antBWorker.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a antBWorker
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntBWorker")
	public boolean isAntBWorkerQ(Object o){
		return (o instanceof antworld.relogo.AntBWorker);
	}

	/**
	 * Returns the antBWorker with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntBWorker")
	public antworld.relogo.AntBWorker antBWorker(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof antworld.relogo.AntBWorker)
			return (antworld.relogo.AntBWorker) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all antBWorkers.
	 * 
	 * @return agentset of all antBWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntBWorker")
	public AgentSet<antworld.relogo.AntBWorker> antBWorkers(){
		AgentSet<antworld.relogo.AntBWorker> a = new AgentSet<antworld.relogo.AntBWorker>();
		for (Object e : this.getMyObserver().getContext().getObjects(antworld.relogo.AntBWorker.class)) {
			if (e instanceof antworld.relogo.AntBWorker){
				a.add((antworld.relogo.AntBWorker)e);
			}
		}
		return a;
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
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
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public antworld.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof antworld.relogo.UserTurtle)
			return (antworld.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> userTurtles(){
		AgentSet<antworld.relogo.UserTurtle> a = new AgentSet<antworld.relogo.UserTurtle>();
		for (Object e : this.getMyObserver().getContext().getObjects(antworld.relogo.UserTurtle.class)) {
			if (e instanceof antworld.relogo.UserTurtle){
				a.add((antworld.relogo.UserTurtle)e);
			}
		}
		return a;
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
		for (Object e : this.getMyObserver().getContext().getObjects(antworld.relogo.UserLink.class)) {
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
		return (antworld.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
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


}