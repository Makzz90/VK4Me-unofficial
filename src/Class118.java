public class Class118 extends Page
{
	//используетс€ только в ConversationHistoryPage
   public final Object _obj = new Object();
   public boolean IsMemoryOut = false;
   public boolean IsDone = false;
   public boolean Initialized = false;
   public boolean IsLoading = false;
   public Class313 Field474;

   public Class118(Class313 var1)
   {
      super(Localized.GetString("title.historyContent"));//—траница истории
      this.Field474 = var1;
   }

   public final void Method0()
   {
      if (!this.Initialized && !this.IsLoading) {
         this.IsLoading = true;
         (new Class89(this)).start();
      }
   }

   public final Page ShowOutOfMemoryError()
   {
      this.IsMemoryOut = true;
      return super.ShowOutOfMemoryError();
   }

   public final void Method8()
   {
      if (!this.IsDone && this.Field813 < Class198.Instance._tbNormal.Height << 2 + Class198.Instance.CharSpaceWidth)
      {
         if (!this.IsLoading && !this.IsDone)
         {
            this.IsLoading = true;
            (new Class81(this)).start();
            return;
         }
      }
      else if (!this.IsMemoryOut && this.ScrollableHeight - this.Field813 - this.Field824 < Class198.Instance._tbNormal.Height << 2 + Class198.Instance.CharSpaceWidth)
      {
         if (this.IsLoading || this.IsMemoryOut)
         {
            return;
         }

//         this.IsLoading = true;
//         (new Class95(this)).start();//TODO похоже без этого не работает подгрузка после перемотки
      }

   }

   public void Method20() {
   }

   public void Method23() {
   }

   public void Method21() throws Exception {
   }
}
