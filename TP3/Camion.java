public class Camion extends  Vehicule{
    private double chargeMax;
    public Camion(String matricule, String marque, double chargeMax){
        super(matricule, marque);
        this.chargeMax = chargeMax;
    }
    public double getChargeMax(){
        return this.chargeMax;
    }
    @Override
    public  void stationner(){
        System.out.println("Le camion se gare dans une zone pour véhicules lourds.");
    }
    @Override
    public void afficher(){
        super.afficher();
        System.out.println("Charge max : " + chargeMax);
    }
}