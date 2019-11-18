package antworld.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import antworld.ReLogoTurtle
import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

class AntBWorker extends ReLogoTurtle {
	def team = 1
	def antMode = [backNest: false]
	def pheromoneColor = red() + 10
	
	def step(){
		def currentPX = patchHere().getPxcor()
		def currentPY = patchHere().getPycor()
		def nestCoordinates = [x: maxPxcor, y: maxPycor]
		
		def antsA = count(antAWorkersHere())
		def antsB = count(antBWorkersHere())
		
		
		if (antsA > 0 && !antMode.backNest) {
			antMode.backNest = true
		}
		
		if (antMode.backNest) {
			facexy(nestCoordinates.x, nestCoordinates.y)
			setPcolor(pheromoneColor)
		} else {
			def rotateAngle = random(360)
			left(rotateAngle)
		}
		
		
		if (antMode.backNest && (currentPX > 12 && currentPY > 12)) {
			antMode.backNest = false
		}

//		move forward
		fd(0.1)
	}
}
