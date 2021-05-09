package Telas;

import java.util.DoubleSummaryStatistics;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import Classes.Produtos;
import Classes.Vendas;


public class RelatorioProduto {

  
     
   
    
      public void exibirRelatorioProduto(Scanner ler, List<Produtos> produto, List<Vendas> venda){
         DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
         int x;

         do{
            System.out.println("\n=======Relatórios=======");
            System.out.println("\nDigite a opção ou 0 para sair.");
            System.out.println("\n1 - Produtos");
            System.out.println("\n2 - Vendas por periodo - Detalhado");
            System.out.println("\n3 - Vendas por periodo - Consolidado");
            x = ler.nextInt();
            ler.nextLine();
            
            
              
              switch(x){ 

               case 1:
                  System.out.println("====== Relatorio de Produtos ======");         
                           
                  System.out.printf("%-10.10s\t%-12.12s\t%-20.20s\t%-15.15s\n",         
                  "Código", "Produto", "Valor ", "Estoque");         
                  for (Produtos p : produto) {             
                  System.out.printf("%-10.10s\t%-12.12s\tR$ %-20.20s\t%-15.15s\n",             
                  p.getCodigo(), p.getNome(), p.getValor(), p.getEstoq()); 
                  }
                  DoubleSummaryStatistics estatis = produto.stream()
                  .collect(Collectors.summarizingDouble(v -> v.getValor()));
                  System.out.printf("\nValor Médio : %.2f\nMaior Valor : %.2f\nMenor Valor : %.2f", estatis.getAverage(), 
                  estatis.getMax(), estatis.getMin());
               break;

               case 2:
                
               System.out.println("\n====== Vendas por Periodo ======");
               System.out.println("-------Relatório Detalhado-------");
               System.out.println("Digite a data inicial ou ENTER para sair.");
               String dataI = ler.nextLine();
               if(dataI.isBlank()){
               System.out.println("Voltando");
               break;
                }
               
               System.out.println("Digite a data final");
               String dataF = ler.nextLine();
               
               LocalDate dataFinal = LocalDate.parse(dataF, df);
               LocalDate dataInicial = LocalDate.parse(dataI, df);
   

              
               List<Vendas> vendasDetalhado = venda.stream().filter(v -> 
               v.getData().plusDays(1).isAfter(dataInicial) &&
               v.getData().plusDays(-1).isBefore(dataFinal))
               .collect(Collectors.toList());
              
               System.out.println("=================================================================================================");
               System.out.printf("%-10.10s\t%-12.12s\t%-20.20s\t%-15.15s\t%-15.15s\n%-25.25s\n", "Produto:", "Data:",
               "Valor unitário:", "Valor da venda:", "Quantidade:", "Venda Média");
                 
               DoubleSummaryStatistics valorM = vendasDetalhado.stream()
                  .collect(Collectors.summarizingDouble(v -> v.getValorVendaTotal()));
                  
                 vendasDetalhado.forEach(v -> System.out.printf(
                  "%-10.10s\t%-12.12s\t%-20.20s\t%-15.15s\t%-25.25s\n", v.getProdutos().getNome(), 
                  v.getData().format(df), "R$:" + v.getProdutos().getValor(), "R$" + v.getValorVendaTotal(), 
                  v.getQuantVendida()));
                  System.out.println("-------------------------------------------------------------------------------------------------");
                  System.out.printf("Valor Médio: %.2f\n", valorM.getAverage());
                  System.out.println("=================================================================================================");
                  System.out.println("Aperte ENTER para voltar.");

                  String op = ler.nextLine();
                  if(op.isBlank()){
                     break;
                  }

                  
               
                  break;
            
            case 3:

                
               System.out.println("\n====== Vendas por Periodo ======");
               System.out.println("-------Relatório Consolidado.-------");
               System.out.println("Digite a data inicial ou ENTER para sair.");
               
                dataI = ler.nextLine();
               if(dataI.isBlank()){
               System.out.println("Voltando");
               break;
                }

               
               System.out.println("Digite a data final");
                dataF = ler.nextLine();
                dataFinal = LocalDate.parse(dataF, df);
                dataInicial = LocalDate.parse(dataI, df);

                List<Vendas> vendasConsolidado = venda.stream().filter(v -> 
               v.getData().plusDays(1).isAfter(dataInicial) &&
               v.getData().plusDays(-1).isBefore(dataFinal))
               .collect(Collectors.toList());
               System.out.println("=================================================================================================");
               System.out.printf("%-10.10s\t%-12.12s\t%-20.20s\t%-15.15s\t%-25.25s\n", "Produto:", "Data:",
               "Valor unitário:", "Valor da venda:", "Quantidade:");
                
               DoubleSummaryStatistics valorMax = vendasConsolidado.stream()
               .collect(Collectors.summarizingDouble(v -> v.getValorVendaTotal()));
 
               vendasConsolidado.forEach(v -> System.out.printf(
                  "%-10.10s\t%-12.12s\tR$%-20.20s\tR$ %-15.15s\t%-25.2s\n", v.getProdutos().getNome(), 
                  v.getData().format(df), v.getProdutos().getValor(), v.getValorVendaTotal(), v.getQuantVendida()));             
               System.out.println("-------------------------------------------------------------------------------------------------");
               System.out.printf("Valor Máximo: %.2f\n", valorMax.getMax());
               System.out.println("=================================================================================================");
                 System.out.println("Digite ENTER para sair.");
                 String op1 = ler.nextLine();
                 if(op1.isBlank()){
                    break;
                 }
                 break;
                 

            
            
               case 0:
            System.out.println("Voltando.");
            
              
               break;
               default:
               System.out.println("ERRO! Digite uma opção válida.");

              
              
               }
                    

            


           }while(x!=0);

         
      }
}
