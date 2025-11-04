package valdez.francisco.dingdone

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(val nombre : String): Parcelable
