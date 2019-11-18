package antworld.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import org.apache.batik.parser.PathHandler

import antworld.ReLogoTurtle
import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup

class AntAWorker extends ReLogoTurtle {
	def team = 0
	def pheromoneColor = green() + 20
	
	def MODE_PROSPECTOR = 0
	def MODE_BACKNEST = 1
	def MODE_FULLATTACK = 2
	def antMode = MODE_PROSPECTOR
	
	def step(){
		def currentPX = patchHere().getPxcor()
		def currentPY = patchHere().getPycor()
		def nestCoordinates = [x: minPxcor, y: minPycor]
		def enemyNestCoordinates = [x: maxPxcor, y: maxPycor]
		def nestBorderCoordinates = [x: minPxcor + 4, y: minPycor + 4]
		def patchMode = patchHere().patchMode
		
		// mrówki na patchu
		// mrówki na patchu obok
		// przelatujemy po wszystkich i distance
		// decyzja co robimy
		
		switch(antMode) {
			case MODE_PROSPECTOR:
				// Random rotate
				def rotateAngle = random(360)
				left(rotateAngle)
				
				def antsA = count(antAWorkersHere())
				def antsB = count(antBWorkersHere())
				
				// Check if any enemy ant on the same patch
				if (antsB > 0) antMode = MODE_BACKNEST
				if (patchMode == patchHere().MODE_TEAMA) {
					print("ATTTAKKK")
					antMode = MODE_FULLATTACK;
				}
				
				break;
			case MODE_BACKNEST:
				if (currentPX < nestBorderCoordinates.x && currentPY < nestBorderCoordinates.y) {
					antMode = MODE_PROSPECTOR
				}
				facexy(nestCoordinates.x, nestCoordinates.y)
				patchHere().sprayPheromones(team)
				break;
			case MODE_FULLATTACK:
//				def winner = oneOf(neighbors()){
//					patch().patchMode == patchHere().MODE_TEAMA
//				}
//				face(winner)
				
				facexy(enemyNestCoordinates.x, enemyNestCoordinates.y)
				
				setPcolor(yellow())
				break;
			default:
				println("should never happen");
				break;
		}
		
//		move forward
		fd(0.1)	
	}
}
