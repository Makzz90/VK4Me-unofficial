final class DocumentsPage extends Class446 {
   DocumentsPage(String var1, boolean var2) {
      super(var1, true);
   }

   public final void LoadData()
   {
      Class198.Instance.SetInLoadingState(true);
      if (this.next_from == null)
      {
         this.next_from = new Integer(-1);
      }

      this.next_from = new Integer(((Integer)this.next_from).intValue() + 1);
      Class3 var1=new Class3(5, ((Integer)this.next_from).intValue() * 5);
      var1.GetResponse();
      Class198.Instance.SetInLoadingState(false);
      
      if (var1 != null && var1.Items != null && var1.Items.length > 0)
      {
         if (var1.Items.length < 5) {
            this.IsAllLoaded = true;
         }

         for(int i = 0; i < var1.Items.length; i++)
         {
        	 VKAttachment a= new VKAttachment();
        	 a.type="doc";
        	 a.doc = var1.Items[i];
            //VKDocument var3 = var1.Field155[i];
            this.AddElement(new AttachmentItemUC(a));
         }
      } else {
         this.IsAllLoaded = true;
         if (var1.error_code>0) {
            Class198.Instance.ShowError(var1.error_msg/*Localized.GetString("general.loadError")*/);
         }
      }

      
   }
}
