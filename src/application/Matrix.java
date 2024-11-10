package application;

public class Matrix {

    private int[][] matrix; // Matriz para armazenar nós da árvore binária
    private int size; // Tamanho atual da árvore
    private final int maxNodes; // Número máximo de nós na árvore (definido pelo tamanho da matriz)

    // Inicializa a matriz com um número máximo de nós
    public Matrix(int maxNodes) {
        this.maxNodes = maxNodes;
        matrix = new int[maxNodes][2]; // Cria uma matriz para armazenar até maxNodes nós
        for (int i = 0; i < maxNodes; i++) {
            matrix[i][0] = -1; // Valor inicial indicando que não há nó à esquerda
            matrix[i][1] = -1; // Valor inicial indicando que não há nó à direita
        }
        size = 0;
    }

    // Insere um valor na matriz
    public void insert(int value) {
        if (size == 0) {
            // Se a árvore está vazia, define o nó raiz com valor
            matrix[size][0] = value;
            size++;
        } else {
            insert(0, value); // Chama o método de inserção recursiva a partir do índice 0 (raiz)
        }
    }

    // Método recursivo para inserir um valor na matriz
    private void insert(int index, int value) {
        if (index >= maxNodes) {
            System.out.println("A árvore está cheia.");
            return;
        }

        if (value < matrix[index][0]) { // Verifica se deve inserir à esquerda
            int leftIndex = 2 * index + 1;
            if (leftIndex < maxNodes && matrix[leftIndex][0] == -1) {
                matrix[leftIndex][0] = value;
                size++;
            } else {
                insert(leftIndex, value);
            }
        } else if (value > matrix[index][0]) { // Verifica se deve inserir à direita
            int rightIndex = 2 * index + 2;
            if (rightIndex < maxNodes && matrix[rightIndex][0] == -1) {
                matrix[rightIndex][0] = value;
                size++;
            } else {
                insert(rightIndex, value);
            }
        }
    }

    // Exibe a árvore em ordem simétrica (in-order traversal)
    public void inOrder(int index) {
        if (index >= maxNodes || matrix[index][0] == -1) return;
        inOrder(2 * index + 1); // Visita o nó à esquerda
        System.out.print(matrix[index][0] + " "); // Exibe o valor atual
        inOrder(2 * index + 2); // Visita o nó à direita
    }

    // Exibe a árvore em pré-ordem (pre-order traversal)
    public void preOrder(int index) {
        if (index >= maxNodes || matrix[index][0] == -1) return;
        System.out.print(matrix[index][0] + " "); // Exibe o valor atual
        preOrder(2 * index + 1); // Visita o nó à esquerda
        preOrder(2 * index + 2); // Visita o nó à direita
    }

    // Exibe a árvore em pós-ordem (post-order traversal)
    public void postOrder(int index) {
        if (index >= maxNodes || matrix[index][0] == -1) return;
        postOrder(2 * index + 1); // Visita o nó à esquerda
        postOrder(2 * index + 2); // Visita o nó à direita
        System.out.print(matrix[index][0] + " "); // Exibe o valor atual
    }

    // Método para remover um valor específico (com implementação básica)
    public void remove(int value) {
        int index = findIndex(0, value);
        if (index == -1) {
            System.out.println("Valor não encontrado na árvore.");
            return;
        }
        matrix[index][0] = -1; // Marca o nó como vazio
        System.out.println("Valor " + value + " removido da árvore.");
    }

    // Busca o índice de um valor na matriz
    private int findIndex(int index, int value) {
        if (index >= maxNodes || matrix[index][0] == -1) return -1;
        if (matrix[index][0] == value) return index;
        int leftIndex = findIndex(2 * index + 1, value); // Busca no lado esquerdo
        if (leftIndex != -1) return leftIndex;
        return findIndex(2 * index + 2, value); // Busca no lado direito
    }

    // Retorna o valor da raiz
    public int getRoot() {
        if (size > 0) {
            return matrix[0][0]; // A raiz é o primeiro valor inserido
        }
        return -1; // Caso a árvore esteja vazia
    }
}
