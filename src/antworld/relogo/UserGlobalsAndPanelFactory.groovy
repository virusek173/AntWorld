package antworld.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
		
		/**
		 * Place custom panels and globals below, for example:
		 * 
	        addGlobal("globalVariable1")	// Globally accessible variable ( variable name)
	        // Slider with label ( variable name, slider label, minimum value, increment, maximum value, initial value )
	        addSliderWL("sliderVariable", "Slider Variable", 0, 1, 10, 5)
	        // Slider without label ( variable name, minimum value, increment, maximum value, initial value )
	        addSlider("sliderVariable2", 0.2, 0.1, 0.8, 0.5)
	        // Chooser with label  ( variable name, chooser label, list of choices , zero-based index of initial value )
	        addChooserWL("chooserVariable", "Chooser Variable", ["yes","no","maybe"], 2)
	        // Chooser without label  ( variable name, list of choices , zero-based index of initial value )
	        addChooser("chooserVariable2", [1, 66, "seven"], 0)
	        // State change button (method name in observer)
	        addStateChangeButton("change")
	        // State change button with label (method name in observer, label)
	        addStateChangeButtonWL("changeSomething","Change Something")
	        
		 */
		
		
		addSliderWL("numWorkerAntsG", "Worker Ants in team green", 1, 1, 200, 100)
		addSliderWL("numWorkerAntsR", "Worker Ants in team red", 1, 1, 200, 100)
		addSliderWL("numWarriorAntsG", "Warrior Ants in team green", 1, 1, 50, 10)
		addSliderWL("numWarriorAntsR", "Warrior Ants in team red", 1, 1, 50, 10)
		addChooserWL("chooseWarriorAntsSet", "Setup layout of warrior ants", ["Default", "Green warriors near nest", "Red warriors near nest", "All warriors near nest"])
		addSliderWL("pheromoneTimeG", "Time of pheromone exist for team G", 1, 1, 2400, 1200)
		addSliderWL("pheromoneTimeR", "Time of pheromone exist for team R", 1, 1, 2400, 1200)
		addSliderWL("numLarvas", "Number of Larvas", 1, 1, 10, 5)
	}
}