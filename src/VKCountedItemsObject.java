
public class VKCountedItemsObject {
	/// <summary>
    /// Общее количество элементов.
    /// </summary>
    public int count;

    /// <summary>
    /// Коллекция объектов.
    /// </summary>
    //public List<T> items;

    /// <summary>
    /// Список пользователей.
    /// </summary>
    public VKUser[] profiles;

    /// <summary>
    /// Список сообществ.
    /// </summary>
    public VKGroup[] groups;

    public String next_from;
}
