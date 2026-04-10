public class TestParking{
    public static void main(String[] args){
        Vehicule[] v = new Vehicule[4];

        v[0] = new Voiture("AA111","Renault",4);
        v[1] = new Voiture("BB222","Peugeot",2);
        v[2] = new Moto("11C22","Yamaha",true);
        v[3] = new Camion("CC333","Volvo",10000);

        System.out.println("Appel stationner() et afficher() pour tous :");
        for(Vehicule veh : v){
            veh.stationner();
            veh.afficher();
            System.out.println();
        }

        System.out.println("--- Véhicules de type Voiture uniquement ---");
        for(Vehicule veh : v){
            if(veh instanceof Voiture){
                Voiture car = (Voiture) veh;
                car.afficher();
                System.out.println();
            }
        }

        System.out.println("--- Test downcasting ---");
        Vehicule x = new Moto("11C22","Yamaha",true);
        try{
            Voiture v1 = (Voiture) x; // tentative de downcast incorrect
            System.out.println("Downcasting réussi !");
        }catch(ClassCastException e){
            System.out.println("Downcasting échoue : " + e.getClass().getSimpleName());
            System.out.println("Correction : vérifier le type avant de caster ou créer un objet du bon type.");
            if(x instanceof Voiture){
                Voiture v1b = (Voiture) x;
                System.out.println("(après instanceof) Downcasting réussi.");
            }else{
                System.out.println("x n'est pas une Voiture, impossible de caster.");
            }
        }
    }
}
