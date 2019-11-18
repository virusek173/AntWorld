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
	def pheromoneColor = red() + 10
	
	def MODE_PROSPECTOR = 0
	def MODE_BACKNEST = 1
	def MODE_FULLATTACK = 2
	def antMode = MODE_PROSPECTOR
	
	def step(){
		def currentPX = patchHere().getPxcor()
		def currentPY = patchHere().getPycor()
		def nestCoordinates = [x: maxPxcor, y: maxPycor]
		def nestBorderCoordinates = [x: maxPxcor - 4, y: maxPycor - 4]
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
				if (antsA > 0) antMode = MODE_BACKNEST
				if (patchMode == patchHere().MODE_TEAMB) {
					antMode = MODE_FULLATTACK;
				}
				
				if (patchMode == patchHere().MODE_TEAMA) {
					antMode = MODE_BACKNEST;
				}
				
				break;
			case MODE_BACKNEST:
				if (currentPX > nestBorderCoordinates.x && currentPY > nestBorderCoordinates.y) {
					antMode = MODE_PROSPECTOR
				}
				facexy(nestCoordinates.x, nestCoordinates.y)
				patchHere().sprayPheromones(team)
				break;
			case MODE_FULLATTACK:
				def attackPatches = maxNOf(4, neighbors()){
					it.distancexy(nestCoordinates.x, nestCoordinates.y)
				}
				def enemyDirectionWinner = maxOneOf(attackPatches){
					if(it.patchMode == patchHere().MODE_TEAMB) 1 else 0
				}
				def randomWinner = maxOneOf(neighbors()){
					if(it.patchMode == patchHere().MODE_TEAMB) 1 else 0
				}
				def winner = enemyDirectionWinner
				
				if (enemyDirectionWinner.patchMode != patchHere().MODE_TEAMB) winner = randomWinner
//				if (winner == randomWinner && randomFloat(1) < 0.5) winner = enemyDirectionWinner
				
				face(winner)
//				facexy(enemyNestCoordinates.x, enemyNestCoordinates.y)
				
//				setPcolor(yellow())
				patchHere().sprayPheromones(team)
				break;
			default:
				println("should never happen");
				break;
		}
		
//		move forward
		fd(0.1)	
	}
}