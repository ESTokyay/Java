import java.util.*;

public class Main {
    public static void main(String[] args) {
      Employee irem=new Employee("Sinan",13000,60,2020);
      irem.toString();
  }
}


public class Employee
{
  public String FullName;
  public float Salary;
  public int workHours;
  public int hireYear;
  
  public Employee(String N,float S,int W,int H)
  {
    this.FullName=N;
    this.Salary=S;
    this.workHours=W;
    this.hireYear=H;
  }
  
  public float Tax(){
    if(this.Salary<1000.0f)
    {
      return 0.0f;
    }else{
      return this.Salary * 0.03f;
    }
  }
  
  public float bonus(){
    float saatbasiTutar= 30.0f;
    
    if(this.workHours > 40){
      int fazladanCalismaSaati=this.workHours-40;
      return fazladanCalismaSaati* saatbasiTutar;
    }else{
      return 0.0f;
    }
  }
  
  public float reiseSalary(){
    int simdikiYil=2021;
    int calismaYili=simdikiYil - this.hireYear;
    float vergibonusMaas=(this.Salary-this.Tax()+this.bonus());  //nasıl bir hesap olduğunu belirtilmediği için bu şekilde düşünüldü.
    
    if(calismaYili<10){
      return vergibonusMaas*0.05f;
    }
    else if(9<calismaYili && calismaYili<20){
      return vergibonusMaas* 0.1f;
    }
    else{
      return vergibonusMaas * 0.15f;
    }
  }
  
  public String toString(){
    
    String ad=this.FullName;
    float maas=this.Salary;
    int calismaSaati=this.workHours;
    int baslangicYili=this.hireYear;
    float vergi=this.Tax();
    float bonus=this.bonus();
    float bonusVergiMaas=maas+bonus-vergi;
    float maasArtis=this.reiseSalary();
    float toplamMaas=bonusVergiMaas*4f;
    
    System.out.println("Adı= "+ad);
    System.out.println("Haftalık Maaş=" + maas);
    System.out.println("Çalışma Saati=" + calismaSaati);
    System.out.println("Başlangıç Yılı=" + baslangicYili);
    System.out.println("Vergisi=" + vergi);
    System.out.println("Bonus=" + bonus);
    System.out.println("Bonus-Vergi Maaş=" + bonusVergiMaas);
    System.out.println("Maaş Artışı=" + maasArtis);
    System.out.println("Toplam Maaş=" + toplamMaas);
    
    return "";
  }
  
}
