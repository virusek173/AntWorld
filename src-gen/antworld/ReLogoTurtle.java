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
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoTurtle extends BaseTurtle{

	/**
	 * Makes a number of new antWorkers and then executes a set of commands on the
	 * created antWorkers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created antWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> hatchAntWorkers(int number, Closure closure) {
		AgentSet<antworld.relogo.AntWorker> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"AntWorker");
		for (Turtle t : createResult){
			if (t instanceof antworld.relogo.AntWorker){
				result.add((antworld.relogo.AntWorker)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new antWorkers and then executes a set of commands on the
	 * created antWorkers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created antWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> hatchAntWorkers(int number) {
		return hatchAntWorkers(number,null);
	}

	/**
	 * Returns an agentset of antWorkers from the patch of the caller.
	 * 
	 * @return agentset of antWorkers from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> antWorkersHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<antworld.relogo.AntWorker> result = new AgentSet<antworld.relogo.AntWorker>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"antWorker")){
			if (t instanceof antworld.relogo.AntWorker)
			result.add((antworld.relogo.AntWorker)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of antWorkers on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of antWorkers at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> antWorkersAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<antworld.relogo.AntWorker> result = new AgentSet<antworld.relogo.AntWorker>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"antWorker")){
			if (t instanceof antworld.relogo.AntWorker)
			result.add((antworld.relogo.AntWorker)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<antworld.relogo.AntWorker>();
		}
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"antWorker")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"antWorker")){
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
		for (Object e : this.getMyObserver().getContext().getObjects(antworld.relogo.AntWorker.class)) {
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
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof antworld.relogo.AntWorker)
			return (antworld.relogo.AntWorker) turtle;
		return null;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> hatchUserTurtles(int number, Closure closure) {
		AgentSet<antworld.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof antworld.relogo.UserTurtle){
				result.add((antworld.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> hatchUserTurtles(int number) {
		return hatchUserTurtles(number,null);
	}

	/**
	 * Returns an agentset of userTurtles from the patch of the caller.
	 * 
	 * @return agentset of userTurtles from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> userTurtlesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<antworld.relogo.UserTurtle> result = new AgentSet<antworld.relogo.UserTurtle>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof antworld.relogo.UserTurtle)
			result.add((antworld.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of userTurtles on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of userTurtles at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> userTurtlesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<antworld.relogo.UserTurtle> result = new AgentSet<antworld.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof antworld.relogo.UserTurtle)
			result.add((antworld.relogo.UserTurtle)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<antworld.relogo.UserTurtle>();
		}
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
	 * Returns the value from the getPheromoneColors() method of the underlying patch.
	 * 
	 * @return getPheromoneColors() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserPatch")
	public java.lang.Object getPheromoneColors(){
		antworld.relogo.UserPatch p = (antworld.relogo.UserPatch)patchHere();
		return p.getPheromoneColors();
	}

	/**
	 * Calls the setPheromoneColors(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserPatch")
	public void setPheromoneColors(java.lang.Object value){
		antworld.relogo.UserPatch p = (antworld.relogo.UserPatch)patchHere();
		p.setPheromoneColors(value);
	}

	/**
	 * Returns the value from the getMODE_TEAMA() method of the underlying patch.
	 * 
	 * @return getMODE_TEAMA() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserPatch")
	public java.lang.Object getMODE_TEAMA(){
		antworld.relogo.UserPatch p = (antworld.relogo.UserPatch)patchHere();
		return p.getMODE_TEAMA();
	}

	/**
	 * Calls the setMODE_TEAMA(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserPatch")
	public void setMODE_TEAMA(java.lang.Object value){
		antworld.relogo.UserPatch p = (antworld.relogo.UserPatch)patchHere();
		p.setMODE_TEAMA(value);
	}

	/**
	 * Returns the value from the getMODE_TEAMB() method of the underlying patch.
	 * 
	 * @return getMODE_TEAMB() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserPatch")
	public java.lang.Object getMODE_TEAMB(){
		antworld.relogo.UserPatch p = (antworld.relogo.UserPatch)patchHere();
		return p.getMODE_TEAMB();
	}

	/**
	 * Calls the setMODE_TEAMB(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserPatch")
	public void setMODE_TEAMB(java.lang.Object value){
		antworld.relogo.UserPatch p = (antworld.relogo.UserPatch)patchHere();
		p.setMODE_TEAMB(value);
	}

	/**
	 * Returns the value from the getMODE_NEUTRAL() method of the underlying patch.
	 * 
	 * @return getMODE_NEUTRAL() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserPatch")
	public java.lang.Object getMODE_NEUTRAL(){
		antworld.relogo.UserPatch p = (antworld.relogo.UserPatch)patchHere();
		return p.getMODE_NEUTRAL();
	}

	/**
	 * Calls the setMODE_NEUTRAL(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserPatch")
	public void setMODE_NEUTRAL(java.lang.Object value){
		antworld.relogo.UserPatch p = (antworld.relogo.UserPatch)patchHere();
		p.setMODE_NEUTRAL(value);
	}

	/**
	 * Returns the value from the getPatchMode() method of the underlying patch.
	 * 
	 * @return getPatchMode() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserPatch")
	public java.lang.Object getPatchMode(){
		antworld.relogo.UserPatch p = (antworld.relogo.UserPatch)patchHere();
		return p.getPatchMode();
	}

	/**
	 * Calls the setPatchMode(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserPatch")
	public void setPatchMode(java.lang.Object value){
		antworld.relogo.UserPatch p = (antworld.relogo.UserPatch)patchHere();
		p.setPatchMode(value);
	}

	/**
	 * Makes a directed userLink from a turtle to the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public antworld.relogo.UserLink createUserLinkFrom(Turtle t, Closure closure){
		antworld.relogo.UserLink link = (antworld.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public antworld.relogo.UserLink createUserLinkFrom(Turtle t){
			return createUserLinkFrom(t,null);
	}

	/**
	 * Makes directed userLinks from a collection to the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public AgentSet<antworld.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a, Closure closure){
		AgentSet<antworld.relogo.UserLink> links = new AgentSet<antworld.relogo.UserLink>();
		for(Turtle t : a){
			links.add((antworld.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this));
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks from a collection to the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public AgentSet<antworld.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a){
		return createUserLinksFrom(a,null);
	}

	/**
	 * Makes a directed userLink to a turtle from the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public antworld.relogo.UserLink createUserLinkTo(Turtle t, Closure closure){
		antworld.relogo.UserLink link = (antworld.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,t);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public antworld.relogo.UserLink createUserLinkTo(Turtle t){
			return createUserLinkTo(t,null);
	}

	/**
	 * Makes directed userLinks to a collection from the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public AgentSet<antworld.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a, Closure closure){
		AgentSet<antworld.relogo.UserLink> links = new AgentSet<antworld.relogo.UserLink>();
		for(Object t : a){
			if (t instanceof Turtle){
				links.add((antworld.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,(Turtle)t));
			}
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks to a collection from the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public AgentSet<antworld.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a){
		return createUserLinksTo(a,null);
	}

	/**
	 * Queries if there is a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink from
	 *         turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public boolean inUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(t, this);
	}

	/**
	 * Returns the agentset with directed userLinks to the caller.
	 * 
	 * @return agentset with directed userLinks to the caller
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public AgentSet inUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getPredecessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink from turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public antworld.relogo.UserLink inUserLinkFrom(Turtle t){
		return (antworld.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(t,this);
	}

	/**
	 * Returns an agentset of directed userLinks from other turtles to the caller.
	 * 
	 * @return agentset of directed userLinks from other turtles to the caller
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public AgentSet<antworld.relogo.UserLink> myInUserLinks(){
		AgentSet<antworld.relogo.UserLink> result = new AgentSet<antworld.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getInEdges(this)){
			if (o instanceof antworld.relogo.UserLink){
				result.add((antworld.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Returns an agentset of directed userLinks to other turtles from the caller.
	 * 
	 * @return agentset of directed userLinks to other turtles from the caller
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public AgentSet<antworld.relogo.UserLink> myOutUserLinks(){
		AgentSet<antworld.relogo.UserLink> result = new AgentSet<antworld.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getOutEdges(this)){
			if (o instanceof antworld.relogo.UserLink){
				result.add((antworld.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Queries if there is a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink to
	 *         turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public boolean outUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(this, t);
	}

	/**
	 * Returns the agentset with directed userLinks from the caller.
	 * 
	 * @return agentset with directed userLinks from the caller
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public AgentSet outUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getSuccessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink to turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public antworld.relogo.UserLink outUserLinkTo(Turtle t){
		return (antworld.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(this, t);
	}

	/**
	 * Reports true if there is a userLink connecting t and the caller.
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public boolean userLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isAdjacent(this, t);
	}

	/**
	 * Returns the agentset of all turtles found at the other end of
	 * userLinks connected to the calling turtle.
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public AgentSet userLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getAdjacent(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns an agentset of the caller's userLinks.
	 * 
	 * @return agentset of the caller's userLinks
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserLink")
	public AgentSet<antworld.relogo.UserLink> myUserLinks(){
		AgentSet<antworld.relogo.UserLink> result = new AgentSet<antworld.relogo.UserLink>();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getEdges(this)){
			if (o instanceof antworld.relogo.UserLink){
				result.add((antworld.relogo.UserLink)o);
			}
		}
		return result;
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