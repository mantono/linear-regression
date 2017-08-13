fun median(c: Collection<Number>): Double = c.asSequence().median()
fun mean(c: Collection<Number>): Double = c.map { it.toDouble() }.average()
fun range(c: Collection<Number>): Double = c.asSequence().range()
fun variance(c: Collection<Number>): Double = c.asSequence().variance()
fun standardDeviation(c: Collection<Number>): Double = Math.sqrt(variance(c))

fun Sequence<Number>.median(): Double
{
	val size = this.asSequence().count()

	val evenSize = size % 2 == 0
	val elementsToDrop: Int = when(evenSize)
	{
		true -> ((size/2.0) - 1).toInt()
		false -> size/2
	}

	return this.map { it.toDouble() }
			.sorted()
			.drop(elementsToDrop)
			.take(if(evenSize) 2 else 1)
			.average()
}


fun Sequence<Number>.range(): Double
{
	val min: Double = map { it.toDouble() }.min() ?: 0.0
	val max: Double = map { it.toDouble() }.max() ?: 0.0
	return max - min
}

fun Sequence<Number>.variance(): Double
{
	val doubleSequence: Sequence<Double> = map { it.toDouble() }
	val mean = doubleSequence.average()

	val sum = doubleSequence
			.map { it - mean }
			.map { Math.pow(it, 2.0) }
			.sum()

	return sum/count()
}

fun Sequence<Number>.standardDeviation(): Double = Math.sqrt(variance())