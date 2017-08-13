data class RegressionLine(val m: Double, val b: Double)
{
	fun y(x: Double): Double = m*x+b
	operator fun get(x: Double): Double = y(x)
	//fun xFrom(y: Double): Double = y/m-b
}

data class Point(val x: Double, val y: Double)
{
	constructor(independent: Number, dependent: Number): this(independent.toDouble(), dependent.toDouble())
}

fun residual(line: RegressionLine, point: Point): Double
{
	val predictedY = line[point.x]
	val actualY = point.y
	return actualY - predictedY
}

fun sumOfSquaredErrors(line: RegressionLine, data: Collection<Point>): Double
{
	return data.asSequence()
			.map { residual(line, it) }
			.map { Math.pow(it, 2.0) }
			.sum()
}

fun totalVariationInY(data: Collection<Point>): Double
{
	val avg = data.asSequence()
			.map { it.y }
			.average()

	return data
			.asSequence()
			.map { it.y - avg }
			.map { Math.pow(it, 2.0) }
			.sum()
}

fun regressionLineFrom(c: Collection<Point>): RegressionLine
{
	val xMean = c.asSequence()
			.map { it.x }
			.average()

	val xStdDev = c.asSequence()
			.map { it.x }
			.standardDeviation()

	val yMean = c.asSequence()
			.map { it.y }
			.average()

	val yStdDev = c.asSequence()
			.map { it.y }
			.standardDeviation()


	val r = residual()
	val m = r * (yStdDev / xStdDev)
}