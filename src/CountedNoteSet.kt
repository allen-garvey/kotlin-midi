/**
 * Created by allen on 3/24/16.
 */

package aged.midi


/**
 * Created by allen on 3/24/16.
 */


open class CountedNoteSet{
    val entriesList: List<CountedNoteSetEntry> = listOf(
                                                            CountedNoteSetEntry(MidiNote(0)),
                                                            CountedNoteSetEntry(MidiNote(1)),
                                                            CountedNoteSetEntry(MidiNote(2)),
                                                            CountedNoteSetEntry(MidiNote(3)),
                                                            CountedNoteSetEntry(MidiNote(4)),
                                                            CountedNoteSetEntry(MidiNote(5)),
                                                            CountedNoteSetEntry(MidiNote(6)),
                                                            CountedNoteSetEntry(MidiNote(7)),
                                                            CountedNoteSetEntry(MidiNote(8)),
                                                            CountedNoteSetEntry(MidiNote(9)),
                                                            CountedNoteSetEntry(MidiNote(10)),
                                                            CountedNoteSetEntry(MidiNote(11))
                                                          )

    val sortedCollection : List<CountedNoteSetEntry>
        get() = entriesList.sortedDescending()

    //returns sorted collection with the base of the first note transposed
    //i.e. transpose so the first note starts on C
    fun normalizedSortedCollection(base : Int = 0) : List<CountedNoteSetEntry>{
        val sortedCollection = sortedCollection
        val normalizedBase : Int = base % 12
        val diff = normalizedBase - sortedCollection[0].note.note
        if(diff == 0){
            return sortedCollection
        }
        return sortedCollection.map { it -> it.note.transpose(diff); it }

    }

    fun add(note : MidiNote){
        entriesList[note.note].count++
    }

}