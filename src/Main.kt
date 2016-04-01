/**
 * Created by Allen X on 3/23/16.
 */

package aged.midi

import java.io.File
import javax.sound.midi.MidiSystem
import org.jfugue.midi.*
import org.jfugue.pattern.*
import org.jfugue.player.*
import org.staccato.*



fun main(args: Array<String>) {
    val start = System.currentTimeMillis()

    /*
    val parser = MidiParser()
    val midiFileName : String = System.getProperty("user.home") + "/Desktop/test.mid"
    println("Midi file format is: " + MidiSystem.getMidiFileFormat(File(midiFileName)).type )
    parser.parse(midiFileName)
    */


    val pattern = MidiFileManager.loadPatternFromMidi(File(System.getProperty("user.home") + "/Desktop/test.mid"))
    println(pattern)

    
    val end = System.currentTimeMillis()
    println("Program time: " + (end  - start) + " milliseconds")
}
