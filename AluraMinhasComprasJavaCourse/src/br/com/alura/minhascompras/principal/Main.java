package br.com.alura.minhascompras.principal;

import br.com.alura.minhascompras.modelos.CartaoDeCredito;
import br.com.alura.minhascompras.modelos.Compra;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o Limite do seu Cartão de Crédito: ");
        double limite = input.nextDouble();
        input.nextLine(); // <- limpa o buffer do Scanner
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limite);

        int n = 1;
        while(n != 0){
            System.out.print("Digite o Nome do Item que deseja comprar: ");
            String descricao = input.next();

            System.out.print("Digite o Valor do Item: ");
            double valor = input.nextDouble();
            Compra compra = new Compra(descricao, valor);

            if (cartaoDeCredito.lancaCompra(compra)){
                System.out.print("\nCompra Realizada!\nDigite 0 para Sair ou 1 para Continuar: ");
                n = input.nextInt();
                System.out.println();
            } else {
                System.out.println("SALDO INSUFICIENTE!");
                break;
            }
        }

        System.out.println("-=====-=====-\nCompras Realizadas:");
        Collections.sort(cartaoDeCredito.getCompras());
        for (Compra c : cartaoDeCredito.getCompras()) {
            System.out.println(c.getDescricao() + " - " +c.getValor());
        }
        System.out.println("-=====-=====-");

        System.out.println("\nSaldo do Cartão: R$" + cartaoDeCredito.getSaldo());
    }
}