package exemples.bank;

public class Operation extends Thread{
    private Compte cp;

    public Operation(String name, Compte cp) {
        super(name);
        this.cp = cp;
    }

    public void run() {
        while(true){
            cp.deposerArgent((int)(Math.random() * (100 - 1 + 1) + 1));
            cp.retirerArgent((int)(Math.random() * (200 - 1 + 1) + 1));
            if(cp.getSomme() < 0) {
                System.out.println("le compte a:" +cp.getSomme());

            }
        }
    }
}
