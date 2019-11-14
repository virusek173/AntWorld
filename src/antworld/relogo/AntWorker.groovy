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
	def team = 0
	def foundSomething = false
	def randomStepCounter = 0
	def antMode = [backNest: false]
	
	def step(){
		def currentPX = patchHere().getPxcor()
		def currentPY = patchHere().getPycor()
		def nestCoordinates = [x: minPxcor, y: minPycor]
		
		if (randomStepCounter >= 100) {
			// Back to the nest
			antMode.backNest = true
		}
		
		if (antMode.backNest) {
			// Nest direction rotate
			facexy(nestCoordinates.x, nestCoordinates.y)
		} else {
			// Random rotate
			def rotateAngle = random(360)
			left(rotateAngle)
		}
		
		// Nest reached so reset ant modes
		// TO do dopracowania, bo się trzymają blisko gniazda. np zrobić zwiększanie randomStepCounter tylko jak przekroczą gniazdo i  może ustawić an więcej niż 100
		if (antMode.backNest == true && (currentPX < -12 || currentPY < -12)) {
			antMode.backNest = false
			randomStepCounter = 0
		}
		
		print(randomStepCounter)
		print(currentPX)
		print(currentPY)
		randomStepCounter = randomStepCounter + 1
		// move forward
		fd(0.1)	
		
	}
}
