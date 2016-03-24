/**
 * Created by Allen X on 3/23/16.
 */

package aged.midi

import java.io.File
import javax.sound.midi.*

class MidiParser{

    val NOTE_ON : Int = 0x90
    val NOTE_OFF : Int = 0x80
    val NOTE_NAMES : Array<String> = arrayOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")

    public fun parse(){
        try {
            val sequence: Sequence = MidiSystem.getSequence(File("test.mid"))

            var trackNumber: Int = 0
            for (track: Track in  sequence.getTracks()) {
                trackNumber++
                println("Track " + trackNumber + ": size = " + track.size() + "\n")
                for (i: Int in 0..track.size()) {
                    val event: MidiEvent = track.get(i)
                    print("@" + event.getTick() + " ")
                    val message: MidiMessage = event.getMessage()
                    if (message is ShortMessage) {
                        val sm: ShortMessage = message
                        print("Channel: " + sm.getChannel() + " ")
                        if (sm.getCommand() == NOTE_ON) {
                            val key: Int = sm.getData1()
                            val octave: Int = (key / 12) - 1
                            val note: Int = key % 12
                            val noteName: String = NOTE_NAMES[note]
                            val velocity: Int = sm.getData2()
                            println("Note on, " + noteName + octave + " key=" + key + " velocity: " + velocity)
                        } else if (sm.getCommand() == NOTE_OFF) {
                            val key: Int = sm.getData1()
                            val octave: Int = (key / 12) - 1
                            val note: Int = key % 12
                            val noteName: String = NOTE_NAMES[note]
                            val velocity: Int = sm.getData2()
                            println("Note off, " + noteName + octave + " key=" + key + " velocity: " + velocity)
                        } else {
                            println("Command:" + sm.getCommand())
                        }
                    } else {
                        println("Other message: " + message.toString())
                    }
                }

                println()
            }
        }
        catch(e : Exception){
            println(e.message)
        }
    }
}
