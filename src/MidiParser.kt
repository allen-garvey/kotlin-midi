/**
 * Created by Allen X on 3/23/16.
 */



package aged.midi

import java.io.File
import javax.sound.midi.*
import  com.sun.media.sound.*

class MidiParser{

    val META_MESSAGE_TIME_SIGNATURE : Int = 0x58

    fun parse(midiFile : File){
        parse(MidiSystem.getSequence(midiFile))
    }


    //adapted from: http://stackoverflow.com/questions/3850688/reading-midi-files-in-java
    fun parse(sequence : Sequence){
        if(sequence.divisionType == Sequence.PPQ){
            println("Sequence timing is PPQ")
            println("Resolution is " + sequence.resolution + " ticks per quarter")
        }
        val noteSet : CountedNoteSet = CountedNoteSet()
        var trackNumber: Int = 0
        val tracks : Array<Track> = sequence.tracks
        println("There are " + tracks.size  + " tracks")

        for (track : Track in tracks) {
            trackNumber++
            println("Track " + trackNumber + " has " + track.size() + " midi events\n")
            for (i: Int in 0..track.size() - 1) {
                val event: MidiEvent = track.get(i)
                val message: MidiMessage = event.getMessage()
                if (message is ShortMessage) {
                    val sm: ShortMessage = message
                    if (sm.getCommand() == ShortMessage.NOTE_ON) {
                        val midiNote = MidiNote(sm)
                        noteSet.add(midiNote)
                        println(midiNote.toString() + " started at " + event.tick + " ticks")
                        //println("Note on, " + noteName + octave + " key=" + key + " velocity: " + velocity)
                    }
                    else if (sm.getCommand() == ShortMessage.NOTE_OFF) {
                        val midiNote = MidiNote(sm)
                        //println("Note off, " + noteName + octave + " key=" + key + " velocity: " + velocity)
                    }

                }
                else if(message is MetaMessage){
                    val timeSignature : TimeSignature? = decodeTimeSignature(message)
                    if(timeSignature is TimeSignature) println(timeSignature)
                }


            }
        }
        val sortedNoteCollection = noteSet.sortedCollection
        for(noteSetEntry : CountedNoteSetEntry in sortedNoteCollection){
            println(noteSetEntry)
        }
        println("\nNormalized collection ")
        val normalizedSortedNoteCollection = noteSet.normalizedSortedCollection()
        for(noteSetEntry2 : CountedNoteSetEntry in normalizedSortedNoteCollection){
           println(noteSetEntry2)
        }


    }

    fun decodeTimeSignature(message : MetaMessage) : TimeSignature?{
        val messageData : ByteArray = message.data
        if(message.type == META_MESSAGE_TIME_SIGNATURE){
            val numerator : Int =  messageData[0].toInt()
            val denominator : Int =  Math.pow(2.0, messageData[1].toDouble()).toInt()
            return TimeSignature(numerator, denominator)
        }
        return null
    }
}
