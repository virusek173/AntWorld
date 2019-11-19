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
			
			//def larvas_patches = filter({it.type=="larwa"}, patches())
			// ask(larvas_patches) -> odpytanie tylko paczy na ktorych sa larwy
		
		ask(patches()) { 
			initializePatches()
			setMaxPheromoneTimeG(pheromoneTimeG)
			setMaxPheromoneTimeR(pheromoneTimeR)
			initializeNests()
				// create nests
		}
		
		// initialize larvas
		def countLarvasA = numLarvas
		def countLarvasB = numLarvas
		
		while(countLarvasA > 0 || countLarvasB > 0) {
		
		def x1 = -10 - random(6)
		def y1 = -10 - random(6)
		def x2 = 10 + random(6)
		def y2 = 10 + random(6)
			
		// overcome overlapping
		while (patch(x1,y1).getPcolor() == yellow() ){
			x1 = -10 - random(6)
			y1 = -10 - random(6)
		}
		while (patch(x2,y2).getPcolor() == yellow() ){
			x2 = 10 + random(6)
			y2 = 10 + random(6)
		}
		// check if patch is yellow -> if yes again
		
		if( (x1 + y1 + 32) < 8 && countLarvasA > 0) {
				patch(x1,y1).setPcolor(yellow())
				print("x1:"+x1+" y1:"+y1)
				countLarvasA -= 1
			}
			
		if( (x2 + y2 - 32) > -8 && countLarvasB > 0){
				patch(x2,y2).setPcolor(yellow())
				print("x2:"+x2+" y2:"+y2)
				countLarvasB -= 1
			}
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