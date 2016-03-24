/**
 * Created by Allen X on 3/23/16.
 */

package aged.midi


import javax.sound.midi.*

class MidiPlayer{

    public fun play(){
        val channel : Int = 0 // 0 is a piano, 9 is percussion, other channels are for other instruments
        val volume : Int = 80 // between 0 et 127
        val duration : Long = 200 // in milliseconds

        try {
            val synth : Synthesizer = MidiSystem.getSynthesizer()

            synth.open()
            val channels : Array<MidiChannel>  = synth.getChannels()

            // --------------------------------------
            // Play a few notes.
            // The two arguments to the noteOn() method are:
            // "MIDI note number" (pitch of the note),
            // and "velocity" (i.e., volume, or intensity).
            // Each of these arguments is between 0 and 127.
            channels[channel].noteOn( 60, volume ) // C note
            Thread.sleep( duration )
            channels[channel].noteOff( 60 )
            channels[channel].noteOn( 62, volume ) // D note
            Thread.sleep( duration )
            channels[channel].noteOff( 62 )
            channels[channel].noteOn( 64, volume ) // E note
            Thread.sleep( duration )
            channels[channel].noteOff( 64 )

            Thread.sleep( 500 )

            // --------------------------------------
            // Play a C major chord.
            channels[channel].noteOn( 60, volume ) // C
            channels[channel].noteOn( 64, volume ) // E
            channels[channel].noteOn( 67, volume ) // G
            Thread.sleep( 3000 )
            channels[channel].allNotesOff()
            Thread.sleep( 500 )



            synth.close()
        }
        catch (e : Exception) {
            e.printStackTrace()
        }
    }
}
