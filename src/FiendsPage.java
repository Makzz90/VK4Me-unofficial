final class FiendsPage extends Class446 {
   private final long _userId;

   FiendsPage(String var1, boolean var2, long userId)
   {
      super(var1, true);
      this._userId = userId;
   }

   public final void LoadData()
   {
      Class198.Instance.SetInLoadingState(true);
      if (this.next_from == null) {
         this.next_from = new Integer(-1);
      }

      this.next_from = new Integer(((Integer)this.next_from).intValue() + 1);
      Class52 var1 = new Class52(this._userId, 5, ((Integer)this.next_from).intValue() * 5);
      var1.SetOrder("hints");
      var1.GetResponse();
      Class198.Instance.SetInLoadingState(false);
      
      if (var1 != null && var1.GotSomeItems())
      {
         if (var1.Items.length < 5) {
            this.IsAllLoaded = true;
         }

         for(int i = 0; i < var1.Items.length; i++)
         {
            VKUser var3 = var1.Items[i];
            this.AddElement(LoginForm.GetHeaderElement(var3, false, false, true, false, this));
         }
      }
      else
      {
         this.IsAllLoaded = true;
         if (var1.error_code>0)
         {
            Class198.Instance.ShowError(var1.error_msg/*Localized.GetString("general.loadError")*/);
         }
      }

      
   }
}
