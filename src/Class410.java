final class Class410 extends Class446 {
   private final long Field1152;
   private final int Field1153;

   Class410(String var1, boolean var2, long var3, int var5) {
      super(var1, true);
      this.Field1152 = var3;
      this.Field1153 = var5;
   }

   public final void LoadData() {
      Class198.Instance.SetInLoadingState(true);
      if (this.next_from == null) {
         this.next_from = new Integer(-1);
      }

      this.next_from = new Integer(((Integer)this.next_from).intValue() + 1);
      Class461 var1=new Class461(this.Field1152, this.Field1153, ((Integer)this.next_from).intValue() * 5, 5);
      var1.GetResponse();
      if (var1 != null && var1.Field1348 != null && var1.Field1348.length > 0) {
         if (var1.Field1348.length < 5) {
            this.IsAllLoaded = true;
         }

         for(int i = 0; i < var1.Field1348.length; i++) {
        	 VKAttachment attach = new VKAttachment();
        	 attach.photo = var1.Field1348[i];
            //VKPhoto var3 = var1.Field1348[i];
            this.AddElement(new AttachmentItemUC(attach/*var3*/));
         }
      } else {
         this.IsAllLoaded = true;
         if (var1 == null) {
            Class198.Instance.ShowError(Localized.GetString("general.loadError"));
         }
      }

      Class198.Instance.SetInLoadingState(false);
   }
}
