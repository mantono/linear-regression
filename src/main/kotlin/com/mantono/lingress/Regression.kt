package com.mantono.lingress

data class RegressionLine(val m: Double, val b: Double)
{
	fun y(x: Double): Double = m*x+b
	fun x(y: Double): Double = (y-b)/m
	operator fun get(x: Double): Double = y(x)
	override fun toString(): String = "y = $m * x + $b"
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
			.map {squaredError(line, it)}
			.sum()
}

fun squaredError(line: RegressionLine, p: Point): Double = Math.pow(residual(line, p), 2.0)

fun rootMeanSquareError(line: RegressionLine, data: Collection<Point>): Double
{
	if(data.isEmpty())
		return Double.NaN
	if(data.size == 1)
		return 0.0

	val squaredErr = sumOfSquaredErrors(line, data) / (data.size - 1)
	return Math.sqrt(squaredErr)
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

inline fun squared(n: Double): Double = Math.pow(n, 2.0)

fun regressionLineFrom(c: Collection<Point>): RegressionLine
{
	val xMean = c.asSequence()
			.map { it.x }
			.average()

	val yMean = c.asSequence()
			.map { it.y }
			.average()

	val xyMean = c.asSequence()
			.map { it.x * it.y }
			.average()

	val xSquaredMean = c.asSequence()
			.map {squared(it.x)}
			.average()

	val m: Double = (xMean * yMean - (xyMean)) / (Math.pow(xMean, 2.0) - xSquaredMean)
	val b: Double = yMean - (m * xMean)

	return RegressionLine(m, b)
}