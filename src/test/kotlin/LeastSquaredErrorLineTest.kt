import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LeastSquaredErrorLineTest
{
	@Test
	fun testCreateRegressionLine()
	{
		val data = ArrayList<Point>().apply {
			add(Point(72.5, 1))
			add(Point(70, 2))
			add(Point(67.5, 3))
			add(Point(67.5, 4))
			add(Point(65, 4))
			add(Point(65, 5))
		}

		// Oracle: https://www.wolframalpha.com/input/?i=linear+fit+%7B72.5,+1%7D,%7B70,+2%7D,%7B67.5,+3%7D,%7B67.5,+4%7D,%7B65,+4%7D%7B67.5,+5%7D
		val line = regressionLineFrom(data)
		assertEquals(35.63, line.b, 0.01)
		assertEquals(-0.475, line.m, 0.01)
		println(line)
		println(line[67.5])
		println(line.x(3.0))
	}
}