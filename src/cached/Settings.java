package cached;

import java.io.Serializable;
import java.util.Set;

public class Settings implements Serializable {
	private boolean colorblind_mode, muted_mode;

	public Settings(boolean colorblind, boolean muted) {
		this.colorblind_mode = colorblind;
		this.muted_mode = muted;
	}

	public String toString() {
		return "Colorblind: " + colorblind_mode + " Muted: " + muted_mode;
	}

	public boolean getColorblindMode() { return colorblind_mode; }
	public void setColorblindMode(boolean colorblind) { colorblind_mode = colorblind; }
	public boolean getMutedMode() { return muted_mode; }
	public void setMutedMode(boolean muted) { muted_mode= muted; }
}
