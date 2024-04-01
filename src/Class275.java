import javax.microedition.lcdui.Image;
//Этот класс присваивает все загруженные изображения
final class Class275 extends Thread {
   private final Class198 Field870;

   Class275(Class198 var1) {
      this.Field870 = var1;
   }

   public final void run() {
      while(!this.Field870.Field679.isEmpty())
      {
         Class463 var1= (Class463)this.Field870.Field679.firstElement();
         if (var1 != null)
         {
            for(int i = 0; i < var1.Count(); i++)
            {
               try
               {
                  Image img = var1.Method11(i) ? Class198.OpenImage(var1.GetUrl(i)) : Class198.Method477(var1.GetUrl(i));
                  if (img != null)
                  {
                        var1.SetImage(i, img);
                     
                  }
               } catch (Throwable th) {
                  var1.Error(th);
               }
            }

            var1.Method6();
            this.Field870.Field679.removeElement(var1);
            Class198.Instance.Repaint();
         }
      }

      System.gc();
      this.interrupt();
   }
}
