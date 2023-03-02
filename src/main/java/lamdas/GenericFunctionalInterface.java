package lamdas;

@FunctionalInterface
public interface GenericFunctionalInterface<T> {
    T process(T param);
}
