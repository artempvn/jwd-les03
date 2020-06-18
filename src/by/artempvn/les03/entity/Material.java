package by.artempvn.les03.entity;

public enum Material {
	STEEL(7.8), WOOD(0.6), RUBBER(0.9);

	private double density;

	private Material(double density) {
		this.density = density;
	}

	public double getDensity() {
		return density;
	}
}
