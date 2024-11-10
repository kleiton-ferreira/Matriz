package application;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int input = -1;
        String result;
        Matrix tree = new Matrix(15); // Criando a árvore com até 15 nós

        while (input != 0) {
            result = showMenu(); // Mostra o menu para o usuário

            if (result.equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um valor numérico!");
                result = showMenu();
            } else {
                input = Integer.parseInt(result);

                switch (input) {
                    case 1:
                        String item = JOptionPane.showInputDialog("Digite um número para inserir na árvore!");
                        tree.insert(Integer.parseInt(item));
                        break;
                    case 2:
                        String vl = JOptionPane.showInputDialog("Digite o valor que você deseja remover!");
                        tree.remove(Integer.parseInt(vl)); // Remoção por valor
                        break;
                    case 3:
                        // Exibe a raiz no terminal
                        System.out.println("Raiz da árvore: " + tree.getRoot());
                        break;
                    case 4:
                        System.out.println("Ordem Simétrica:");
                        tree.inOrder(0); // Exibe em ordem simétrica
                        System.out.println();
                        break;
                    case 5:
                        System.out.println("Pré-Ordem:");
                        tree.preOrder(0); // Exibe em pré-ordem
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("Pós-Ordem:");
                        tree.postOrder(0); // Exibe em pós-ordem
                        System.out.println();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                }
            }
        }
    }

    // Menu para escolher a operação
    public static String showMenu() {
        String result = JOptionPane.showInputDialog(
                "Digite:" +
                        "\n 1: Para inserir " +
                        "\n 2: Para remover" +
                        "\n 3: Para exibir a raiz " +
                        "\n 4: Para exibir ordem simétrica " +
                        "\n 5: Para exibir pré-ordem " +
                        "\n 6: Para exibir pós-ordem " +
                        "\n 0: Para sair");

        if (result == null) {
            result = "";
        }

        return result;
    }
}
