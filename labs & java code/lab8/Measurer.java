package labs.lab8;

public interface Measurer <T>{ //The interface has one generic type parameter, T
	/**
	 * Computes the measure of an object.
	 * 
	 * @param anObject the object to be measured
	 * @return the measure
	 */
	double measure(T anObject); // the passed in lambda expression is set to be the implementation of this functional interface

	public static <T> T max(T[] values, Measurer<T> meas){
		if (values.length == 0){return null;}
		T maxValue = values[0];
		for (T value : values){
			if (meas.measure(value) > meas.measure(maxValue)){ //comparing max value using the measure method
				maxValue = value;
			}
		}
		return maxValue;
	}
}
