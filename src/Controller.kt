
fun main(args: Array<String>) {
    val rsaKeyPair = RSAKeyPair()

    rsaKeyPair.generateKeys()

    println("Private pair: " + "(" + rsaKeyPair.privateKey.a + ", " + rsaKeyPair.privateKey.b + ")")
    println("Public pair: " + "(" + rsaKeyPair.publicKey.a + ", " + rsaKeyPair.publicKey.b + ")")
}