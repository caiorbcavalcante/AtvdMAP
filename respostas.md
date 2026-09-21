Respostas da atividade

1. O que acontece com a classe Pedido toda vez que uma nova forma de
frete precisa ser adicionada? Em outras palavras, qual o problema com esta solução?

Precisa ser colocada separadamente na classe Pedido com uma condicional, o problema e que fica muito manual e nenhum pouco facil de entender e com adicao de novas formas fica inviavel (Alto acoplamento).

1. Qual problema o padrão Strategy resolve?

Ele resolve o problema de ter várias formas de fazer a mesma coisa, como calcular o frete, todas misturadas dentro de uma única classe. Com o Strategy, cada forma de cálculo fica em sua própria classe, e todas seguem a mesma interface. O Pedido só escolhe qual usar, sem precisar saber como o cálculo é feito, e ainda pode trocar de estratégia em tempo de execução.

2. O que aconteceria se usássemos apenas if/else?

O Pedido teria um método grande, cheio de if e else if para cada tipo de frete. A cada regra nova, seria preciso mexer nessa classe que já funciona, com o risco de quebrar o que estava certo. O método iria crescendo, ficaria difícil de ler e de testar, e a classe acabaria com responsabilidades demais. Se esse mesmo if/else se repetisse em outros pontos do sistema, cada alteração teria que ser feita em todos eles.

3. Como o sistema fica aberto para extensão?

O Pedido depende da interface Strategy e não das classes concretas. Por isso, para incluir o frete internacional, bastou criar a classe FreteInternacional, sem alterar o Pedido, a interface ou as outras estratégias. Isso é o princípio aberto/fechado: o sistema está aberto para receber novas classes e fechado para modificações no código que já funciona.

4. O que acontece se cada país tiver uma regra de cálculo diferente no frete internacional?

O sistema continua funcionando bem, porque basta criar uma nova estratégia para cada regra. Dá para fazer uma classe por país, como FreteEUA e FretePortugal, ou uma única classe que recebe a taxa e o multiplicador pelo construtor, quando as regras têm o mesmo formato e mudam só os valores. O país deve ser informado na hora de criar a estratégia, e não no método calcularFrete, para não obrigar as outras estratégias a receberem um parâmetro que não usam. Para escolher a estratégia certa a partir do país, normalmente se usa uma Factory ou um Map, o que evita que o if/else volte a aparecer no código.

5. Em quais outros cenários Strategy poderia ser utilizado?

Ele serve sempre que existem várias maneiras de fazer a mesma tarefa e você quer poder trocar entre elas. Alguns exemplos são as formas de pagamento (cartão, Pix, boleto), o cálculo de descontos (cupom, cliente fiel, promoção), a ordenação de listas (o Comparator do Java é um Strategy), o cálculo de rotas (a pé, de carro, de bicicleta), os tipos de autenticação (senha, biometria, login com Google) e a compressão de arquivos (ZIP, RAR, GZIP).

### Extra 

1. Essas regras são novas estratégias de cálculo ou promoções?

São promoções. Uma estratégia responde "como calcular o frete?" (Sedex, PAC, Internacional). Uma promoção não é uma nova forma de calcular: ela pega um cálculo que já existe e, dependendo de uma condição, altera o resultado. No caso do frete grátis acima de R$ 399, o cálculo do Sedex continua sendo o mesmo. A promoção só decide se o cliente paga ou não.

2. Elas deveriam modificar Sedex, PAC, Internacional e demais regras de cálculo?

Não. Se colocássemos um if (valorCompra > 399) dentro de cada classe, a mesma regra ficaria repetida em todas. Cada promoção nova (desconto de 10%, frete grátis para clientes fiéis) exigiria mexer em todas as classes de novo, e uma classe que só deveria calcular frete passaria a conhecer regras de marketing. Seria voltar ao problema do if/else, só que espalhado.