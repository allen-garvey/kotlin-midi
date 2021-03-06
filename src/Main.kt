/**
 * Created by Allen X on 3/23/16.
 */

package aged.main

import aged.midi.StatisticMidiParserListener
import java.io.File
import javax.sound.midi.*
import org.jfugue.midi.*
import org.jfugue.pattern.*
import org.jfugue.player.*
import org.staccato.*
import org.jfugue.parser.*
import java.util.*


fun main(args: Array<String>) {
    val start = System.currentTimeMillis()


    val parser : aged.midi.MidiParser = aged.midi.MidiParser()
    val midiFileName : String = System.getProperty("user.home") + "/Desktop/test4.mid"
    val midiFile : File = File(midiFileName)
    println("Midi file format is: " + MidiSystem.getMidiFileFormat(midiFile).type )
    parser.parse(midiFile)

    /*
    val midiFile : File = File(System.getProperty("user.home") + "/Desktop/test4.mid")
    val pattern = MidiFileManager.loadPatternFromMidi(midiFile)
    println(pattern)

    val parser : MidiParser = MidiParser()
    val listener = StatisticMidiParserListener()
    parser.addParserListener(listener)
    val sequence : Sequence = MidiSystem.getSequence(midiFile)
    parser.parse(sequence)
    println("Number of measures is: " + listener.measures)
    println("Number of notes is: " + listener.numNotes)
    println("Number of chords is: " + listener.numChords)
    println("Number of tempo changes is: " + listener.numTempoChanges)
    */


    val end = System.currentTimeMillis()
    println("Program time: " + (end  - start) + " milliseconds")

}
