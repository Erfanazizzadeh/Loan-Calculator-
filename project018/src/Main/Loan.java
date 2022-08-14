package Main;

public class Loan {
    private  double principal;
    private int duration;
    private double annualInterestRate;
    public  Loan(double principal,int duration,double annualInterestRate){
        this.principal=principal;
        this.duration=duration;
        this.annualInterestRate=annualInterestRate;
    }
    public double getPrincipal(){
        return this.principal;
    }
    public void setPrincipal(double principal){
        this.principal=Math.max(principal,0);
    }
    public int getDuration(){
        return this.duration;
    }
    public void setDuration(int duration){
        this.duration=Math.max(duration,1);
    }
    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate=Math.max(annualInterestRate,0);
    }
    // Mothly interestRate
    public double getMonthlyIntrestRate(){
        return getAnnualInterestRate()/12;
    }
    //MonthlyPayment
    public double getMonthlyPayment(){
       double p = this.getPrincipal();
       double j =this.getMonthlyIntrestRate()/100;
       int n = this.getDuration();
       double M = p*j/(1-Math.pow(1+j,-n));
        return M;
    }
    //TotalPayment
    public double getTotalPayment(){
       double m = getMonthlyPayment();
       int n = this.getDuration();
        return n*m;
    }
    //TotalIntrest
    public double getTotalIntrest(){
        return this.getTotalPayment()-this.getPrincipal();
    }
    public double getMonthlyIntrest() {
        return this.getTotalIntrest()/this.getDuration();
    }
    public double getAnnualIntrest(){return  getMonthlyIntrest()*12;}
}
