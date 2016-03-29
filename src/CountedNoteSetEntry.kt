/**
 * Created by Allen X on 3/28/16.
 */

package aged.midi

class CountedNoteSetEntry(val noteName : String, var count : Int = 0) : Comparable<CountedNoteSetEntry>{

    override fun toString() : String{
        return "$noteName: $count"
    }

    override fun compareTo(other : CountedNoteSetEntry) : Int{
        return count.compareTo(other.count)
    }

    override fun equals(other : Any?) : Boolean{
        if(other is CountedNoteSetEntry){
            return noteName.equals(other.noteName)
        }
        return false
    }

}