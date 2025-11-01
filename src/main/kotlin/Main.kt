import java.security.KeyPairGenerator
import javax.crypto.Cipher
import java.util.Base64

fun main() {
    // 1️⃣ Gerar o par de chaves
    // Cria um gerador de pares de chaves para o algoritmo RSA.
    val keyGen = KeyPairGenerator.getInstance("RSA")
    // Define o tamanho da chave em bits (2048 é um tamanho seguro/prático atualmente).
    keyGen.initialize(2048)
    // Gera o par de chaves (contém chave pública e chave privada).
    val parDeChaves = keyGen.generateKeyPair()
    // Extrai a chave pública do par gerado — usada para criptografar.
    val chavePublica = parDeChaves.public
    // Extrai a chave privada do par gerado — usada para descriptografar.
    val chavePrivada = parDeChaves.private

    // 2️⃣ Mensagem original
    // Define a mensagem em texto simples que será criptografada.
    val mensagem = "Teoria dos Números e Criptografia"

    // 3️⃣ Criptografar
    // Cria uma instância de cifra para RSA.
    val cifra = Cipher.getInstance("RSA")
    // Inicializa a cifra no modo de ENCRIPTAR usando a chave pública.
    cifra.init(Cipher.ENCRYPT_MODE, chavePublica)
    // Converte a mensagem para bytes e aplica a operação de criptografia.
    val mensagemCriptografada = cifra.doFinal(mensagem.toByteArray())
    // Como bytes criptografados podem conter valores não imprimíveis, codifica em Base64 para visualizar/imprimir.
    // Base64 A–Z(26), a–z(26), 0–9, + e /
    val criptografadaBase64 = Base64.getEncoder().encodeToString(mensagemCriptografada)
    // Imprime a versão codificada em Base64 da mensagem criptografada.
    println("🔒 Mensagem criptografada:\n $criptografadaBase64")

    // 4️⃣ Descriptografar
    // Reutiliza a mesma instância de cifra, agora inicializando no modo DECRIPTAR com a chave privada.
    cifra.init(Cipher.DECRYPT_MODE, chavePrivada)
    // Decodifica o Base64 de volta para bytes criptografados e aplica a operação de descriptografia.
    val descriptografada = cifra.doFinal(Base64.getDecoder().decode(criptografadaBase64))
    // Converte os bytes descriptografados de volta para String (texto legível) e imprime.
    println("🔓 Mensagem original:\n ${String(descriptografada)}")
}
