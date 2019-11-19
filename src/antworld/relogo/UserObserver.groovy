package antworld.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import javax.media.j3d.Background

import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import repast.simphony.space.continuous.BouncyBorders
import repast.simphony.space.continuous.StrictBorders
import antworld.ReLogoObserver;

class UserObserver extends ReLogoObserver{
	@Setup
	def setup(){
		clearAll()
		setDefaultShape(AntWorker,"ant_color")
		setDefaultShape(AntWorker,"ant_color")
		createAntWorkers(numAntsG){
			// Random but in nest range
			def randomX = increasedRandom(random(minPxcor), 0)
			def randomY = increasedRandom(random(minPycor), 0)
			
			setxy(randomX, randomY)
			setColor(green())
			setTeam(0)
		}
		createAntWorkers(numAntsR){
			// Random but in nest range
			def randomX = increasedRandom(random(maxPxcor), 1)
			def randomY = increasedRandom(random(maxPycor), 1)
			
			setxy(randomX, randomY)
			setColor(red())
			setTeam(1)
		}
		ask(patches()) { 
			initializePatches()
			setMaxPheromoneTimeG(pheromoneTimeG)
			setMaxPheromoneTimeR(pheromoneTimeR)
			initializeNests()
			
			// create nests
		}
	}
	
	@Go
	def go(){
		ask (antWorkers()){
			step()
		}
		ask (patches()){
			step()
		}
	}
	
	def increasedRandom(def x, int team) {
//		if (team) {
//			if (x<8) return (x+8)
//			
//		} else {
//			if (x>-8) return (x-8)
//		}
			
		return x
	}
}