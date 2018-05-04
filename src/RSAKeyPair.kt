import java.math.BigInteger
import java.util.*

class RSAKeyPair {

    inner class Key(first: Long, second: Long) {
        var a: Long = first
        var b: Long = second
    }

    lateinit var privateKey: Key
    lateinit var publicKey: Key

    private val random = Random()

    /**
     * Returns array of keys. The first is public, the second is private.
     */
    fun generateKeys() : Array<Key> {
        var p: Long = rand()
        var q: Long = rand()

        while (!isPrime(p) && !isPrime(q)) {
            p = rand()
            q = rand()
        }

        val N = p * q
        val fi = (p - 1) * (q - 1)
        val d = randomD(fi)
        val e = randomE(d, fi)

        privateKey = Key(d, N)
        publicKey = Key(e, N)

        return arrayOf(publicKey, privateKey)
    }

    private fun isPrime(n: Long): Boolean {
        var i = 2
        while (2 * i < n) {
            if (n % i == 0L)
                return false
            i++
        }
        return true
    }

    //TODO: Fix infinite loop
    private fun randomD(topBound: Long) : Long {
        var e = Math.abs(rand())

        while (e > topBound && gcd(e, topBound) != 1L) {
            e = Math.abs(rand())
        }

        return e
    }

    private fun randomE(d: Long, fi: Long) : Long {
        var e = rand()

        while ((e * d) % fi != 1L) {
            e = rand()
        }

        return e
    }

    private fun gcd(a: Long, b: Long): Long {
        var localA = a
        var localB = b
        var t: Long

        while (localB != 0L) {
            t = a
            localA = localB
            localB = t % localB
        }
        return localA
    }

    private fun rand() : Long = random.nextLong()
}