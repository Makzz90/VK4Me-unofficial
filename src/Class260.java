final class Class260 extends Thread {
   private final Class446 _page;

   Class260(Class446 var1)
   {
      this._page = var1;
   }

   public final void run() {
      try {
         synchronized(this._page._obj) {
            while(true)
            {
               if (this._page.IsAllLoaded || this._page.ScrollableHeight - this._page.Field813 - Class198.Instance.Field646 >= Class198.Instance._tbNormal.Height << 2 + Class198.Instance.CharSpaceWidth) {
                  this._page.Field1227 = false;
                  break;
               }

               this._page.LoadData();
            }
         }
      }/*
      catch (Exception ex)
      {
         Class198.Field618.Method486(ex);
      }*/
      catch (OutOfMemoryError var5)
      {
         this._page.ShowOutOfMemoryError();
      }

      Class198.Instance.SetInLoadingState(false);
   }
}
