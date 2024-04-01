public final class Class280 extends DataJson {
   public VKImageWithSize[] sizes;
   /*
   ��������� �������� ���� type

   a - 200x89
   b - 400x179
   c - 200x200
   d - 100x100
   e - 50x50
   k - 1074x480
   l - 537x240

   s � ���������������� ����� ����������� � ������������ �������� 75px;
   m � ���������������� ����� ����������� � ������������ �������� 130px;
   x � ���������������� ����� ����������� � ������������ �������� 604px;

   o � ���� ����������� "������/������" ��������� ����������� ������ ��� ����� 3:2, �� ���������������� ����� � ������������ ������� 130px. ���� ����������� "������/������" ������ 3:2, �� ����� ����������� ����� ����������� � ������������ ������� 130px � ������������ ������ 3:2.
   p � ���� ����������� "������/������" ��������� ����������� ������ ��� ����� 3:2, �� ���������������� ����� � ������������ ������� 200px. ���� ����������� "������/������" ������ 3:2, �� ����� ����������� ����� � ������ ����������� � ������������ ������� 200px � ������������ ������ 3:2.
   q � ���� ����������� "������/������" ��������� ����������� ������ ��� ����� 3:2, �� ���������������� ����� � ������������ ������� 320px. ���� ����������� "������/������" ������ 3:2, �� ����� ����������� ����� � ������ ����������� � ������������ ������� 320px � ������������ ������ 3:2.
   r � ���� ����������� "������/������" ��������� ����������� ������ ��� ����� 3:2, �� ���������������� ����� � ������������ ������� 510px. ���� ����������� "������/������" ������ 3:2, �� ����� ����������� ����� � ������ ����������� � ������������ ������� 510px � ������������ ������ 3:2

   y � ���������������� ����� ����������� � ������������ �������� 807px;
   z � ���������������� ����� ����������� � ������������ �������� 1080x1024;
   w � ���������������� ����� ����������� � ������������ �������� 2560x2048px.

   max
   temp
   */
   public final VKImageWithSize GetAppropriateForScaleFactor(int requiredSize, boolean var2)
   {
	   /*
      int var3 = -1;
      int var5 = -1;
      int var4 = Integer.MAX_VALUE;
      int w = Integer.MIN_VALUE;

      for(int i = 0; i < this.sizes.length; i++)
      {
         VKImageWithSize s = this.sizes[i];
         if (s != null)
         {
            if (s.width == requiredSize)
            {
               return s;
            }

            if (s.width > requiredSize && s.width < var4 && (!var2 || s.type == null || !s.type.equals("o") && !s.type.equals("p") && !s.type.equals("q") && !s.type.equals("r"))) {
               var4 = s.width;
               var3 = i;
            }

            if (s.width > w && (!var2 || s.type == null || !s.type.equals("o") && !s.type.equals("p") && !s.type.equals("q") && !s.type.equals("r"))) {
               w = s.width;
               var5 = i;
            }
         }
      }

      if (var3 != -1) {
         return this.sizes[var3];
      } else if (var5 != -1) {
         return this.sizes[var5];
      } else {
         return null;
      }
      */
	   for(int i = this.sizes.length - 1; i >= 0; i--)
       {
		   VKImageWithSize current = this.sizes[i];
		   if (requiredSize <= current.height)
           {
               return current;
           }
       }
       
	   return null;
      /* Sort!
       * string str = "";
            var enumerator = this.sizes.GetEnumerator();
            
            while (enumerator.MoveNext())
            {
                VKImageWithSize current = enumerator.Current;
                if (requiredHeight <= current.height)
                {
                    return current.url;
                }

                if(string.IsNullOrEmpty(str))
                    str = current.url;//� ������� ������� ��� �� ����������, ��� ��� ���� ������
            }

            return str;
       * */
       
   }

   public final DataJson ProcessFields(JSONObject json)
   {
      if (json == null)
      {
         return this;
      }
      else
      {
         JSONArray list= json.optJSONArray("sizes");
         if (list != null)
         {
            this.sizes = new VKImageWithSize[list.Count()];

            for(int i = 0; i < this.sizes.length; i++)
            {
               JSONObject o = list.Method508(i);
               if (o != null)
               {
                  this.sizes[i] = (VKImageWithSize)(new VKImageWithSize()).ProcessFields(o);
            	   //VKImageWithSize newSize =(VKImageWithSize)(new VKImageWithSize()).ProcessFields(o);
            	   
               }
            }
            
            this.bubbleSort(this.sizes);
         }

         return this;
      }
   }
   
	private void bubbleSort(VKImageWithSize[] p_array)
	{
		boolean anyCellSorted;
		int length = p_array.length;
		VKImageWithSize tmp;
		for (int i = length; --i >= 0;)
		{
			anyCellSorted = false;
			for (int j = 0; j < i; j++)
			{
				if (p_array[j].compareTo(p_array[j + 1]) > 0)
				{
					tmp = p_array[j];
					p_array[j] = p_array[j + 1];
					p_array[j + 1] = tmp;
					anyCellSorted = true;
				}

			}
			if (anyCellSorted == false)
			{
				return;
			}
		}
	}
}
