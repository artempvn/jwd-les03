package by.artempvn.les03.entity;

public class Ball {

	private final double radiusCentimeters;
	private final CustomColor color;
	private final Material material;

	public Ball(double radiusCentimeters, CustomColor color,
			Material material) {
		this.radiusCentimeters = radiusCentimeters;
		this.color = color;
		this.material = material;
	}

	public double getRadiusCentimeters() {
		return radiusCentimeters;
	}

	public CustomColor getColor() {
		return color;
	}

	public Material getMaterial() {
		return material;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((material == null) ? 0 : material.hashCode());
		long temp;
		temp = Double.doubleToLongBits(radiusCentimeters);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ball other = (Ball) obj;
		if (color != other.color)
			return false;
		if (material != other.material)
			return false;
		if (Double.doubleToLongBits(radiusCentimeters) != Double
				.doubleToLongBits(other.radiusCentimeters))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ball [radiusCentimeters=");
		builder.append(radiusCentimeters);
		builder.append(", color=");
		builder.append(color);
		builder.append(", material=");
		builder.append(material);
		builder.append("]");
		return builder.toString();
	}
}
