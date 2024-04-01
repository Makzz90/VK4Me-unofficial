final class Class95 extends Thread {
   private final Class118 Field282;

   Class95(Class118 var1) {
      this.Field282 = var1;
   }

   public final void run() {
      try
      {
         synchronized(this.Field282._obj)
         {
            while(true)
            {
               if (this.Field282.IsMemoryOut || this.Field282.ScrollableHeight - this.Field282.Field813 - this.Field282.Field824 >= Class198.Instance._tbNormal.Height << 2 + Class198.Instance.CharSpaceWidth)
               {
                  this.Field282.IsLoading = false;
                  break;
               }

               this.Field282.Method20();
            }
         }
      }
      catch (Exception ex)
      {
         this.Field282.IsLoading = false;
         Class198.Instance.ShowError(ex);
      }
      catch (OutOfMemoryError var5)
      {
         this.Field282.IsLoading = false;
         this.Field282.ShowOutOfMemoryError();
      }

      Class198.Instance.SetInLoadingState(false);
   }
}
