
package aged.util


/**
 * Created by allen on 3/24/16.
 */


open class CountedSet<T> (t : T){
    val collection : MutableMap<T, Int> = mutableMapOf()

    fun add(item: T){
        val count : Int = collection.get(item) ?: 0
        collection.put(item, count + 1)
    }
}