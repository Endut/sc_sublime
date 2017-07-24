Sublime {
	classvar <currentPath;
	// classvar docRoutine;
	classvar savedEnv;

	*initClass {
		Document.implementationClass = SublimeDocument;
		StartUp.add( { Document.implementationClass.startup; } );
	}

	*openHelpUrl { arg url;
		^HelpBrowser.instance.goTo(url);
	}

	*currentPath_ { arg path;
		Import.all.at(path.asSymbol) !? { arg module;
			"this document defines a module".postln;
			savedEnv = currentEnvironment;
			currentEnvironment = module;
			} ?? {
				currentEnvironment = savedEnv ?? topEnvironment;
				};
		currentPath = path;
	}
}




ScIDE : Sublime {}
