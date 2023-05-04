public interface ChangeEvent<T> {
    void event(T oldValue, T newValue);
}
