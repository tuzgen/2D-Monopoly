package com.twod.gui.misc;

import com.sun.javafx.perf.PerformanceTracker;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

public class FPSCounter {
	public FPSCounter() {}

	private PerformanceTracker tracker;

	public Label display(Scene scene) {
		tracker = PerformanceTracker.getSceneTracker(scene);
		Label label = new Label();
		AnimationTimer frameRateMeter = new AnimationTimer() {

			@Override
			public void handle(long now) {
				 label.setText(String.format(
				 		"%.1f FPS", getFPS())
				 );
				 System.out.println("Size of tracker " + ObjectSizeCalculator.getObjectSize(tracker));
			}
		};
		frameRateMeter.start();
		return label;
	}

	private float getFPS () {
		float fps = tracker.getAverageFPS();
		tracker.resetAverageFPS();
		return fps;
	}
}