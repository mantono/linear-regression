import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

/**
 * @author Anton &Ouml;sterberg
 */

class StandardDeviationTest
{
	@Test
	fun testStandardDeviation()
	{

	}

	@Test
	fun testMean()
	{

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
}