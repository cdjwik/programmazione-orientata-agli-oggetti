import java.util.Objects;

public class compito extends CompitoPol {

     public double  coef;
     public double expo;
    public compito(double coef, double expo) {
        this.coef = coef;
        this.expo = expo;

    }
    private double coef(double i) {
        return this.coef;
    }
    
    public compito() {
        this.coef = 0;
        this.expo = 0;

    }

    @Override
    public void evaluer(int x) {
        if (expo < 0) {
            throw new IllegalArgumentException("Change the sign");
        }
        System.out.println("il polinomio è " + coef * Math.pow(x, expo));
    }

       // return "il polinomio è " +this.coef (int)Math.pow(x, expo);




    @Override
    public void ajouter(compito p ) {

    compito c = new compito();
    c.coef = coef + p.coef;
    c.expo = expo + p.expo;
    this.coef = c.coef;
    this.expo = c.expo;
    }

    @Override
    public void  multiplier(compito p) {
        compito c;
        if (p == null) {
            throw new IllegalArgumentException("Non posso moltiplicare con p nullo");
        } else {
            c = new compito();
            c.coef = coef * p.coef;
            c.expo = expo + p.expo;
            this.coef = c.coef;
            this.expo = c.expo;
        }

    }

    /** @param p: REQUIRE not null
     @return: a new poly that is the result of
     symbolic differentiation */
    public double void  differentiate(compito p){
        p = Objects.requireNonNull(p);
        compito q = new compito();
        for (int i=1; i < p.degree(); i++){
            q = q.ajouter(new compito(p.coef(i)*i, i-1));
        }
        return(q);



    @Override
    public double degree() {
     return expo;

    }



}

   
    
