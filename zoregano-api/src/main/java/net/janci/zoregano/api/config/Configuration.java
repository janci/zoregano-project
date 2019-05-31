package net.janci.zoregano.api.config;

import java.io.IOException;
import java.time.Duration;
import java.time.Period;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Class implement the interface represent configuration and simple way,
 * how to read values by specific type.
 */
public interface Configuration {

    /**
     * Checks whether a value is present and non-null at the given path.
     *
     * @param path the path expression
     * @return true if a non-null value is present at the path
     */
    boolean hasPath(String path);

    /**
     * Checks whether a value is present at the given path, even
     * if the value is null.
     *
     * @param path
     *            the path expression
     * @return true if a value is present at the path, even if the value is null
     */
    boolean hasPathOrNull(String path);

    /**
     *
     * @param path
     *            path expression
     * @return the boolean value at the requested path
     *
     */
    boolean getBoolean(String path);

    void setBoolean(String path, boolean value);

    /**
     * @param path
     *            path expression
     * @return the numeric value at the requested path
     */
    Number getNumber(String path);

    void setNumber(String path, Number value);

    /**
     * Gets the integer at the given path. If the value at the
     * path has a fractional (floating point) component, it
     * will be discarded and only the integer part will be
     * returned (it works like a "narrowing primitive conversion"
     * in the Java language specification).
     *
     * @param path
     *            path expression
     * @return the 32-bit integer value at the requested path
     */
    int getInt(String path);

    void setInt(String path, int value);

    /**
     * Gets the long integer at the given path.  If the value at
     * the path has a fractional (floating point) component, it
     * will be discarded and only the integer part will be
     * returned (it works like a "narrowing primitive conversion"
     * in the Java language specification).
     *
     * @param path
     *            path expression
     * @return the 64-bit long value at the requested path
     */
    long getLong(String path);

    void setLong(String path, Long value);

    /**
     * @param path
     *            path expression
     * @return the floating-point value at the requested path
     */
    double getDouble(String path);

    void setDouble(String path, double value);

    /**
     * @param path
     *            path expression
     * @return the string value at the requested path
     */
    String getString(String path);

    void setString(String path, String value);

    /**
     * @param enumClass
     *            an enum class
     * @param <T>
     *            a generic denoting a specific type of enum
     * @param path
     *            path expression
     * @return the {@code Enum} value at the requested path
     *              of the requested enum class
     */
    <T extends Enum<T>> T getEnum(Class<T> enumClass, String path);

    <T extends Enum<T>> void setEnum(Class<T> enumClass, String path, T value);

    /**
     * Gets a value as a size in bytes (parses special strings like "128M"). If
     * the value is already a number, then it's left alone; if it's a string,
     * it's parsed understanding unit suffixes such as "128K", as documented in
     * the <a
     * href="https://github.com/lightbend/config/blob/master/HOCON.md">the
     * spec</a>.
     *
     * @param path
     *            path expression
     * @return the value at the requested path, in bytes
     */
    Long getBytes(String path);

    void setBytes(String path, Long value);

    /**
     * Gets a value as a duration in a specified
     * {@link java.util.concurrent.TimeUnit TimeUnit}. If the value is already a
     * number, then it's taken as milliseconds and then converted to the
     * requested TimeUnit; if it's a string, it's parsed understanding units
     * suffixes like "10m" or "5ns" as documented in the <a
     * href="https://github.com/lightbend/config/blob/master/HOCON.md">the
     * spec</a>.
     *
     *
     * @param path
     *            path expression
     * @param unit
     *            convert the return value to this time unit
     * @return the duration value at the requested path, in the given TimeUnit
     */
    long getDuration(String path, TimeUnit unit);

    void setDuration(String path, TimeUnit unit, long value);

    /**
     * Gets a value as a java.time.Duration. If the value is
     * already a number, then it's taken as milliseconds; if it's
     * a string, it's parsed understanding units suffixes like
     * "10m" or "5ns" as documented in the <a
     * href="https://github.com/lightbend/config/blob/master/HOCON.md">the
     * spec</a>. This method never returns null.
     *
     * @param path
     *            path expression
     * @return the duration value at the requested path
     */
    Duration getDuration(String path);

    void setDuration(String path, Duration value);

    /**
     * Gets a value as a java.time.Period. If the value is
     * already a number, then it's taken as days; if it's
     * a string, it's parsed understanding units suffixes like
     * "10d" or "5w" as documented in the <a
     * href="https://github.com/lightbend/config/blob/master/HOCON.md">the
     * spec</a>. This method never returns null.
     *
     *
     * @param path
     *            path expression
     * @return the period value at the requested path
     */
    Period getPeriod(String path);

    void setPeriod(String path, Period value);

    /**
     * Gets a list value with boolean elements.  Throws if the
     * path is unset or null or not a list or contains values not
     * convertible to boolean.
     *
     * @param path
     *            the path to the list value.
     * @return the list at the path
     */
    List<Boolean> getBooleanList(String path);

    void setBooleanList(String path, List<Boolean> values);

    /**
     * Gets a list value with number elements.  Throws if the
     * path is unset or null or not a list or contains values not
     * convertible to number.
     *
     * @param path
     *            the path to the list value.
     * @return the list at the path
     */
    List<Number> getNumberList(String path);

    void setNumberList(String path, List<Number> values);

    /**
     * Gets a list value with int elements.  Throws if the
     * path is unset or null or not a list or contains values not
     * convertible to int.
     *
     * @param path
     *            the path to the list value.
     * @return the list at the path
     */
    List<Integer> getIntList(String path);

    void setIntList(String path, List<Integer> values);

    /**
     * Gets a list value with long elements.  Throws if the
     * path is unset or null or not a list or contains values not
     * convertible to long.
     *
     * @param path
     *            the path to the list value.
     * @return the list at the path
     */
    List<Long> getLongList(String path);

    void setLongList(String path, List<Long> values);

    /**
     * Gets a list value with double elements.  Throws if the
     * path is unset or null or not a list or contains values not
     * convertible to double.
     *
     * @param path
     *            the path to the list value.
     * @return the list at the path
     */
    List<Double> getDoubleList(String path);

    void setDoubleList(String path, List<Double> values);

    /**
     * Gets a list value with string elements.  Throws if the
     * path is unset or null or not a list or contains values not
     * convertible to string.
     *
     * @param path
     *            the path to the list value.
     * @return the list at the path
     */
    List<String> getStringList(String path);

    void setStringList(String path, List<String> values);


    /**
     * Gets a list value with {@code Enum} elements.  Throws if the
     * path is unset or null or not a list or contains values not
     * convertible to {@code Enum}.
     *
     * @param enumClass
     *            the enum class
     * @param <T>
     *            a generic denoting a specific type of enum
     * @param path
     *            the path to the list value.
     * @return the list at the path
     */
    <T extends Enum<T>> List<T> getEnumList(Class<T> enumClass, String path);

    <T extends Enum<T>> void setEnumList(Class<T> enumClass, String path, List<T> values);

    /**
     * Gets a list value with elements representing a size in
     * bytes.  Throws if the path is unset or null or not a list
     * or contains values not convertible to memory sizes.
     *
     * @param path
     *            the path to the list value.
     * @return the list at the path
     */
    List<Long> getBytesList(String path);

    void setBytesList(String path, List<Long> values);

    /**
     * Gets a list, converting each value in the list to a duration, using the
     * same rules as {@link #getDuration(String, TimeUnit)}.
     *
     * @param path
     *            a path expression
     * @param unit
     *            time units of the returned values
     * @return list of durations, in the requested units
     */
    List<Long> getDurationList(String path, TimeUnit unit);

    void setDurationList(String path, TimeUnit unit, List<Long> values);

    /**
     * Gets a list, converting each value in the list to a duration, using the
     * same rules as {@link #getDuration(String)}.
     *
     * @param path
     *            a path expression
     * @return list of durations
     */
    List<Duration> getDurationList(String path);

    void setDurationList(String path, List<Duration> values);

    /**
     * Persist configured keys for later usage.
     *
     * @param configName    new configuration name, that can be use to store.
     * @throws IOException  when any problem with persisting obtained.
     */
    void save(String configName) throws IOException;
}
