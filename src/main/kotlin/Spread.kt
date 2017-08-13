fun median(c: Collection<Number>): Double
{
	if(c.isEmpty())
		return Double.NaN

	return c.asSequence()
			.median()

}

fun Sequence<Number>.median(): Double
{
	val size = this.asSequence().count()

	val evenCount = size % 2 == 0
	val elementsToDrop: Int = when(evenCount)
	{
		true -> ((size/2.0) - 1).toInt()
		false -> size/2
	}

	return this.map { it.toDouble() }
			.sorted()
			.drop(elementsToDrop)
			.take(if(evenCount) 2 else 1)
			.average()
}