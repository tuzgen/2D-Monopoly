package gui.misc;

import com.sun.javafx.perf.PerformanceTracker;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

public class FPSCounter {
	public FPSCounter() {}

	private PerformanceTracker tracker;

	public Text display(Scene scene) {
		tracker = PerformanceTracker.getSceneTracker(scene);
		Text label = new Text();
		AnimationTimer frameRateMeter = new AnimationTimer() {

			@Override
			public void handle(long now) {
				 label.setText(String.format(
				 		"%.1f FPS", getFPS())
				 );
				 label.setFill(new Color(0.094, 1, 0.047, 1));
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