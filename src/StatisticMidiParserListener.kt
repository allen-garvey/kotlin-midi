/**
 * Created by Allen X on 3/31/16.
 */

package aged.midi

import org.jfugue.parser.ParserListener
import org.jfugue.theory.*


class StatisticMidiParserListener : ParserListener{
    var measures : Int = 0
    var numNotes : Int = 0
    var numChords : Int = 0

    override fun beforeParsingStarts(){

    }

    override fun afterParsingFinished(){

    }

    override fun onTrackChanged(var1 : Byte){

    }

    override fun onLayerChanged(var1 : Byte){

    }

    override fun onInstrumentParsed(var1 : Byte){

    }

    override fun onTempoChanged(var1 : Int){

    }

    override fun onKeySignatureParsed(var1 : Byte, var2 : Byte){

    }

    override fun onTimeSignatureParsed(var1 : Byte, var2 : Byte){

    }

    override fun onBarLineParsed(var1 : Long){
        measures += 1
    }

    override fun onTrackBeatTimeBookmarked(var1 : String){

    }

    override fun onTrackBeatTimeBookmarkRequested(var1 : String){

    }

    override fun onTrackBeatTimeRequested(var1 : Double){

    }

    override fun onPitchWheelParsed(var1 : Byte, var2 : Byte){

    }

    override fun onChannelPressureParsed(var1 : Byte){

    }

    override fun onPolyphonicPressureParsed(var1 : Byte, var2 : Byte){

    }

    override fun onSystemExclusiveParsed(vararg  var1 : Byte){

    }

    override fun onControllerEventParsed(var1 : Byte, var2 : Byte){

    }

    override fun onLyricParsed(var1 : String){

    }

    override fun onMarkerParsed(var1 : String){

    }

    override fun onFunctionParsed(var1 : String, var2 : Any){

    }

    override fun onNotePressed(var1 : Note){

    }

    override fun onNoteReleased(var1 : Note){

    }

    override fun onNoteParsed(var1 : Note){
        numNotes += 1
    }

    override fun onChordParsed(var1 : Chord){
        numChords += 1
    }
}
