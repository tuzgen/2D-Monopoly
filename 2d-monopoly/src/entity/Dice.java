package entity;

/*
	Roll the dice instance then retrieve the values.
 */
public class Dice {
	private int die1, die2;

	public Dice() {}

	public void rollTheDice() {
		this.die1 = (int) (Math.random() * 6 + 1);
		this.die2 = (int) (Math.random() * 6 + 1);
		System.out.println("Die 1: " + this.die1 + " Die 2: " + this.die2);
	}

	public int[] getPair() {
		return new int[]{ this.die1, this.die2};
	}

	public int getSum() { return this.die1 + this.die2; }
}