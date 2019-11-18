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
	 * Makes a number of new antAWorkers and then executes a set of commands on the
	 * created antAWorkers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created antAWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntAWorker")
	public AgentSet<antworld.relogo.AntAWorker> hatchAntAWorkers(int number, Closure closure) {
		AgentSet<antworld.relogo.AntAWorker> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"AntAWorker");
		for (Turtle t : createResult){
			if (t instanceof antworld.relogo.AntAWorker){
				result.add((antworld.relogo.AntAWorker)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new antAWorkers and then executes a set of commands on the
	 * created antAWorkers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created antAWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntAWorker")
	public AgentSet<antworld.relogo.AntAWorker> hatchAntAWorkers(int number) {
		return hatchAntAWorkers(number,null);
	}

	/**
	 * Returns an agentset of antAWorkers from the patch of the caller.
	 * 
	 * @return agentset of antAWorkers from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntAWorker")
	public AgentSet<antworld.relogo.AntAWorker> antAWorkersHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<antworld.relogo.AntAWorker> result = new AgentSet<antworld.relogo.AntAWorker>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"antAWorker")){
			if (t instanceof antworld.relogo.AntAWorker)
			result.add((antworld.relogo.AntAWorker)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of antAWorkers on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of antAWorkers at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntAWorker")
	public AgentSet<antworld.relogo.AntAWorker> antAWorkersAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<antworld.relogo.AntAWorker> result = new AgentSet<antworld.relogo.AntAWorker>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"antAWorker")){
			if (t instanceof antworld.relogo.AntAWorker)
			result.add((antworld.relogo.AntAWorker)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<antworld.relogo.AntAWorker>();
		}
	}

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
	 * Makes a number of new antBWorkers and then executes a set of commands on the
	 * created antBWorkers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created antBWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntBWorker")
	public AgentSet<antworld.relogo.AntBWorker> hatchAntBWorkers(int number, Closure closure) {
		AgentSet<antworld.relogo.AntBWorker> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"AntBWorker");
		for (Turtle t : createResult){
			if (t instanceof antworld.relogo.AntBWorker){
				result.add((antworld.relogo.AntBWorker)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new antBWorkers and then executes a set of commands on the
	 * created antBWorkers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created antBWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntBWorker")
	public AgentSet<antworld.relogo.AntBWorker> hatchAntBWorkers(int number) {
		return hatchAntBWorkers(number,null);
	}

	/**
	 * Returns an agentset of antBWorkers from the patch of the caller.
	 * 
	 * @return agentset of antBWorkers from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntBWorker")
	public AgentSet<antworld.relogo.AntBWorker> antBWorkersHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<antworld.relogo.AntBWorker> result = new AgentSet<antworld.relogo.AntBWorker>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"antBWorker")){
			if (t instanceof antworld.relogo.AntBWorker)
			result.add((antworld.relogo.AntBWorker)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of antBWorkers on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of antBWorkers at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntBWorker")
	public AgentSet<antworld.relogo.AntBWorker> antBWorkersAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<antworld.relogo.AntBWorker> result = new AgentSet<antworld.relogo.AntBWorker>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"antBWorker")){
			if (t instanceof antworld.relogo.AntBWorker)
			result.add((antworld.relogo.AntBWorker)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<antworld.relogo.AntBWorker>();
		}
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