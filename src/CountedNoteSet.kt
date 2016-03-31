/**
 * Created by allen on 3/24/16.
 */

package aged.midi


/**
 * Created by allen on 3/24/16.
 */


open class CountedNoteSet{
    val entriesArray : Array<CountedNoteSetEntry> = arrayOf(
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

    fun add(note : MidiNote){
        entriesArray[note.note].count++
    }
    fun sortedCollection() : Array<CountedNoteSetEntry>{
        return entriesArray.sortedArrayDescending()
    }
}