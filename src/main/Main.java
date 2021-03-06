package main;

import java.io.IOException;

import observer.AuntListener;
import observer.GrandmaListener;
import observer.PublishManager;
import proxy.IYouTube;
import proxy.YouTubeApiReal;
import proxy.YouTubeProxy;
import strategy.CalculadoraDeImpostoStrategy;
import strategy.CalculadoraDeImpostosSemPadrao;
import strategy.IcmsStrategy;
import strategy.IpiStrategy;
import visitor.AcessoriosComVisitor;
import visitor.AcessoriosSemVisitor;
import visitor.CarroComVisitor;
import visitor.CarroSemVisitor;
import visitor.VeiculoVisitor;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
<<<<<<< Updated upstream
		
		comVisitor();
		semVisitor();
	
=======
		//semProxy();
		//comProxy();
		//semVisitor();
		//comVisitor();
		//semStrategy();
		//comStrategy();
		comObserver();
>>>>>>> Stashed changes
	}
	
	
	public static void semProxy() {
		IYouTube service = new YouTubeApiReal();
		System.out.println(service.getVideo("final champions"));
		System.out.println("");
		System.out.println(service.getVideo("final champions"));
		System.out.println("");
		System.out.println(service.getVideo("final champions"));
	}
	
	public static void comProxy() {
		IYouTube service = new YouTubeProxy();
		System.out.println(service.getVideo("final champions"));
		System.out.println("");
		System.out.println(service.getVideo("final champions"));
		System.out.println("");
		System.out.println(service.getVideo("final champions"));
		System.out.println("");
		System.out.println(service.getVideo("rock lee x gaara - link park"));
		System.out.println("");
		System.out.println(service.getVideo("rock lee x gaara - link park"));
	}

	public static void semVisitor() {
		CarroSemVisitor carro = new CarroSemVisitor("Fiat", "Toro");
	
	    AcessoriosSemVisitor acessorios = new AcessoriosSemVisitor("Black", "Pionner");
	
	    System.out.println("\n"+carro+"\n"+acessorios);
	}

	public static void comVisitor() {
		CarroComVisitor carro = new CarroComVisitor("Fiat", "Toro");
        VeiculoVisitor visitor = new VeiculoVisitor();

        AcessoriosComVisitor acessorios = new AcessoriosComVisitor("Black", "Pionner");

        System.out.println("\n"+visitor.exibirCarro(carro)+"\n"+visitor.exibirAcessorios(acessorios));
	}
	
	public static void comStrategy() {
		CalculadoraDeImpostoStrategy calculadora = new CalculadoraDeImpostoStrategy(); 
	    IcmsStrategy icms = new IcmsStrategy(100.0); 
	    IpiStrategy ipi = new IpiStrategy(100.0); 
	    System.out.println("\nICMS com padr??o => " + calculadora.calcularStrategy(icms)); 
	    System.out.println("IPI com padr??o => " + calculadora.calcularStrategy(ipi)); 
		
	}

	public static void semStrategy() {
		CalculadoraDeImpostosSemPadrao calculadora = new CalculadoraDeImpostosSemPadrao();
		System.out.println("\nICMS sem padr??o => " + calculadora.calcular("ICMS", 100));
		System.out.println("IPI sem padr??o => " + calculadora.calcular("IPI", 100));
	}
	
	public static void comObserver() {
		AuntListener tia = new AuntListener();
		GrandmaListener avo = new GrandmaListener();
		
		PublishManager pub = new PublishManager("nascimentos", "aniversarios", "festas");
		
		//vov? e titia querem saber quem anda nascendo
		pub.subscribe("nascimentos", avo);
		pub.subscribe("nascimentos", tia);
		//s? titia quer saber das festas
		pub.subscribe("festas", tia);
		
		pub.notify("nascimentos", "O bb de joana nasceu");
		System.out.println();
		pub.notify("festas", "amanha tem festa na Manu");
		System.out.println();
		pub.notify("nascimentos", "O filho de carlos nasceu");
		System.out.println();
		//titia n?o quer mais saber quem nasceu
		pub.unsubscribe("nascimentos", tia);
		
		pub.notify("nascimentos", "tem gemeos vindo a?");
	}
}
