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
	
	def MODE_TEAMA = 0
	def MODE_TEAMB = 1
	def MODE_NEUTRAL = 2
	def patchMode = MODE_NEUTRAL
	
	def initializePatches(){
		pcolor = violet()
	}
	
	def initializeNests() {
		def coords_sum = abs(getPxcor()) + abs(getPycor()) - 32
		// if x,y have the same sign and it's not > 5 sum of distance from nest 
		if( (getPxcor()*getPycor() > 0 )  && ( (abs(getPxcor()) + abs(getPycor()) - 32) > -8) ) {
			pcolor = black()
		}
	}
	
	def sprayPheromones(int team) {
		patchMode = team
		pcolor = pheromoneColors[team]
	}
}