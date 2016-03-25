/**
 * Created by allen on 3/24/16.
 */

package aged.util


/**
 * Created by allen on 3/24/16.
 */


open class CountedNoteSet{
    val collection : MutableMap<String, Int> = mutableMapOf("A" to 0,
                                                            "Bb" to 0,
                                                            "B" to 0,
                                                            "C" to 0,
                                                            "C#" to 0,
                                                            "D" to 0,
                                                            "Eb" to 0, "E" to 0,
                                                            "F" to 0,
                                                            "F#" to 0,
                                                            "G" to 0,
                                                            "Ab" to 0
                                                            )

    fun add(item: String){
        val count : Int = collection.get(item) ?: 0
        if(count == 0){
            return
        }
        collection.put(item, count + 1)
    }
}