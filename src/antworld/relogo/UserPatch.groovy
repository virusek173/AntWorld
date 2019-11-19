package antworld.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import org.codehaus.groovy.tools.shell.commands.SetCommand

import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.ast.Diffusible;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import antworld.ReLogoPatch;

class UserPatch extends ReLogoPatch {
	def pheromoneColors = [green() + 20, red() + 10]
	def pheromoneHalfColors = [green() + 30, red() + 20]
	def pheromoneTime = 0
	def maxPheromoneTimeG = 800
	def maxPheromoneTimeR = 800
	
	def MODE_TEAMA = 0
	def MODE_TEAMB = 1
	def MODE_NEUTRAL = 2
	def patchMode = MODE_NEUTRAL
	
	def step() {
		if (patchMode != MODE_NEUTRAL) {
			pheromoneTime -= 1
			if (pheromoneTime <= 0) {
				patchMode = MODE_NEUTRAL
				initializePatches()
				return
			}
			if (patchMode == MODE_TEAMA) {
				if (pheromoneTime < (maxPheromoneTimeG/2)) pcolor = pheromoneHalfColors[patchMode]
			} else {
				if (pheromoneTime < (maxPheromoneTimeR/2)) pcolor = pheromoneHalfColors[patchMode]
			}
			
			
		}
	}
	
	def initializePatches(){
		pcolor = violet()
	}
	
	def sprayPheromones(int team) {
		patchMode = team
		pcolor = pheromoneColors[team]
		if (team == MODE_TEAMA) pheromoneTime = maxPheromoneTimeG
		else pheromoneTime = maxPheromoneTimeR
	}
}