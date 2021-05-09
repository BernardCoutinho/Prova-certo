package Telas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Classes.Produtos;
import Classes.Vendas;

public class TelaVender{


    public void venderProduto(Scanner ler, List <Produtos> produto, List <Vendas> venda){

        System.out.println("\n=====Sistema de Vendas=====");
        System.out.println("\nDigite o código do produto");
         String codProd = ler.nextLine();
         
         
         boolean cod = false;
         for(Produtos produtos : produto){
         if(codProd.equals(produtos.getCodigo())){
            if(produtos.getEstoq()==0){
                System.out.println("\nProduto indisponivel");

            }else
            {
             cod = true;

             System.out.printf("\nNome do Produto: %s", produtos.getNome());
             System.out.printf("\nCodigo do produto: %s", produtos.getCodigo());
             System.out.printf("\nPreço do produto: %.2f", produtos.getValor());
             System.out.printf("\nEm estoque %d", produtos.getEstoq());
             System.out.println("\nDigite a quantidade");
             int quant = ler.nextInt();
             ler.nextLine();
             if(quant>produtos.getEstoq()){
                 System.out.println("\nQuantidade indisponivel.");
                 break;
             }else{
             System.out.println("\nDigite a data da venda.");
             
             DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
             String dataVenda = ler.nextLine();
             Double valorV = produtos.getValor()*quant;
             Vendas vender = new Vendas(LocalDate.parse(dataVenda, format), produtos, valorV, quant);
             venda.add(vender);                    
             
             produtos.setEstoq(produtos.getEstoq() - quant); 
           System.out.println("\nCompra realizada com sucesso"); 
            }
          }

          } 
             
         }   
         if(cod == false){
             System.out.println("Código inválido.");
         }
        
        
                                 
        

    }
}