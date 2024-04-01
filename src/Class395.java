final class Class395 extends Class446 {
   private final long Field1138;

   Class395(String var1, boolean var2, long var3)  {
      super(var1, true);
      this.Field1138 = var3;
   }

   public final void LoadData()  {
      Class198.Instance.SetInLoadingState(true);
      if (this.next_from == null) {
         this.next_from = new Integer(-1);
      }

      this.next_from = new Integer((((Integer)this.next_from)).intValue() + 1);
      int var1 = ((Integer)this.next_from).intValue() * 5;
      //Class429 var10000 = (new Class429()).Method77(this.Field1138);
      //boolean var2 = true;
      //Class429 var3 = var10000;
      //var10000.AddParameter("count", String.valueOf(5));
      //var3.AddParameter("offset", var1 == -1 ? null : String.valueOf(var1));
      Class429 var5=new Class429();
      var5.Method77(this.Field1138);
      var5.AddParameter("count", String.valueOf(5));
      var5.AddParameter("offset", var1 == -1 ? null : String.valueOf(var1));
      var5.GetResponse();
      
      if (var5 != null && var5.Items != null && var5.Items.length > 0) {
         if (var5.Items.length < 5) {
            this.IsAllLoaded = true;
         }

         for(int i = 0; i < var5.Items.length; i++)
         {
            VKAudio var4 = var5.Items[i];
            this.AddElement(LoginForm.Method270(var4, i + var1));
         }
      } else {
         this.IsAllLoaded = true;
         if (var5 == null) {
            Class198.Instance.ShowError(Localized.GetString("general.loadError"));
         }
      }

      Class198.Instance.SetInLoadingState(false);
   }
}
