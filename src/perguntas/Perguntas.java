/*
    Nome do Projeto: Perguntados
    Data de Criação: 08/11/2022
    Versão: 7
    Data da Última Modificação: 01/06/2023
    Versão do Java: 17 (Oracle)
    Equipe de Desenvolvimento:
        - Juan Souza Santos
        - Kaick Santos Muniz
        - Pedro Ferreira Lima

    Descrição: Este programa é um jogo de perguntas e respostas onde os jogadores devem responder corretamente a uma série de perguntas aleatórias para acumular pontos e obter uma classificação.

    O programa possui funcionalidades como exibição de perguntas, cálculo de pontuação, classificação dos jogadores e armazenamento dos resultados em um banco de dados.

*/

// O pacote "perguntas" contém as classes relacionadas ao gerenciamento de perguntas e respostas no jogo.
package perguntas;

// Importações das classes necessárias para o funcionamento do programa.
import java.util.ArrayList;
import java.util.Collections;

public class Perguntas {

    // Criação de um ArrayList chamado "perguntasEResp" que armazenará objetos da classe "Questoes".
    ArrayList<Questoes> perguntasEResp = new ArrayList<>();

    // Método "perguntas" que recebe um parâmetro do tipo char e retorna um ArrayList de objetos da classe "Questoes". Esse método é responsável por gerar perguntas com base na escolha do jogador.
    public ArrayList<Questoes> perguntas(char escolha) {

        // Limpa o ArrayList "perguntasEResp" para garantir que esteja vazio antes de adicionar novas perguntas.
        perguntasEResp.clear();

        // Se a escolha for igual a 1, adiciona a lista as perguntas de nível fácil
        if (escolha == '1') {

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Ciências, Valendo 10 Pontos:\n" +
                    "Qual o metal cujo símbolo químico é o Au?\n" +
                    "A) Cobre\n" +
                    "B) Prata\n" +
                    "C) Mercúrio\n" +
                    "D) Ouro\n" + // reposta correta
                    "E) Manganês\n", "D", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Ciências, Valendo 10 Pontos:\n" +
                    "Quem foi o primeiro homem a pisar na Lua? Em que ano aconteceu?\n" +
                    "A) Yuri Gagarin, em 1961\n" +
                    "B) Buzz Aldrin, em 1969\n" +
                    "C) Charles Conrad, em 1969\n" +
                    "D) Charles Duke, em 1971\n" +
                    "E) Neil Armstrong, em 1969\n", "E", 10)); // reposta correta

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Ciências, Valendo 10 Pontos:\n" +
                    "Quanto tempo a luz do Sol demora para chegar à Terra?\n" +
                    "A) 12 minutos\n" +
                    "B) 1 dia\n" +
                    "C) 12 horas\n" +
                    "D) 8 minutos\n" + // reposta correta
                    "E) 12 segundos\n", "D", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Ciências, Valendo 20 Pontos:\n" +
                    "As pessoas de qual tipo sanguíneo são consideradas doadores universais\n" +
                    "A) Tipo A\n" +
                    "B) Tipo B\n" +
                    "C) Tipo O\n" + // reposta correta
                    "D) Tipo AB\n" +
                    "E) Tipo AB\n", "C", 20));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Ciências, Valendo 30 Pontos:\n" +
                    "Quais dos órgãos abaixo pertencem ao sistema respiratório?\n" +
                    "A) Laringe e traqueia\n" + // reposta correta
                    "B) Pulmões e faringe\n" +
                    "C) Esôfago e brônquios\n" +
                    "D) Tireoide e hipófise\n" +
                    "E) Pâncreas e vasos sanguíneos\n", "A", 30));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Matemática, Valendo 10 Pontos:\n" +
                    "Um ângulo de 90º é um ângulo?\n" +
                    "A) Reto\n" + // reposta correta
                    "B) Obtuso\n" +
                    "C) Agudo\n" +
                    "D) Raso\n" +
                    "E) Côncavo\n", "A", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Matemática, Valendo 10 Pontos:\n" +
                    "Quantos segundos há em duas horas?\n" +
                    "A) 2800\n" +
                    "B) 3600\n" +
                    "C) 6200\n" +
                    "D) 6900\n" +
                    "E) 7200\n", "E", 10)); // resposta correta

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Matemática, Valendo 10 Pontos:\n" +
                    "Quantos centímetros existem em 5 metros?\n" +
                    "A) 50 cm\n" +
                    "B) 500 cm\n" + // reposta correta
                    "C) 5000 cm\n" +
                    "D) 0,5 cm\n" +
                    "E) 0,05 cm\n", "B", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Matemática, Valendo 20 Pontos:\n" +
                    "Qual o maior número primo compreendido entre 30 e 40?\n" +
                    "A) 33\n" +
                    "B) 35\n" +
                    "C) 37\n" + // reposta correta
                    "D) 38\n" +
                    "E) 39\n", "C", 20));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Matemática, Valendo 30 Pontos:\n" +
                    "Um cubo possui 4 centímetros de altura, 2 centímetros de largura e 5 centímetros de comprimento. Qual é o volume dessa figura?\n"
                    +
                    "A) 8 centímetros cúbicos\n" +
                    "B) 8 metros cúbicos\n" +
                    "C) 8 centímetros quadrados\n" +
                    "D) 40 centímetros cúbicos\n" + // reposta correta
                    "E) 40 metros quadrados\n", "D", 30));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Esportes, Valendo 10 Pontos:\n" +
                    "Quando foi a primeira copa do mundo?\n" +
                    "A) 1950\n" +
                    "B) 1900\n" +
                    "C) 1930\n" + // reposta correta
                    "D) 1934\n" +
                    "E) 1926\n", "C", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Esportes, Valendo 10 Pontos:\n" +
                    "A cada quantos anos são realizados os Jogos Olímpicos?\n" +
                    "A) 2 anos\n" +
                    "B) 3 anos\n" +
                    "C) 4 anos\n" + // reposta correta
                    "D) 5 anos\n" +
                    "E) 6 anos\n", "C", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Esportes, Valendo 10 Pontos:\n" +
                    "Quanto tempo dura uma partida de futebol completa?\n" +
                    "A) 30 minutos\n" +
                    "B) 45 minutos\n" +
                    "C) 50 minutos\n" +
                    "D) 60 minutos\n" +
                    "E) 90 minutos\n", "E", 10)); // pesposta correta

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Esportes, Valendo 20 Pontos:\n" +
                    "Em que cidade está localizado o estádio popularmente conhecido como La Bombonera?\n" +
                    "A) Rio de Janeiro\n" +
                    "B) Buenos Aires\n" + // reposta correta
                    "C) Asunción\n" +
                    "D) Madri\n" +
                    "E) São paulo\n", "B", 20));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Esportes, Valendo 30 Pontos:\n" +
                    "Quem ganhou a Copa do Mundo de 2010?\n" +
                    "A) Brasil\n" +
                    "B) Argentina\n" +
                    "C) Alemanha\n" +
                    "D) Espanha\n" + // reposta correta
                    "E) França\n", "D", 30));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Conhecimentos Gerais, Valendo 10 Pontos:\n" +
                    "Qual é o substantivo usado para se referir a um grupo de lobos?\n" +
                    "A) Alcateia\n" + // reposta correta
                    "B) Rebanho\n" +
                    "C) Bando\n" +
                    "D) Matilha\n" +
                    "E) Lobos\n", "A", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Conhecimentos Gerais, Valendo 10 Pontos:\n" +
                    "Na mitologia grega, Zeus era filho de quem?\n" +
                    "A) Apolo\n" +
                    "B) Thor\n" +
                    "C) Urano\n" +
                    "D) Cronos\n" + // reposta correta
                    "E) Poseidon\n", "D", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Conhecimentos Gerais, Valendo 10 Pontos:\n" +
                    "Qual é o nome do maior osso do corpo humano?\n" +
                    "A) Fíbula\n" +
                    "B) Úmero\n" +
                    "C) Fêmur\n" + // reposta correta
                    "D) Rádio\n" +
                    "E) Tíbia\n", "C", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Conhecimentos Gerais, Valendo 20 Pontos:\n" +
                    "Onde se localiza Machu Picchu?\n" +
                    "A) Colômbia\n" +
                    "B) China\n" +
                    "C) Bolívia\n" +
                    "D) Índia\n" +
                    "E) Peru\n", "E", 20));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Fácil\n"+
                "\nTema: Conhecimentos Gerais, Valendo 30 Pontos:\n" +
                    "Quem inventou a lâmpada?\n" +
                    "A) Graham Bell\n" +
                    "B) Thomas Edison\n" + // reposta correta
                    "C) Henry Ford\n" +
                    "D) Santos Dumont\n" +
                    "E) Nikola Tesla\n", "B", 30));

            // Embaralha aleatoriamente a ordem das perguntas no ArrayList "perguntasEResp". Isso é feito utilizando o método shuffle da classe Collections, que randomiza a sequência dos elementos no ArrayList.
            Collections.shuffle(perguntasEResp);

            return perguntasEResp;

            // Se a escolha for diferente de 1, adiciona a lista as perguntas de nível difícil
        } else {

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Geografia, Valendo 10 Pontos:\n" +
                    "Qual é a capital do Acre?\n" +
                    "A) Rio Branco\n" + // reposta correta
                    "B) Amazonia\n" +
                    "C) Acre\n" +
                    "D) Rondonia\n" +
                    "E) Macapá\n", "A", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Geografia, Valendo 10 Pontos:\n" +
                    "Qual desses Países não é Europeu?\n" +
                    "A) Macedonia\n" +
                    "B) Espanha\n" +
                    "C) Grecia\n" +
                    "D) Casaquistão\n" + // reposta correta
                    "E) Polonia\n", "D", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Geografia, Valendo 10 Pontos:\n" +
                    "Em que continente está localizado o Catar?\n" +
                    "A) África\n" +
                    "B) Ásia\n" + // reposta correta
                    "C) Oceania\n" +
                    "D) América do Sul\n" +
                    "E) América Central\n", "B", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Geografia, Valendo 20 Pontos:\n" +
                    "Qual o maior país do mundo?\n" +
                    "A) China\n" +
                    "B) Brasil\n" +
                    "C) Canadá\n" +
                    "D) Estados Unidos\n" +
                    "E) Rússia\n", "E", 20));// resposta correta

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Geografia, Valendo 30 Pontos:\n" +
                    "Qual o rio mais longo mundo?\n" +
                    "A) Rio Nilo\n" + // reposta correta
                    "B) Rio Amazonas\n" +
                    "C) Rio Yangtze\n" +
                    "D) Rio Paraná\n" +
                    "E) Rio Congo\n", "A", 30));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: História, valendo 10 pontos:\n" +
                    "Qual personagem folclórico costuma ser agradado pelos caçadores com a oferta de fumo?\n" +
                    "A) Caipora\n" + // resposta correta
                    "B) Saci\n" +
                    "C) Lobisomem\n" +
                    "D) Boitatá\n" +
                    "E) Negrinho do Pastoreio\n", "A", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: História, valendo 10 pontos:\n" +
                    "Em que período da pré-história o fogo foi descoberto?\n" +
                    "A) Neolítico\n" +
                    "B) Paleolítico\n" + // resposta correta
                    "C) Idade dos Metais\n" +
                    "D) Período da Pedra Polida\n" +
                    "E) Idade Média\n", "B", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: História, valendo 10 pontos:\n" +
                    "Qual foi o recurso utilizado inicialmente pelo homem para explicar a origem das coisas?\n" +
                    "A) A Filosofia\n" +
                    "B) A Biologia\n" +
                    "C) A Matemática\n" +
                    "D) A Astronomia\n" +
                    "E) A Mitologia\n", "E", 10)); // resposta correta

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: História, valendo 20 pontos:\n" +
                    "Em que século o continente europeu foi devastado pela peste bubônica?\n" +
                    "A) No século X\n" +
                    "B) No século XI\n" +
                    "C) No século XII\n" +
                    "D) No século XIII\n" +
                    "E) No século XIV\n", "E", 20)); // resposta correta

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: História, valendo 30 pontos:\n" +
                    "Em que ano e onde aconteceu o maior acidente aéreo da história do Brasil?\n" +
                    "A) Ano 2007, em São Paulo\n" + // resposta correta
                    "B) Ano 2006, no Mato Grosso\n" +
                    "C) Ano 1982, no Ceará\n" +
                    "D) Ano 1996, em São Paulo\n" +
                    "E) Ano 1952, na Floresta Amazônica\n", "A", 30));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Conhecimentos Gerais, Valendo 10 Pontos:\n" +
                    "O que é filantropo?\n" +
                    "A) Pessoa que tem excesso de confiança\n" +
                    "B) Pessoa egoísta\n" +
                    "C) Pessoa que pratica a caridade\n" + // resposta correta
                    "D) Canto gregoriano\n" +
                    "E) Poema de quatro versos\n", "C", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Conhecimentos Gerais, Valendo 10 Pontos:\n" +
                    "Qual das alternativas contém apenas vacinas contra a covid-19?\n" +
                    "A) VIP/VOP e AstraZeneca\n" +
                    "B) CoronaVac e AstraZeneca\n" + // resposta correta
                    "C) HPV e BioNTech\n" +
                    "D) Pentavalente (DTPa) e Sputnik V\n" +
                    "E) Rotavírus e CoronaVac\n", "B", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Conhecimentos Gerais, Valendo 10 Pontos:\n" +
                    "Quantas casas decimais tem o número pi?\n" +
                    "A) Duas\n" +
                    "B) Centenas\n" +
                    "C) Infinitas\n" + // resposta correta
                    "D) Vinte\n" +
                    "E) Milhares\n", "C", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Conhecimentos Gerais, Valendo 20 Pontos:\n" +
                    "Qual o livro mais vendido no mundo a seguir à Bíblia?\n" +
                    "A) O Senhor dos Anéis\n" +
                    "B) Dom Quixote\n" + // resposta correta
                    "C) O Pequeno Príncipe\n" +
                    "D) Ela, a Feiticeira\n" +
                    "E) Um Conto de Duas Cidades\n", "B", 20));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Conhecimentos Gerais, Valendo 30 Pontos:\n" +
                    "Atualmente, quantos elementos químicos a tabela periódica possui?\n" +
                    "A) 113\n" +
                    "B) 109\n" +
                    "C) 108\n" +
                    "D) 118\n" + // resposta correta
                    "E) 92\n", "D", 30));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Ciências, Valendo 10 Pontos:\n" +
                    "Qual a ciência que estuda a atmosfera da Terra e a climatologia?\n" +
                    "A) Astronomia\n" +
                    "B) Metereologia\n" + // resposta correta
                    "C) Dispersão atmosférica\n" +
                    "D) Meteorologia\n" +
                    "E) Horologia\n", "B", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Ciências, Valendo 10 Pontos:\n" +
                    "De que são constituídos os diamantes?\n" +
                    "A) Grafite\n" +
                    "B) Rênio\n" +
                    "C) Carbono\n" +
                    "D) Ósmio\n" +
                    "E) Bóhrio\n", "C", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Ciências, Valendo 10 Pontos:\n" +
                    "O etanol é produzido através de qual fonte de energia?\n" +
                    "A) Solar\n" +
                    "B) Biomassa\n" + // resposta correta
                    "C) Eólica\n" +
                    "D) Geotérmica\n" +
                    "E) Hidrelétrica\n", "B", 10));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Ciências, Valendo 20 Pontos:\n" +
                    "Qual destas, apesar do seu nome, não é considerada um tipo de força?\n" +
                    "A) Força de atrito\n" +
                    "B) Força peso\n" +
                    "C) Força centrípeta\n" +
                    "D) Força eletromotriz\n" + // resposta correta
                    "E) Força normal\n", "D", 20));

            perguntasEResp.add(new Questoes("\n========== Jogo Perguntados ==========\n"+
            "Nível Difícil\n"+
                "\nTema: Ciências, Valendo 30 Pontos:\n" +
                    "Qual desses não é um instrumento meteorológico?\n" +
                    "A) Barógrafo\n" +
                    "B) Termômetro\n" +
                    "C) Pluviômetro\n" +
                    "D) Anemômetro\n" +
                    "E) Etilômetro\n", "E", 30)); // resposta correta

            // Embaralha aleatoriamente a ordem das perguntas no ArrayList "perguntasEResp". Isso é feito utilizando o método shuffle da classe Collections, que randomiza a sequência dos elementos no ArrayList.
            Collections.shuffle(perguntasEResp);

            return perguntasEResp;
        }
    }
}
