package utils

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StringMathUtilsTest {

  @Test
  fun getPowerOfTest() {
    assertEquals("1024", StringMathUtils.getPowerOf("2", 10))
    assertEquals("29986576", StringMathUtils.getPowerOf("74", 4))
    assertEquals("1", StringMathUtils.getPowerOf("1", 1))
    assertEquals("1", StringMathUtils.getPowerOf("34564574", 0))
    assertEquals("282475249", StringMathUtils.getPowerOf("7", 10))
  }

  @Test
  fun `factorial test`() {
    assertEquals(
        expected = "3628800",
        actual = StringMathUtils.factorial("10")
    )

    assertEquals(
        expected = "120",
        actual = StringMathUtils.factorial("5")
    )
  }
}