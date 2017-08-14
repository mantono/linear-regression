package com.mantono.lingress

import com.mantono.lingress.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class StandardDeviationTest
{
	@Test
	fun testStandardDeviation()
	{

	}

	@Test
	fun testRange()
	{
		val data: Collection<Number> = listOf(-5, 0, 5, 10, 15)
		val range: Double = range(data)
		assertEquals(20.0, range)
	}

	@Test
	fun testMean()
	{
		val data: List<Int> = listOf(-1, 0, 1, 2, 3)
		val mean: Double = mean(data)
		assertEquals(mean, 1.0)
	}

	@Test
	fun testMedianOfOddAmountOfNumbersInt()
	{
		val data: List<Int> = listOf(1, 2, 3, 4, 5)
		val median: Double = median(data)
		assertEquals(median, 3.0)
	}

	@Test
	fun testMedianOfOddEvenOfNumbersInt()
	{
		val data: List<Int> = listOf(1, 2, 3, 4)
		val median: Double = median(data)
		assertEquals(median, 2.5)
	}

	@Test
	fun testMedianOfOddAmountOfNumbersDouble()
	{
		val data: List<Double> = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
		val median: Double = median(data)
		assertEquals(median, 3.0)
	}

	@Test
	fun testMedianOfOddEvenOfNumbersDouble()
	{
		val data: List<Double> = listOf(1.0, 2.0, 3.0, 4.0)
		val median: Double = median(data)
		assertEquals(median, 2.5)
	}

	@Test
	fun testMedianOfMixedNumbers()
	{
		val data: List<Number> = listOf(1.0, 2.0, 3, 4L, 5f)
		val median: Double = median(data)
		assertEquals(median, 3.0)
	}

	@Test
	fun testMedianOfUnsortedCollection()
	{
		val data: Collection<Number> = listOf(5, 1, 3, 4, 2)
		val median: Double = median(data)
		assertEquals(median, 3.0)
	}

	@Test
	fun testVariance1()
	{
		val data: Collection<Number> = listOf(-10, 0, 10, 20, 30)
		val variance = variance(data)
		assertEquals(200.0, variance)
	}

	@Test
	fun testVariance2()
	{
		val data: Collection<Number> = listOf(8, 9, 10, 11, 12)
		val variance = variance(data)
		assertEquals(2.0, variance)
	}

	@Test
	fun testStandardDeviation1()
	{
		val data: Collection<Number> = listOf(8, 9, 10, 11, 12)
		val sd = standardDeviation(data)
		assertEquals(Math.sqrt(2.0), sd, 0.0000001)
	}

	@Test
	fun testStandardDeviationSequence()
	{
		val sd = sequenceOf(8, 9, 10, 11, 12).standardDeviation()
		assertEquals(Math.sqrt(2.0), sd, 0.0000001)
	}
}