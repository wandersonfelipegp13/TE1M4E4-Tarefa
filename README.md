# Tarefa M4

Implementar em Pyton:

Pela análise de um processo de destilação fracionada de petróleo observou-se que determinado óleo
poderia ser classificado em duas classes de pureza {P1 e P2}, a partir da medição de três grandezas
{x1, x2 e x3}, que representam algumas de suas propriedades físico-químicas. A equipe de
engenheiros e cientistas pretende usar uma rede Perceptron para executar a classificação automática
das duas classes. 

Assim, baseado nas informações coletadas do processo, formou-se o conjunto de treinamento
apresentado no arquivo anexado, tomando por convenção o valor -1 para óleo pertencente à classe
P1 e o valor 1 para óleo pertencente à classe P2.

![algoritmo do perceptron](https://raw.githubusercontent.com/wandersonfelipegp13/TE1M4E4-Tarefa/master/src/info/algoritmo.png)

Utilizando o algoritmo de treinamento mostrado na figura anterior, com taxa de aprendizagem como
0,01, faça as seguintes atividades:

1. Execute cinco treinamentos para a rede Perceptron, iniciando-se o vetor de pesos {w} em cada
treinamento com valores aleatórios entre zero e um. Se for o caso, reinicie o gerador de números

2. Registre os resultados dos cinco treinamentos em uma tabela mostrando os valores do vetor de
pesos iniciais, o vetor de pesos finais e o número de épocas.

3. Após o treinamento do Perceptron, coloque este em operação, aplicando-o na classificação
automática das amostras de óleo da tabela abaixo, indicando ainda nesta tabela aqueles resultados
das saídas (classes) referentes aos cinco processos de treinamento realizados no item 1.

| **Amostra** |  **x1** |  **x2** | **x3** | **y (T1)** | **y (T2)** | **y (T3)** | **y (T4)** | **y (T5)** |
|:-----------:|:-------:|:-------:|:------:|:----------:|:----------:|:----------:|:----------:|:----------:|
|      1      |  0,3665 |  0,0620 | 5,9891 |            |            |            |            |            |
|      2      | -0,7842 |  1,1267 | 5,5912 |            |            |            |            |            |
|      3      |  0,3012 |  0,5611 | 508234 |            |            |            |            |            |
|      4      |  0,7757 |  1,0640 | 8,0677 |            |            |            |            |            |
|      5      |  0,1570 |  0,8028 | 6,3040 |            |            |            |            |            |
|      6      | -0,7014 |  1,0316 | 3,6005 |            |            |            |            |            |
|      7      |  0,3748 |  0,1536 | 6,1537 |            |            |            |            |            |
|      8      | -0,6920 |  0,9404 | 4,4058 |            |            |            |            |            |
|      9      | -1,3970 |  0,7141 | 4,9263 |            |            |            |            |            |
|      10     | -1,8842 | -0,2805 | 1,2548 |            |            |            |            |            |

*Tabela 1: Amostras de óleo para validar a rede Perceptron (ver arquivo anexo)*

4. Explique por que o número de épocas de treinamento, em relação a esta aplicação, varia a cada
vez que executamos o treinamento do perceptron.

5. Para a aplicação em questão, discorra se é possível afirmar se as suas classes são linearmente
separáveis.
