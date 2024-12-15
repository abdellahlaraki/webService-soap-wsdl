package client;

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        BanqueService proxy=new BanqueWS().getBanqueServicePort();
        System.out.println("----------------");
        System.out.println(proxy.conversionEuroToDh(123000));
        System.out.println("------------------");
        Compte compte=proxy.getCompte(1);
        System.out.println(compte.getCode());
        System.out.println(compte.getSolde());
        System.out.println(compte.getDateCreation());
        System.out.println("-------------------");
        List<Compte> comptes=proxy.getComptes();
        comptes.forEach(cp -> {
                    System.out.println(cp.getCode());
                    System.out.println(cp.getSolde());
                    System.out.println(cp.getDateCreation());
                }
        );

    }
}
