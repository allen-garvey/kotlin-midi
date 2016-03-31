package aged.midi

import javax.sound.midi.ShortMessage

/**
 * Created by Allen X on 3/28/16.
 */

class MidiNote(var keyNum : Int, val velocity : Int = 60){
    val NOTE_NAMES : Array<String> = arrayOf("C", "C#", "D", "Eb", "E", "F", "F#", "G", "Ab", "A", "Bb", "B")

    val octave: Int
        get() = (keyNum / 12) - 1
    val note: Int
        get(){
            val normalizedKeyNum = if(keyNum < 0)  (keyNum % 12) + 12 else keyNum
            return Math.abs(normalizedKeyNum % 12)
        }
    val noteName: String
        get() = NOTE_NAMES[note]

    constructor(sm : ShortMessage) : this(sm.data1, sm.data2){

    }
    fun transpose(amount : Int){
        keyNum += amount
    }
}