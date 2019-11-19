package antworld;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.ast.Diffusible;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoPatch extends BasePatch{

	/**
	 * Sprouts (makes) a number of new antWorkers and then executes a set of commands on the
	 * created antWorkers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created antWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> sproutAntWorkers(int number, Closure closure) {
		AgentSet<antworld.relogo.AntWorker> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"AntWorker");
		for (Turtle t : createResult){
			if (t instanceof antworld.relogo.AntWorker){
				result.add((antworld.relogo.AntWorker)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new antWorkers and then executes a set of commands on the
	 * created antWorkers.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created antWorkers
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.AntWorker")
	public AgentSet<antworld.relogo.AntWorker> sproutAntWorkers(int number) {
		return sproutAntWorkers(number,null);
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
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
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
	 * Sprouts (makes) a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> sproutUserTurtles(int number, Closure closure) {
		AgentSet<antworld.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof antworld.relogo.UserTurtle){
				result.add((antworld.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("antworld.relogo.UserTurtle")
	public AgentSet<antworld.relogo.UserTurtle> sproutUserTurtles(int number) {
		return sproutUserTurtles(number,null);
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
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
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
	 * Returns the value of the global variable numAntsG.
	 *
	 * @return the value of the global variable numAntsG
	 */
	@ReLogoBuilderGeneratedFor("global: numAntsG")
	public Object getNumAntsG(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numAntsG");
	}

	/**
	 * Sets the value of the global variable numAntsG.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numAntsG")
	public void setNumAntsG(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numAntsG",value);
	}

	/**
	 * Returns the value of the global variable numAntsR.
	 *
	 * @return the value of the global variable numAntsR
	 */
	@ReLogoBuilderGeneratedFor("global: numAntsR")
	public Object getNumAntsR(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numAntsR");
	}

	/**
	 * Sets the value of the global variable numAntsR.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numAntsR")
	public void setNumAntsR(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numAntsR",value);
	}

	/**
	 * Returns the value of the global variable pheromoneTimeG.
	 *
	 * @return the value of the global variable pheromoneTimeG
	 */
	@ReLogoBuilderGeneratedFor("global: pheromoneTimeG")
	public Object getPheromoneTimeG(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("pheromoneTimeG");
	}

	/**
	 * Sets the value of the global variable pheromoneTimeG.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: pheromoneTimeG")
	public void setPheromoneTimeG(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("pheromoneTimeG",value);
	}

	/**
	 * Returns the value of the global variable pheromoneTimeR.
	 *
	 * @return the value of the global variable pheromoneTimeR
	 */
	@ReLogoBuilderGeneratedFor("global: pheromoneTimeR")
	public Object getPheromoneTimeR(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("pheromoneTimeR");
	}

	/**
	 * Sets the value of the global variable pheromoneTimeR.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: pheromoneTimeR")
	public void setPheromoneTimeR(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("pheromoneTimeR",value);
	}

	/**
	 * Returns the value of the global variable numLarvas.
	 *
	 * @return the value of the global variable numLarvas
	 */
	@ReLogoBuilderGeneratedFor("global: numLarvas")
	public Object getNumLarvas(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numLarvas");
	}

	/**
	 * Sets the value of the global variable numLarvas.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numLarvas")
	public void setNumLarvas(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numLarvas",value);
	}


}