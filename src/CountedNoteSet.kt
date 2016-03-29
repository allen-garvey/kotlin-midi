/**
 * Created by allen on 3/24/16.
 */

package aged.midi


/**
 * Created by allen on 3/24/16.
 */


open class CountedNoteSet{
    val entriesArray : Array<CountedNoteSetEntry> = arrayOf(
                                                            CountedNoteSetEntry("C"),
                                                            CountedNoteSetEntry("C#"),
                                                            CountedNoteSetEntry("D"),
                                                            CountedNoteSetEntry("Eb"),
                                                            CountedNoteSetEntry("E"),
                                                            CountedNoteSetEntry("F"),
                                                            CountedNoteSetEntry("F#"),
                                                            CountedNoteSetEntry("G"),
                                                            CountedNoteSetEntry("Ab"),
                                                            CountedNoteSetEntry("A"),
                                                            CountedNoteSetEntry("Bb"),
                                                            CountedNoteSetEntry("B")
                                                          )

    fun add(note : MidiNote){
        //entriesArray[note.note].count = entriesArray[note.note].count + 1
        entriesArray[note.note].count++
    }
    fun sortedCollection() : Array<CountedNoteSetEntry>{
        return entriesArray.sortedArrayDescending()
    }
}