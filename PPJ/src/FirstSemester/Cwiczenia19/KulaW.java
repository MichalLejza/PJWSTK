package PPJ.FirstSemester.Cwiczenia19;

public class KulaW
{
   private int promien;

   public KulaW(Kwadrat kwadrat)
   {
      this.promien = kwadrat.bok / 2;
   }

   public KulaW(Walec walec)
   {
      this.promien = walec.promien / 2;
   }

   public void show()
   {
      double objetosc = 4/3 * Math.PI * promien * promien * promien;
      double pole = 4 * Math.PI * promien * promien;
      System.out.println("Pole powierzchni : " + pole);
      System.out.println("Objetosc: " + objetosc);
   }
}
