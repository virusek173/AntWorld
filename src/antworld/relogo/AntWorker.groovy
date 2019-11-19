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

class AntWorker extends ReLogoTurtle {
	def team
	
	def MODE_PROSPECTOR = 0
	def MODE_BACKNEST = 1
	def MODE_FULLATTACK = 2
	def antMode = MODE_PROSPECTOR
	
	def step(){
		def currentPX = patchHere().getPxcor()
		def currentPY = patchHere().getPycor()
		def patchMode = patchHere().patchMode
		
		def nestCoordinates = [x: minPxcor, y: minPycor]
		def nestBorderCoordinates =  (( getPxcor() + getPycor() + 32 ) <= 8 )
		def allyPathMode = patchHere().MODE_TEAMA
		def enemyPathMode = patchHere().MODE_TEAMB
		def enemyTeam = 1
		
		if (team == 1) {
			nestCoordinates = [x: maxPxcor, y: maxPycor]
			nestBorderCoordinates = ( (getPxcor() + getPycor()) - 32 >= -8 )
			enemyTeam = 0
			allyPathMode = patchHere().MODE_TEAMB
			enemyPathMode = patchHere().MODE_TEAMA
		}
//		print("enemyTeam: " + enemyTeam)
//		print("allyTeam: " + team)
		
		// mrówki na patchu
		// mrówki na patchu obok
		// przelatujemy po wszystkich i distance
		// decyzja co robimy
		
		switch(antMode) {
			case MODE_PROSPECTOR:
				// Random rotate
				def rotateAngle = random(360)
				left(rotateAngle)
				
//				def ifEnemyAntsHere = max(antWorkersHere()) {
//					it.team == enemyTeam
//				}
				
				def enemyAnts = filter({it.team == enemyTeam}, antWorkersHere())
				
//				def antsA = count(antAWorkersHere())
//				def antsB = count(antBWorkersHere())
				
				// Check if any enemy ant on the same patch
				if (count(enemyAnts) > 0) {
					antMode = MODE_BACKNEST
					break;
				}
				if (patchMode == allyPathMode) {
					antMode = MODE_FULLATTACK;
					break;
				}
				
				if (patchMode == enemyPathMode) {
					antMode = MODE_BACKNEST;
				}
				
				break;
			case MODE_BACKNEST: 
					if (nestBorderCoordinates) {
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
					if(it.patchMode == team) 1 else 0
				}
				def randomWinner = maxOneOf(neighbors()){
					if(it.patchMode == team) 1 else 0
				}
				def winner = enemyDirectionWinner
				
				if (enemyDirectionWinner.patchMode != team) winner = randomWinner
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
