/**
 * Created by Allen X on 3/23/16.
 */



package aged.midi

import aged.util.CountedNoteSet
import java.io.File
import javax.sound.midi.*
import  com.sun.media.sound.*

class MidiParser{

    val NOTE_ON : Int = ShortMessage.NOTE_ON
    val NOTE_OFF : Int = ShortMessage.NOTE_OFF
    val NOTE_NAMES : Array<String> = arrayOf("C", "C#", "D", "Eb", "E", "F", "F#", "G", "Ab", "A", "Bb", "B")


    //adapted from: http://stackoverflow.com/questions/3850688/reading-midi-files-in-java
    fun parse(fileName : String){
            val sequence: Sequence = MidiSystem.getSequence(File(fileName))
            val noteSet : CountedNoteSet = CountedNoteSet()
            var trackNumber: Int = 0
            val tracks : Array<Track> = sequence.tracks
            println("There are " + tracks.size  + " tracks")

            for (track : Track in tracks) {
                trackNumber++
                println("Track " + trackNumber + ": size = " + track.size() + "\n")
                for (i: Int in 0..track.size() - 1) {
                    val event: MidiEvent = track.get(i)
                    //print("@" + event.getTick() + " ")
                    val message: MidiMessage = event.getMessage()
                    if (message is ShortMessage) {
                        val sm: ShortMessage = message
                        print("Channel: " + sm.getChannel() + " ")
                        if (sm.getCommand() == NOTE_ON) {
                            val key: Int = sm.getData1()
                            val octave: Int = (key / 12) - 1
                            val note: Int = key % 12
                            val noteName: String = NOTE_NAMES[note]
                            noteSet.add(noteName)
                            val velocity: Int = sm.getData2()
                            println("Note on, " + noteName + octave + " key=" + key + " velocity: " + velocity)
                        }
                        else if (sm.getCommand() == NOTE_OFF) {
                            val key: Int = sm.getData1()
                            val octave: Int = (key / 12) - 1
                            val note: Int = key % 12
                            val noteName: String = NOTE_NAMES[note]
                            val velocity: Int = sm.getData2()
                            //println("Note off, " + noteName + octave + " key=" + key + " velocity: " + velocity)
                        }
                        else {
                            //println("Command:" + sm.getCommand())
                        }
                    }
                    else {
                        //println("Other message: " + message.toString())
                        if(message is MetaMessage){
                            val meta : MetaMessage = message
                            //println(meta.data[0])
                        }
                    }

                }
                println()
            }
            println(noteSet.collection)

    }
}
