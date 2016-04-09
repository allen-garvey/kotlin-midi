/**
 * Created by Allen X on 4/9/16.
 */

package aged.midi

class TimeSignature(val numerator : Int = 4, val denominator : Int = 4){


    override fun toString() : String{
        return "$numerator/$denominator"
    }
}
