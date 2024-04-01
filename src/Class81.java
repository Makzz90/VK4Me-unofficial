final class Class81 extends Thread {
   private final Class118 Field226;

   Class81(Class118 var1) {
      this.Field226 = var1;
   }

   public final void run() {
      try {
         synchronized(this.Field226._obj) {
            while(true) {
               if (this.Field226.IsDone || this.Field226.Field813 >= Class198.Instance._tbNormal.Height << 2 + Class198.Instance.CharSpaceWidth) {
                  this.Field226.IsLoading = false;
                  break;
               }

               this.Field226.Method21();
            }
         }
      } catch (Exception var4) {
         this.Field226.IsLoading = false;
         Class198.Instance.ShowError(var4);
      } catch (OutOfMemoryError var5) {
         this.Field226.IsLoading = false;
         this.Field226.ShowOutOfMemoryError();
      }

      Class198.Instance.SetInLoadingState(false);
   }
}
