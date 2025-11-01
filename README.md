# Trabalho da matéria de Lógica e Matemática discreta sobre: Teoria dos números e Criptografia


#### -> Código em Kotlin exemplifica como é realizado a criptografia de um texto em RSA.

# Teoria dos números e Criptografia

A teoria dos números, também conhecida como aritmética superior, é uma área fundamental da matemática que estuda as propriedades e relações dos números inteiros.

*Criptografia e segurança da informação*: A teoria dos números é crucial para a criptografia, que é a base da segurança digital moderna. Métodos criptográficos, como RSA e ECC (Elliptic Curve Cryptography), dependem de problemas difíceis na teoria dos números, como a fatoração de grandes números primos e o problema do logaritmo discreto.

## Exemplo Prático de RSA

RSA é um dos algoritmos mais clássicos de chave pública.

### Passos resumidos:

1. Escolhe 2 primos grandes ppp e qqq.
2. Calcula n=p⋅qn = p \cdot qn=p⋅q e φ(n)=(p−1)(q−1)\varphi(n) = (p-1)(q-1)φ(n)=(p−1)(q−1).
3. Define eee (chave pública).
4. Calcula ddd (chave privada) como o inverso de eee módulo φ(n)\varphi(n)φ(n).

### Exemplo com números pequenos:

- p=7,q=13p=7, q=13p=7,q=13.
- n=91n=91n=91, φ(91)=72\varphi(91) = 72φ(91)=72.
- Escolhe e=5e=5e=5.
- Calcula d=29d=29d=29 (pois 5⋅29≡1(mod72)5 \cdot 29 \equiv 1 \pmod{72}5⋅29≡1(mod72)).

🔐 *Criptografia*:

Mensagem M=10M=10M=10.

C=Me(modn)=105(mod91)=82C = M^e \pmod{n} = 10^5 \pmod{91} = 82C=Me(modn)=105(mod91)=82.

🔑 *Descriptografia*:

M=Cd(modn)=8229(mod91)=10M = C^d \pmod{n} = 82^{29} \pmod{91} = 10M=Cd(modn)=8229(mod91)=10.

➡ Aplicação prática: usado em *assinaturas digitais, e-mails (PGP), protocolos de segurança (TLS/SSL)*.

## Exemplo Prático de ECC (Criptografia de Curvas Elípticas)

ECC usa *pontos em curvas elípticas* sobre corpos finitos.

Mais seguro que RSA para o mesmo tamanho de chave → por isso é usado em celulares e dispositivos de IoT.

### Curva exemplo:

Curva: y2=x3+ax+b(modp)y^2 = x^3 + ax + b \pmod{p}y2=x3+ax+b(modp).

Suponha p=17,a=2,b=2p=17, a=2, b=2p=17,a=2,b=2.

Um ponto válido na curva é P=(5,1)P=(5,1)P=(5,1).

Se usuário A escolhe chave privada kA=3k_A=3kA=3, a chave pública é QA=3PQ_A = 3PQA=3P.

➡ Na prática: A e B trocam chaves públicas, e ao combinar multiplicações chegam na *mesma chave secreta compartilhada*.

🔐 *Aplicação real: usado em **criptografia moderna (TLS com ECDHE), carteiras de Bitcoin, autenticação em celulares*.

## Onde são aplicados TLS/SSL na prática

1. *Navegação em sites seguros (HTTPS)*
    - Quando você acessa um site com cadeado 🔒 no navegador, ele está usando *TLS/SSL*.
    - Exemplo: bancos online, e-commerces, redes sociais, sistemas acadêmicos.
    - O certificado digital do site usa *RSA ou ECC* para autenticação, e depois gera uma chave simétrica (AES, por exemplo) para criptografar os dados da sessão.
2. *E-mails seguros*
    - Protocolos como *SMTPS, IMAPS, POP3S* usam TLS para proteger o envio e recebimento de e-mails.
    - O famoso *PGP* (Pretty Good Privacy) também pode se apoiar em RSA.
3. *Mensagens instantâneas*
    - Aplicativos como *WhatsApp, Signal, Telegram* usam variantes de protocolos baseados em TLS/ECDH para troca de chaves.
4. *VPNs (Redes Privadas Virtuais)*
    - Protocolos como *OpenVPN* usam TLS para autenticar servidor e cliente, garantindo que a conexão seja segura.
5. *Pagamentos online*
    - Toda compra com cartão em sites de e-commerce passa por TLS, protegendo a comunicação entre cliente, loja e processadora.

   Exemplos:

- *TLS/SSL é aplicado no HTTPS* (quando você abre qualquer site com “https://”).
- Está também em *WPA3* (mais novo que WPA2), que usa *SAE baseado em ECC* para autenticação segura no Wi-Fi.
