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
		setDefaultShape(AntWorker,"ant")
		createAntWorkers(numAnts){
			// Random but in nest range
			def randomX = increasedRandom(random(minPxcor))
			def randomY = increasedRandom(random(minPycor))
			
			setxy(randomX, randomY)
		}
		ask(patches()) { 
			initializePatches()
		}
	}
	
	@Go
	def go(){
		
		ask (antWorkers()){
			step()
		}
	}
	
	def increasedRandom(def x) {
		if (x>-8) return (x-8)
			
		return x
	}
}