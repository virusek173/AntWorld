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
	def hp = 100
	def MODE_PROSPECTOR = 0
	def MODE_BACKNEST = 1
	def MODE_FULLATTACK = 2
	def antMode = MODE_PROSPECTOR
	def neutralWalkCounter = 0
	def moveInProspect = 0
	
	def step(){
		def currentPX = patchHere().getPxcor()
		def currentPY = patchHere().getPycor()
		def patchMode = patchHere().patchMode
		
		def nestCoordinates = [x: minPxcor, y: minPycor]
		def nestBorderCoordinates = [x: minPxcor + 4, y: minPycor + 4]
		def allyPathMode = patchHere().MODE_TEAMA
		def enemyPathMode = patchHere().MODE_TEAMB
		def enemyTeam = 1
		setSize(countSize(hp))
		
		if (team == 1) {
			nestCoordinates = [x: maxPxcor, y: maxPycor]
			nestBorderCoordinates = [x: maxPxcor - 4, y: maxPycor - 4]
			enemyTeam = 0
			allyPathMode = patchHere().MODE_TEAMB
			enemyPathMode = patchHere().MODE_TEAMA
		}
		
		switch(antMode) {
			case MODE_PROSPECTOR:
				moveInProspect -= 1
				// Random rotate
				def rotateAngle = random(360)
				left(rotateAngle)
				
				def enemyAntsHere = filter({it.team == enemyTeam}, antWorkersHere())				
				if (count(enemyAntsHere) > 0) {
					def winnerToAttack = minOneOf(enemyAntsHere){
						distance(it)
					}
					try {
						winnerToAttack.hp -= 10
					} catch(Exception e1) {}
				}

				// Check if any enemy ant on the same patch
				if (count(enemyAntsHere) > 0) {
					antMode = MODE_BACKNEST
					break;
				}
				if (patchMode == allyPathMode && moveInProspect <= 0) {
					antMode = MODE_FULLATTACK;
					break;
				}
				
				if (patchMode == enemyPathMode) {
					antMode = MODE_BACKNEST;
				}
				
				break;
			case MODE_BACKNEST:
				if (team == 1) {
					if (currentPX > nestBorderCoordinates.x && currentPY > nestBorderCoordinates.y) {
						antMode = MODE_PROSPECTOR
					}
				} else {
					if (currentPX < nestBorderCoordinates.x && currentPY < nestBorderCoordinates.y) {
						antMode = MODE_PROSPECTOR
					}
				}
				
				facexy(nestCoordinates.x, nestCoordinates.y)
				patchHere().sprayPheromones(team)
				break;
			case MODE_FULLATTACK:
				def enemyAntsHere = filter({it.team == enemyTeam}, antWorkersHere())
				def enemyAntsNeighbors = filter({it.team == enemyTeam}, antWorkersOn(neighbors()))
				def enemyAntsNeighborsAndHere = enemyAntsHere + enemyAntsNeighbors

				
				// If enemy ants then attack
				if (count(enemyAntsNeighborsAndHere) > 0) {
					def winnerToAttack = minOneOf(enemyAntsNeighborsAndHere){
						distance(it)
					}
					try {
						winnerToAttack.hp -= 10
					} catch(Exception e1) {}
				//	else move offensive			
				} else {
					def winnerPatch = faceToOffensive(nestCoordinates, enemyTeam)
					if (winnerPatch.patchMode == patchHere().MODE_NEUTRAL) {
						neutralWalkCounter += 1
					} else
					
					if (neutralWalkCounter > 100)  {
						antMode = MODE_PROSPECTOR
						print("start MODE_PROSPECTOR")
						neutralWalkCounter = 0
						moveInProspect = 1000
					}
					
					face(winnerPatch)
				}
				
//				if (winner == randomWinner && randomFloat(1) < 0.5) winner = enemyDirectionWinner
				
				
				patchHere().sprayPheromones(team)
				break;
			default:
				println("should never happen");
				break;
		}
		
//		move forward
		fd(0.1)	
		
		// Die 
		if (hp <= 0) die()
	}
	
	def countSize(int hp) { // [1-4] [1-100]
		return 0.5 + (0.01 * hp)
	}
	
	def faceToOffensive(def nestCoordinates, enemyTeam) {
		def attackPatches = maxNOf(4, neighbors()){
			it.distancexy(nestCoordinates.x, nestCoordinates.y)
		}
		def enemyDirectionWinner = maxOneOf(attackPatches){
			if(it.patchMode == enemyTeam) 1 else 0
		}
		
		def enemyDirectionOnAllyPatch = maxOneOf(attackPatches){
			if(it.patchMode == team) 1 else 0
		}
		def randomDirectionOnAllyPatch = maxOneOf(neighbors()){
			if(it.patchMode == team) 1 else 0
		}
		def randomWinner = maxOneOf(neighbors()){
			1
		}
		
		def winner = enemyDirectionOnAllyPatch
		def ofensiveRatio = 0.35
		def randomNum = randomFloat(1)
	
		if (enemyDirectionWinner.patchMode == enemyTeam) {
			winner = randomDirectionOnAllyPatch
			if (ofensiveRatio > randomNum) winner = enemyDirectionWinner
		} else {
			if (ofensiveRatio > randomNum) winner = randomWinner
		}
		
		return winner
	}
}
