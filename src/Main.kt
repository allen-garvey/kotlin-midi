/**
 * Created by Allen X on 3/23/16.
 */

package aged.midi

import java.io.File
import javax.sound.midi.MidiSystem

fun main(args: Array<String>) {
    println("hello")
    //val player = MidiPlayer()
    //player.play()
    val parser = MidiParser()
    val midiFileName : String = System.getProperty("user.home") + "/Desktop/test4.mid"
    println("Midi file format is: " + MidiSystem.getMidiFileFormat(File(midiFileName)).type )

    parser.parse(midiFileName)
}
