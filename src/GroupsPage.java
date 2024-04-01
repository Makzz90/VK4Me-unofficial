final class GroupsPage extends Class446 {
   private final long _userId;

   GroupsPage(String title, boolean var2, long userId) throws Exception {
      super(title, true);
      this._userId = userId;
   }

   public final void LoadData()
   {
      Class198.Instance.SetInLoadingState(true);
      if (this.next_from == null)
      {
         this.next_from = new Integer(-1);
      }

      this.next_from = new Integer(((Integer)this.next_from).intValue() + 1);
      //System.out.println(((Integer)this.next_from).intValue() + " ");
      Class273 var4 = new Class273(this._userId, 5, ((Integer)this.next_from).intValue() * 5);
      
      
      var4.AddParameter("filter", "groups,publics,events");
//      Class294 var4;
      //
//      var4=new Class294();
//      JSONObject temp = var1.GetResponse();
//      var4.ProcessFields(temp);
      //
      var4.GetResponse();
      Class198.Instance.SetInLoadingState(false);
      
      if (var4 != null && var4.GotSomeGroups())
      {
         if (var4.items.length < 5) {
            this.IsAllLoaded = true;
         }

         for(int i = 0; i < var4.items.length; i++)
         {
            VKGroup group = var4.items[i];
            this.AddElement(LoginForm.GetHeaderElement(group, false, false, true, false, this));
         }
      }
      else
      {
         this.IsAllLoaded = true;
         if (var4.error_code>0)
         {
            Class198.Instance.ShowError(var4.error_msg/*Localized.GetString("general.loadError")*/);
         }
      }

      
   }
}
