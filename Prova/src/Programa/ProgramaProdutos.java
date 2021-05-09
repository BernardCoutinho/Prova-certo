package Programa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classes.Produtos;
import Classes.Vendas;
import Telas.RelatorioProduto;
import Telas.TelaCadastro;
import Telas.TelaVender;
import Telas.TelaMenus;
public class ProgramaProdutos {
    
    public static void main(String[] args){
        List<Produtos> produto = new ArrayList<>();
        List<Vendas> venda = new ArrayList<>();
        TelaMenus tela = new TelaMenus();
        int opcao;
        Scanner ler = new Scanner(System.in);

        do{
            tela.menuPrincipal();
           
           opcao = ler.nextInt();
           ler.nextLine();
            switch(opcao){
                
                case 1:
                
                TelaCadastro cadastro = new TelaCadastro();
                cadastro.cadastroDeProdutos(ler, produto);
                
                break;

                case 2:
                     RelatorioProduto relatorio = new RelatorioProduto();
                     relatorio.exibirRelatorioProduto(ler, produto, venda);

                break;
                case 3:
                 TelaVender vender = new TelaVender();
                 vender.venderProduto(ler, produto, venda);                
                break;
                case 0:
                System.out.println("\nEncerrando aplicação");
                return;
                default:
                System.out.println("\nOpção inválida, verifique a opção desejada.");
            }

        }while(opcao!= 0);
        
        ler.close();
    }

}

