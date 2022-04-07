# Documentation

## `public DynamicArray()`

Create empty DynamicArray of size equal to INITIAL_SIZE

## `public DynamicArray(int customSize)`

Create empty DynamicArray of specified size

 * **Parameters:** `customSize` — 

## `public DynamicArray(E[] initialArray)`

Create DynamicArray from array

 * **Parameters:** `initialArray` — 

## `public int getLength()`

Get length of DynamicArray

 * **Returns:** length

## `public void add(E element)`

Add element to the end of DynamicArray

 * **Parameters:** `element` — 

## `public E set(int index, E element)`

Set element at given index

 * **Parameters:**
   * `index` — 
   * `element` — <p>
 * **Returns:** oldValue

     <p>
 * **Exceptions:** `IndexOutOfBoundsException` — if index is out of bounds

## `public void insert(int index, E element)`

Insert element at given index

 * **Parameters:**
   * `index` — 
   * `element` — <p>
 * **Exceptions:** `IndexOutOfBoundsException` — if index is out of bounds

## `public E get(int index)`

Get element from give index

 * **Parameters:** `index` — <p>
 * **Exceptions:** `IndexOutOfBoundsException` — if index is out of bounds

## `public int indexOf(E element)`

Get index of first occurance of element

 * **Parameters:** `element` — 

## `public boolean contains(E element)`

Returns true if DynamicArray contains element

 * **Parameters:** `element` — <p>
 * **Returns:** boolean

## `public E remove(int index)`

Remove element from index

 * **Parameters:** `index` — <p>
 * **Returns:** removed

## `public void remove(E element)`

Remove first occurance of element

 * **Parameters:** `element` — 

## `public E[] subarray(int fromIndex, int toIndex)`

Get subarray of DynamicArray

 * **Parameters:**
   * `fromIndex` — 
   * `toIndex` — <p>
 * **Returns:** subArray

     <p>
 * **Exceptions:**
   * `IndexOutOfBoundsException` — when fromIndex or toIndex is out of bounds
   * `IllegalArgumentException` — if fromIndex > toIndex

## `public void clear()`

Clears DynamicArray

